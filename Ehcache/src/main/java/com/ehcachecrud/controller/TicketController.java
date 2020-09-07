package com.ehcachecrud.controller;

import com.ehcachecrud.api.TicketService;
import com.ehcachecrud.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket-management")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @PutMapping("/ticket")
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    @GetMapping("/ticket/{ticketId}")
    public Ticket getTicket(@PathVariable("ticketId") Long ticketId) {
        return ticketService.getTicket(ticketId);
    }

    @DeleteMapping("/ticket/{ticketId}")
    public String deleteTicket(@PathVariable("ticketId") Long ticketId) {
        return ticketService.deleteTicket(ticketId);
    }
}
