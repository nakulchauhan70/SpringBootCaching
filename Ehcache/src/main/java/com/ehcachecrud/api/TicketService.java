package com.ehcachecrud.api;

import com.ehcachecrud.dto.Ticket;

public interface TicketService {
    Ticket addTicket(Ticket Ticket);

    Ticket updateTicket(Ticket Ticket);

    Ticket getTicket(long tId);

    String deleteTicket(long tId);
}
