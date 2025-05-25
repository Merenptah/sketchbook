package com.hg.sketchbook.jgiven.library;

import lombok.Data;

import java.util.Collection;

@Data
public class Customer {
  private String name;

  private Collection<Rental> rentals;
}
