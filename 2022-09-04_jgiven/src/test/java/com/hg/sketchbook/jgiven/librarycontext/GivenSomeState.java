package com.hg.sketchbook.jgiven.librarycontext;

import com.hg.sketchbook.jgiven.library.Book;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GivenSomeState extends Stage<GivenSomeState> {
  @ProvidedScenarioState
  Collection<Book> libraryBooks = new ArrayList<>();

  public GivenSomeState the_library_contains_the_books(List<Book> books) {
    libraryBooks = books;

    return this;
  }
}
