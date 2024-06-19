package com.romannumeralconverter.controller;

import com.romannumeralconverter.service.RomanNumeralConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@AllArgsConstructor
public class RomanNumeralConverterController {
    private final RomanNumeralConverterService romanNumeralConverterService;

    @GetMapping("/romannumeral")
    public ResponseEntity<String> getRomanNumeral(@RequestParam Integer query) {
        try {
            return ResponseEntity.ok("you made it bruh!");
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body("The number you provided is not representable in standard roman numerals");
        }
    }
}
