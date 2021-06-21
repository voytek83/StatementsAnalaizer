package com.wojtek;

import java.io.IOException;

public class MainApplication {
    public static void main(final String... args) throws IOException {

        final BankStatementAnalyzer bankStatmentAnalyzer = new BankStatementAnalyzer();

        final BankStatmentParser bankStatmentParser = new BankStatementCSVParser();

        bankStatmentAnalyzer.analyze(args[0],bankStatmentParser);

    }

}
