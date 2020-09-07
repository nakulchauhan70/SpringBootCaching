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
    @CachePut(cacheNames = "ticketCache", key = "#ticket.ticketId")
    public Ticket updateTicket(Ticket ticket) {
        Optional<Ticket> ticket1 = ticketRepository.findById(ticket.getTicketId());
        if(ticket1.isPresent()) {
            ticket1.get().setPassengerName(ticket.getPassengerName());
            return ticketRepository.save(ticket1.get());
        }
        logger.info("Ticket updated with new name");
        return ticket;
    }

    @Override
    @Cacheable(cacheNames = "ticketCache", key = "#ticketId")
    public Ticket getTicket(Long ticketId) {
        logger.info("fetching Ticket from db");
        Optional<Ticket> Ticket = ticketRepository.findById(ticketId);
        return Ticket.orElseGet(com.ehcachecrud.dto.Ticket::new);
    }

    @Override
    @CacheEvict(cacheNames = "ticketCache", key = "#ticketId")
    public String deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
        return "Ticket deleted";
    }

}
