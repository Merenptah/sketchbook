package com.hg.sketchbook.jgiven.librarycontext;

import com.hg.sketchbook.jgiven.library.Book;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
  @ExpectedScenarioState
  Collection<Book> foundBooks;

  public ThenSomeOutcome i_get_the_book(Book book) {
    assertThat(foundBooks).contains(book);
    return this;
  }
}
