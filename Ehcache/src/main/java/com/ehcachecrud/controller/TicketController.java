package com.ehcachecrud.controller;

import com.ehcachecrud.api.TicketService;
import com.ehcachecrud.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/Ticket")
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @PutMapping("/Ticket")
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    @GetMapping("/Ticket/{id}")
    public Ticket getTicket(@PathVariable long tId) {
        return ticketService.getTicket(tId);
    }

    @DeleteMapping("/Ticket/{id}")
    public String deleteTicket(@PathVariable long tId) {
        return ticketService.deleteTicket(tId);
    }
}
