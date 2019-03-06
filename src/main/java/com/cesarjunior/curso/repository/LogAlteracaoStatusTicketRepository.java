package com.cesarjunior.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cesarjunior.curso.domain.LogAlteracaoStatusTicket;

public interface LogAlteracaoStatusTicketRepository extends MongoRepository<LogAlteracaoStatusTicketRepository, String>{
	
	Iterable<LogAlteracaoStatusTicket> findByTicketIdOrderByDataAlteracaoDesc(String ticketId);

}
