package com.cesarjunior.curso.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cesarjunior.curso.enums.StatusTicket;

@Document
public class LogAlteracaoStatusTicket {

	@Id
	private String id;

	@DBRef
	private Ticket ticket;

	@DBRef
	private Usuario usuario;

	private Date dataAlteracao;

	private StatusTicket statusCorrente;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public StatusTicket getStatusCorrente() {
		return statusCorrente;
	}

	public void setStatusCorrente(StatusTicket statusCorrente) {
		this.statusCorrente = statusCorrente;
	}

}
