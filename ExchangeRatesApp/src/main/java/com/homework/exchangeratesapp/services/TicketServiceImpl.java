package com.homework.exchangeratesapp.services;

import com.homework.exchangeratesapp.models.Ticket;
import com.homework.exchangeratesapp.repositories.TicketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{
  private final TicketRepository ticketRepository;

  @Autowired
  public TicketServiceImpl(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  @Override
  public List<Ticket> getAllDbTickets() {
    return ticketRepository.findAll();
  }
}
