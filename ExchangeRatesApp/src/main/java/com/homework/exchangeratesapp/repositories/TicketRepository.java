package com.homework.exchangeratesapp.repositories;

import com.homework.exchangeratesapp.models.Ticket;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

  List<Ticket> findAll();
}
