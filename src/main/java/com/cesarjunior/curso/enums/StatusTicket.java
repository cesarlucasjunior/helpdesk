package com.cesarjunior.curso.enums;

public enum StatusTicket {

	NOVO,
	DESIGNADO,
	RESOLVIDO,
	APROVADO,
	REPROVADO,
	FECHADO;
	
	public static StatusTicket getStatus(String status) {
		switch (status) {
			case "NOVO" : return NOVO;
			case "DESIGNADO" : return DESIGNADO;
			case "RESOLVIDO" : return RESOLVIDO;
			case "APROVADO" : return APROVADO;
			case "REPROVADO" : return REPROVADO;
			case "FECHADO" : return FECHADO;
		default: return NOVO;
		}
	}
}
