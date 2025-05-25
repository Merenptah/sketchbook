package com.hg.sketchbook.jgiven.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.UUID;

@EqualsAndHashCode
@ToString
public class Book {
  private UUID id;

  @Getter
  @NonNull
  private String title;

  @Getter
  @NonNull
  private String author;

  public Book(String author, String title) {
    id = UUID.randomUUID();
    this.title = title;
    this.author = author;
  }
}
