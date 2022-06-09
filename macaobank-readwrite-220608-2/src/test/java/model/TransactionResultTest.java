package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResultTest {
    @Test
    void creation() {
        Transaction transaction = new Transaction("입금", 1000);

        int amount = 100 + 1000;

        TransactionResult transactionResult = new TransactionResult(transaction, amount);

        assertEquals("TransactionResult(" + transaction + "," + amount + ")", transactionResult.toString());
    }

    @Test
    void toCsvRow() {
        TransactionResult transactionResult = new TransactionResult(new Transaction("입금", 100), 100);

        assertEquals("입금,100,100", transactionResult.toCsvRow());
    }
}
