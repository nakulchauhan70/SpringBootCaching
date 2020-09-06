package com.ehcachecrud.api;

import com.ehcachecrud.dto.Ticket;
import com.ehcachecrud.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket addTicket(Ticket Ticket) {
        logger.info("adding Ticket with id - {}", Ticket.getTicketId());
        return ticketRepository.save(Ticket);
    }

    @Override
    @CachePut(cacheNames = "Tickets", key = "#Ticket.id")
    public Ticket updateTicket(Ticket ticket) {
        ticketRepository.findById(ticket.getTicketId());
        logger.info("Ticket updated with new name");
        return ticket;
    }

    @Override
    @Cacheable(cacheNames = "Tickets", key = "#id")
    public Ticket getTicket(long id) {
        logger.info("fetching Ticket from db");
        Optional<Ticket> Ticket = ticketRepository.findById(id);
        return Ticket.orElseGet(com.ehcachecrud.dto.Ticket::new);
    }

    @Override
    @CacheEvict(cacheNames = "Tickets", key = "#id")
    public String deleteTicket(long id) {
        ticketRepository.deleteById(id);
        return "Ticket deleted";
    }

}
