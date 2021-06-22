package com.wojtek;

import java.util.List;

public interface BankStatementParser {
    BankTransaction ąparseFrom(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}
