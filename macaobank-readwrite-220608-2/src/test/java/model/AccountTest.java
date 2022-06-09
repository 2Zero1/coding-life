package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void processWithoutTransaction() {
        Account account = new Account();

        List<Transaction> transactions = List.of();

        assertEquals(List.of(), account.process(transactions));
    }

    @Test
    void processWithOneTransaction() {
        Account account = new Account();

        Transaction transaction = new Transaction("입금", 1000);

        TransactionResult transactionResult = new TransactionResult(transaction, 1000);

        List<Transaction> transactions = List.of(transaction);

        assertEquals(List.of(transactionResult), account.process(transactions));
    }

    @Test
    void processTransactions() {
        Account account = new Account();

        List<Transaction> transactions = List.of(
                new Transaction("입금", 1000),
                new Transaction("입금", 1000),
                new Transaction("출금", 1000),
                new Transaction("잔액", 1000),
                new Transaction("에러", 2000)
        );

        List<TransactionResult> transactionResults = List.of(
                new TransactionResult(transactions.get(0), 1000),
                new TransactionResult(transactions.get(1), 2000),
                new TransactionResult(transactions.get(2), 1000),
                new TransactionResult(transactions.get(3), 1000),
                new TransactionResult(transactions.get(4), 2000)
        );

        assertEquals(transactionResults, account.process(transactions));
    }
}
