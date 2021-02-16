package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldFindMatchesInParent() {
        Book book = new Book(5, "name", 100, "author1");

        boolean expected =  book.matches("name");

        assertTrue(expected);
    }

    @Test
    void shouldFindMatchesInPresent() {
        Book book = new Book(5, "name", 100, "author2");

        boolean expected =  book.matches("author2");

        assertTrue(expected);
    }

    @Test
    void shouldNotFindMatches() {
        Book book = new Book(5, "name", 100, "author2");

        boolean expected =  book.matches("author5");

        assertFalse(expected);
    }

}