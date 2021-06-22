package com.wojtek;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class BankStatementCSVParserTest5 {

    @org.junit.jupiter.api.Test
    void shouldParseFromOneCorrectLine() {
        final String line = "30-01-2017,50,Tesco";
        BankStatementParser statementParser = new BankStatementCSVParser();
        final BankTransaction result = statementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), +50, "Tesco");
        final double tolerance = 0.0d;
        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        assertEquals(expected.getDescription(), result.getDescription());
    }
}