package com.cesarjunior.curso.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cesarjunior.curso.enums.PrioridadeTicket;
import com.cesarjunior.curso.enums.StatusTicket;

@Document
public class Ticket {

	@Id
	private String id;

	@DBRef(lazy = true)
	private Usuario usuario;

	private Date dataAbertura;

	private String titulo;

	private String numeroIdentificacao;

	private StatusTicket statusTicket;

	private PrioridadeTicket prioridade;

	@DBRef(lazy = true)//Cria o usuario em cascata e não separadamente.
	private Usuario usuarioDesignado;

	private String descricao;

	private String imagem;

	@Transient
	private List<LogAlteracaoStatusTicket> alteracoes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNumeroIdentificacao() {
		return numeroIdentificacao;
	}

	public void setNumeroIdentificacao(String numeroIdentificacao) {
		this.numeroIdentificacao = numeroIdentificacao;
	}

	public StatusTicket getStatusTicket() {
		return statusTicket;
	}

	public void setStatusTicket(StatusTicket statusTicket) {
		this.statusTicket = statusTicket;
	}

	public PrioridadeTicket getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeTicket prioridade) {
		this.prioridade = prioridade;
	}

	public Usuario getUsuarioDesignado() {
		return usuarioDesignado;
	}

	public void setUsuarioDesignado(Usuario usuarioDesignado) {
		this.usuarioDesignado = usuarioDesignado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<LogAlteracaoStatusTicket> getAlteracoes() {
		return alteracoes;
	}

	public void setAlteracoes(List<LogAlteracaoStatusTicket> alteracoes) {
		this.alteracoes = alteracoes;
	}

}
