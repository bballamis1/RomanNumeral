# Roman Numeral Converter

Accepts an input of an arabic number (e.g. 455) and converts it to the roman numeral representation (e.g. CDLV)

followed [this](https://en.wikipedia.org/wiki/Roman_numerals) specification

### How to run:
Simply clone the repository, and in the root directory of the project, run `./gradlew bootRun`

### Engineering and Testing Methodoly:
This simple project was a great situation for TDD.
After hooking up the controller endpoint with the conversion service, it was easy to add test cases and write the code to ensure that they passed.
Also, a perfect place for having a parameterized test

### Packaging layout:
This was a simple project, with a simple package layout with the com.romannumeralconverter namespace:
src/main/java/com/romannumeralconverter/ with a package to contain the web controller, and a package to contain the service that performs the conversion.

### Dependencies:
lombok for ease of use

log4j for logging

JUnit for testing, which came along with spring-boot-starter-test
