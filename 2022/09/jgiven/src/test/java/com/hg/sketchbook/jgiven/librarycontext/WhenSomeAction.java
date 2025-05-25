package com.hg.sketchbook.jgiven.librarycontext;

import com.hg.sketchbook.jgiven.library.Book;
import com.hg.sketchbook.jgiven.library.Library;
import com.hg.sketchbook.jgiven.library.Rental;
import com.hg.sketchbook.jgiven.library.Search;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.util.ArrayList;
import java.util.Collection;

public class WhenSomeAction extends Stage<WhenSomeAction> {
  @ExpectedScenarioState
  Collection<Book> libraryBooks;

  @ProvidedScenarioState
  Collection<Book> foundBooks;

  public WhenSomeAction i_search_for_the_book_with_the_author(String author) {
    Library library = new Library(libraryBooks, new ArrayList<Rental>());

    foundBooks = library.search(Search.builder().author(author).build());

    return this;
  }
}
