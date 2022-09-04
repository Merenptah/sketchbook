package com.hg.sketchbook.jgiven.library;

import lombok.Builder;

@Builder
public class Search {
  private String author;

  private String title;

  public boolean isFulfilledBy(Book book) {
    return book.getAuthor().equals(author) || book.getTitle().equals(title);
  }
}
