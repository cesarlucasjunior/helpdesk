package com.cesarjunior.curso.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cesarjunior.curso.domain.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	Page<Ticket> findByUsuarioIdOrderByDataAberturaDesc(Pageable page, String idUsuario);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusTicketIgnoreCaseContainingAndPrioridadeIgnoreCaseContaingOrderByDataAberturaDesc(
			Pageable pagina, String titulo, String statis, String prioridade);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusTicketIgnoreCaseContainingAndPrioridadeIgnoreCaseContaingAndUsuarioIdOrderByDataAberturaDesc(
			Pageable pagina, String titulo, String statis, String prioridade);

	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusTicketIgnoreCaseContainingAndPrioridadeIgnoreCaseContaingAndUsuarioDesignadoIdOrderByDataAberturaDesc(
			Pageable pagina, String titulo, String statis, String prioridade);
	
	Page<Ticket> findByNumeroIdentificacao(String numeroId);

}
