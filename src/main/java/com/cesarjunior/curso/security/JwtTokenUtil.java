package com.cesarjunior.curso.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//classe responsável por manipular o token.
public class JwtTokenUtil {

	// definição da estrutura do token.
	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_CREATED = "created";
	static final String CLAIM_KEY_EXPIRED = "exp";

	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private Long expiration;

	// método responsável por pegar o nome do usuário no token.
	public String getUsernameFromToken(String token) {
		String username;

		try {
			final Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}

		return username;
	}

	// método responsável por retornar a data de expiração do token:
	public Date getExpirationDateFromToken(String token) {
		Date dateExpiration;

		try {
			final Claims claims = getClaimsFromToken(token);
			dateExpiration = claims.getExpiration();
		} catch (Exception e) {
			dateExpiration = null;
		}

		return dateExpiration;
	}

	// método responsável por realizar o parsing do token nas informações nele
	// contida:
	public Claims getClaimsFromToken(String token) {
		Claims claims;

		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}

		return claims;
	}
	
	//método para verificar se o token está expirado:
	public Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	//método para gerar um token:
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());

		final Date createdDate = new Date();
		claims.put(CLAIM_KEY_EXPIRED, createdDate);
		
		return doGenerateToken(claims);
	}

	//método auxiliar para gerar e compactar o token.
	private String doGenerateToken(Map<String, Object> claims) {
		final Date createdDate = (Date) claims.get(CLAIM_KEY_EXPIRED);
		final Date expirationDate = new Date(createdDate.getTime() + expiration * 1000);
		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	//método para verificar se o token pode ser atualizado.
	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token));
	}

	//método para atualizar token.
	public String refreshToken(String token) {
		String refreshToken;
		try {
			final Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshToken = doGenerateToken(claims);
		} catch (Exception e) {
			refreshToken = null;
		}
		return refreshToken;
	}
	
	//método que valida o token.
	public Boolean validateToken(String token, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		 final String username = getUsernameFromToken(token);
		 return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}
}
