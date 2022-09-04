package com.hg.sketchbook.jgiven.library;

import lombok.NonNull;
import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class Library {
  @NonNull
  private Collection<Book> books;

  @NonNull
  private Collection<Rental> rentals;

  public Collection<Book> search(final Search search) {
    return books.stream()
        .filter(search::isFulfilledBy)
        .collect(Collectors.toList());
  }

  public Rental rent(Book book) {
    if (!books.contains(book)) {
      throw new RuntimeException("Library does not have book {}");
    }

    Rental rental = new Rental(UUID.randomUUID(), List.of(book));

    rentals.add(rental);

    return rental;
  }
}
