package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {

    @Test
    void shouldFindMatchesInParent() {
        SmartPhone smartPhone = new SmartPhone(5, "name", 100, "Nokia");

        boolean expected =  smartPhone.matches("name");

        assertTrue(expected);
    }

    @Test
    void shouldFindMatchesInPresent() {
        SmartPhone smartPhone = new SmartPhone(5, "name", 100, "Apple");

        boolean expected =  smartPhone.matches("Apple");

        assertTrue(expected);
    }

    @Test
    void shouldNotFindMatches() {
        SmartPhone smartPhone = new SmartPhone(5, "name", 100, "Samsung");

        boolean expected =  smartPhone.matches("Sony");

        assertFalse(expected);
    }

}