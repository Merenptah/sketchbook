package com.hg.sketchbook.jgiven.library;

import static org.assertj.core.util.Lists.newArrayList;

import com.hg.sketchbook.jgiven.librarycontext.GivenSomeState;
import com.hg.sketchbook.jgiven.librarycontext.ThenSomeOutcome;
import com.hg.sketchbook.jgiven.librarycontext.WhenSomeAction;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {

  @Test
  public void finds_books_when_searching_for_existing_books() {
    Book sherlockHolmes = new Book("Sir Arthur Canon Doyle", "Sherlock Holmes");
    List<Book> books = newArrayList(
        sherlockHolmes,
        new Book("J. K. Rowling", "Harry Potter und der Stein der Weisen")
    );

    given().the_library_contains_the_books(books);
    when().i_search_for_the_book_with_the_author("Sir Arthur Canon Doyle");
    then().i_get_the_book(sherlockHolmes);
  }
}
