package com.wojtek;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class transactionAnalyzer {
    private static final String RESOURCES = "src/com/wojtek/";

    public static void main(final String... args) throws IOException {
        final CSVParser CSVParser = new CSVParser();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path, StandardCharsets.ISO_8859_1);

        final List<BankTransaction> bankTransactions =
                CSVParser.parseLinesFromCSV(lines);


        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January are: \n" + selectInMonth(bankTransactions, Month.JANUARY) );

    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions){
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions){
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month){
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions){
            if(bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }
}
