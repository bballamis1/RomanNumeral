package com.romannumeralconverter.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RomanNumeralConverterService {
    public static Integer UPPER_THRESHOLD = 3999;
    public static Map<Integer, String> romanNumeralHundredParts;
    public static Map<Integer, String> romanNumeralTensParts;
    public static Map<Integer, String> romanNumeralOnesParts;


    static {
        romanNumeralHundredParts = new HashMap<>();
        romanNumeralHundredParts.put(0, "");
        romanNumeralHundredParts.put(1, "C");
        romanNumeralHundredParts.put(2, "CC");
        romanNumeralHundredParts.put(3, "CCC");
        romanNumeralHundredParts.put(4, "CD");
        romanNumeralHundredParts.put(5, "D");
        romanNumeralHundredParts.put(6, "DC");
        romanNumeralHundredParts.put(7, "DCC");
        romanNumeralHundredParts.put(8, "DCCC");
        romanNumeralHundredParts.put(9, "CM");

        romanNumeralTensParts = new HashMap<>();
        romanNumeralTensParts.put(0, "");
        romanNumeralTensParts.put(1, "X");
        romanNumeralTensParts.put(2, "XX");
        romanNumeralTensParts.put(3, "XXX");
        romanNumeralTensParts.put(4, "XL");
        romanNumeralTensParts.put(5, "L");
        romanNumeralTensParts.put(6, "LX");
        romanNumeralTensParts.put(7, "LXX");
        romanNumeralTensParts.put(8, "LXXX");
        romanNumeralTensParts.put(9, "XC");

        romanNumeralOnesParts = new HashMap<>();
        romanNumeralOnesParts.put(0, "");
        romanNumeralOnesParts.put(1, "I");
        romanNumeralOnesParts.put(2, "II");
        romanNumeralOnesParts.put(3, "III");
        romanNumeralOnesParts.put(4, "IV");
        romanNumeralOnesParts.put(5, "V");
        romanNumeralOnesParts.put(6, "VI");
        romanNumeralOnesParts.put(7, "VII");
        romanNumeralOnesParts.put(8, "VIII");
        romanNumeralOnesParts.put(9, "IX");
    }

    public static String convertToRomanNumerals(Integer arabicNumeral) {
        // number must be positive
        // any number above 3999 needs to begin using the Vinculum.  Perhaps I'll add that later
        if (arabicNumeral < 1 || arabicNumeral > UPPER_THRESHOLD) {
            throw new IllegalArgumentException(String.format("{} is not representable in standard roman numerals", arabicNumeral));
        }

        Integer onesPlace = null;
        Integer tensPlace = null;
        Integer hundredsPlace = null;
        Integer thousandsPlace = null;

        StringBuilder romanNumeral = new StringBuilder();

        if (arabicNumeral >= 1000) {
            setThousandsPart(arabicNumeral, romanNumeral);
        } else if (arabicNumeral >= 100) {
            setHundredsPart(arabicNumeral, romanNumeral);
        } else if (arabicNumeral >= 10) {
            setTensPart(arabicNumeral, romanNumeral);
        } else {
            setOnesPart(arabicNumeral, romanNumeral);
        }

        return romanNumeral.toString();
    }

    private static void setThousandsPart(Integer arabicNumeral, StringBuilder builder) {
        var thousandsPlace = arabicNumeral / 1000;
        var thousandsMod = arabicNumeral % 1000;
        for (int i = 0; i < thousandsPlace; i++) {
            builder.append('M');
        }
        setHundredsPart(thousandsMod, builder);
    }

    private static void setHundredsPart(Integer thousandsMod, StringBuilder builder) {
        var hundredsPlace = thousandsMod / 100;
        var hundredsMod = thousandsMod % 100;
        builder.append(romanNumeralHundredParts.get(hundredsPlace));
        setTensPart(hundredsMod, builder);
    }

    private static void setTensPart(Integer hundredsMod, StringBuilder builder) {
        var tensPlace = hundredsMod / 10;
        builder.append(romanNumeralTensParts.get(tensPlace));
        setOnesPart(hundredsMod, builder);
    }

    private static void setOnesPart(Integer hundredsMod, StringBuilder builder) {
        builder.append(romanNumeralOnesParts.get(hundredsMod % 10));
    }
}
