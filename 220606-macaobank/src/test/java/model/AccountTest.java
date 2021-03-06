package model;

import org.junit.jupiter.api.Test;

import javax.annotation.processing.AbstractProcessor;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void process() {
        Account account = new Account();
        assertEquals(List.of(), account.process(List.of()));
    }


    @Test
    void processTwoTransaction() {
        List<Transaction> transactions = List.of(
                new Transaction("잔액", 100),
                new Transaction("입금", 200),
                new Transaction("출금", 100)
        );
        List<TransactionResult> transactionResults = List.of(
                new TransactionResult(transactions.get(0), 100),
                new TransactionResult(transactions.get(1), 100 + 200),
                new TransactionResult(transactions.get(2), 100 + 200 - 100)
        );

        Account account = new Account();

        assertEquals(transactionResults, account.process(transactions));
    }
}