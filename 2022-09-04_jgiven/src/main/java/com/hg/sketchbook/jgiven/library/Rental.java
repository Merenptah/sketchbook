package com.hg.sketchbook.jgiven.library;

import lombok.Value;

import java.util.Collection;
import java.util.UUID;

@Value
public class Rental {
  private UUID id;

  private Collection<Book> rentedBooks;
}
