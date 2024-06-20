package com.romannumeralconverter.controller;

import com.romannumeralconverter.service.RomanNumeralConverterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@AllArgsConstructor
@Slf4j
public class RomanNumeralConverterController {
    @GetMapping("/romannumeral")
    public ResponseEntity<String> getRomanNumeral(@RequestParam Integer query) {
        try {
            log.info(String.format("received request to convert %s to roman numerals", query));
            var romanNumeral = RomanNumeralConverterService.convertToRomanNumerals(query);
            return ResponseEntity.ok(String.format("converted %s into %s", query, romanNumeral));
        } catch (IllegalArgumentException exception) {
            log.error(String.format("error occurred trying to convert %s into roman numerals", query));
            return ResponseEntity.badRequest().body("The number you provided is not representable in standard roman numerals");
        }
    }
}
