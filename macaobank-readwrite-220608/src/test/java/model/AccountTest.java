package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void process() {
        Account account = new Account();

        List<Transaction> transactions = List.of(new Transaction("입금", 1000));

        List<TransactionResult> transactionResults = List.of(new TransactionResult(transactions.get(0), 1000));

        assertEquals(transactionResults, account.process(transactions));
    }
}
