package com.wojtek;

import org.junit.Assert;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {



    @org.junit.Test
    public void shouldParseFromOneCorrectLine() throws Exception {
        final String line = "30-01-2017,50,Tesco";
        BankStatementParser statementParser = new BankStatementCSVParser();
        final BankTransaction result = statementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), +50, "Tesco");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }

/*    @org.junit.Test
    public void parseLinesFrom() {
        Assert.fail("Not yet implemented");
    }

    */
    }