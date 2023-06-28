package com.homework.exchangeratesapp.controllers;

import com.homework.exchangeratesapp.models.Ticket;
import com.homework.exchangeratesapp.services.TicketServiceImpl;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicketController {

  private final TicketServiceImpl ticketService;

  @Autowired
  public TicketController(TicketServiceImpl ticketService) {
    this.ticketService = ticketService;
  }

  @GetMapping("/exchangerates")
  public ResponseEntity<?> retrieveAllTickets(@RequestParam(name = "usedb") boolean useDb) {
    if (useDb) {
      List<Ticket> tickets = ticketService.getAllDbTickets();
      return ResponseEntity.ok().body(tickets);
    } else {
      try {
        URL url = new URL("https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        int status = con.getResponseCode();
        if (status > 299) {
          return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok().build();
      } catch (IOException e) {
        return ResponseEntity.status(404).build();
      }
    }
  }
}
