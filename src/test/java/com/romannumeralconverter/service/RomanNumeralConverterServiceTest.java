package com.romannumeralconverter.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConverterServiceTest {
    @ParameterizedTest
    @MethodSource("testArguments")
    void testGetRomanNumeralRepresentation(Integer arabicNumber, String expectedRomanNumeral) {
        assertEquals(RomanNumeralConverterService.convertToRomanNumerals(arabicNumber), expectedRomanNumeral);
    }

    @Test
    void testThrowsExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverterService.convertToRomanNumerals(-1));
    }

    @Test
    void testThrowsExceptionForZero() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverterService.convertToRomanNumerals(0));
    }

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(10, "X"),
                Arguments.of(50, "L"),
                Arguments.of(100, "C"),
                Arguments.of(500, "D"),
                Arguments.of(1000, "M"),
                Arguments.of(11, "XI"),
                Arguments.of(14, "XIV"),
                Arguments.of(15, "XV"),
                Arguments.of(19, "XIX"),
                Arguments.of(100, "C"),
                Arguments.of(101, "CI"),
                Arguments.of(104, "CIV"),
                Arguments.of(109, "CIX"),
                Arguments.of(111, "CXI"),
                Arguments.of(199, "CXCIX"),
                Arguments.of(200, "CC"),
                Arguments.of(300, "CCC"),
                Arguments.of(333, "CCCXXXIII"),
                Arguments.of(400, "CD"),
                Arguments.of(404, "CDIV"),
                Arguments.of(494, "CDXCIV"),
                Arguments.of(999, "CMXCIX"),
                Arguments.of(1111, "MCXI"),
                Arguments.of(2222, "MMCCXXII"),
                Arguments.of(3333, "MMMCCCXXXIII"),
                Arguments.of(3999, "MMMCMXCIX"));
    }
}