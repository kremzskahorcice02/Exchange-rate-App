package com.homework.exchangeratesapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String shortName;
  private String validFrom;
  private String name;
  private String Country;

  private double move;

  private int amount;

  private double valBuy;
  private double valSell;
  private double valMid;
  private double currBuy;
  private double currSell;
  private double currMid;

  private float version;
  private double cnbMid;
  private double ecbMid;

}
