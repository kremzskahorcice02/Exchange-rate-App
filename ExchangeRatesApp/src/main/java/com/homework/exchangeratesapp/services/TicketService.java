package com.homework.exchangeratesapp.services;

import com.homework.exchangeratesapp.models.Ticket;
import java.util.List;

public interface TicketService {

  List<Ticket> getAllDbTickets();
}
