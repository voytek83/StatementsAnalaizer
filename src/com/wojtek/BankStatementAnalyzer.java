package com.wojtek;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/com/wojtek/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path, StandardCharsets.ISO_8859_1);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

    }

    public static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is:\n" +
                bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is:\n" +
                bankStatementProcessor.calculateToatalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is:\n" +
                bankStatementProcessor.calculateToatalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is:\n" +
                bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
