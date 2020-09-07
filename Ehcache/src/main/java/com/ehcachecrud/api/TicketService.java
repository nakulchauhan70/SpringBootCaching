package com.ehcachecrud.api;

import com.ehcachecrud.dto.Ticket;

public interface TicketService {
    Ticket addTicket(Ticket Ticket);

    Ticket updateTicket(Ticket Ticket);

    Ticket getTicket(Long tId);

    String deleteTicket(Long tId);
}
