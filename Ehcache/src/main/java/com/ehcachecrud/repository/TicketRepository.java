package com.ehcachecrud.repository;

import com.ehcachecrud.dto.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {}
