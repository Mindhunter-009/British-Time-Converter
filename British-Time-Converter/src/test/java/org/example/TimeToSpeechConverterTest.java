package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeToSpeechConverterTest {

    private final TimeToSpeechConverter converter = new TimeToSpeechConverter();

    @Test
    void testMidnight() {
        assertEquals("midnight", converter.toBritishSpokenForm(0, 0));
    }

    @Test
    void testNoon() {
        assertEquals("noon", converter.toBritishSpokenForm(12, 0));
    }

    @Test
    void testOClock() {
        assertEquals("one o'clock", converter.toBritishSpokenForm(1, 0));
        assertEquals("two o'clock", converter.toBritishSpokenForm(2, 0));
    }

    @Test
    void testPastTimes() {
        assertEquals("five past two", converter.toBritishSpokenForm(2, 5));
        assertEquals("ten past three", converter.toBritishSpokenForm(3, 10));
        assertEquals("quarter past four", converter.toBritishSpokenForm(4, 15));
        assertEquals("twenty past five", converter.toBritishSpokenForm(5, 20));
        assertEquals("twenty-five past six", converter.toBritishSpokenForm(6, 25));
    }

    @Test
    void testHalfPast() {
        assertEquals("half past seven", converter.toBritishSpokenForm(7, 30));
    }

    @Test
    void testToTimes() {
        assertEquals("twenty-five to eight", converter.toBritishSpokenForm(7, 35));
        assertEquals("twenty to nine", converter.toBritishSpokenForm(8, 40));
        assertEquals("quarter to ten", converter.toBritishSpokenForm(9, 45));
        assertEquals("ten to eleven", converter.toBritishSpokenForm(10, 50));
        assertEquals("five to twelve", converter.toBritishSpokenForm(11, 55));
    }

    @Test
    void testInvalidTime() {
        assertThrows(IllegalArgumentException.class, () -> converter.toBritishSpokenForm(24, 0));
        assertThrows(IllegalArgumentException.class, () -> converter.toBritishSpokenForm(12, 60));
        assertThrows(IllegalArgumentException.class, () -> converter.toBritishSpokenForm(-1, 0));
    }
}
