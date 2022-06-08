package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionResultTest {

    @Test
    void testEquals() {
        Transaction transaction = new Transaction("입금", 1000);

        TransactionResult transactionResult1 = new TransactionResult(transaction, 1000);
        TransactionResult transactionResult2 = new TransactionResult(transaction, 1000);

        assertEquals(transactionResult1, transactionResult2);
    }

    @Test
    void toCSV() {
        Transaction transaction = new Transaction("입금", 1000);
        TransactionResult transactionResult = new TransactionResult(transaction, 1000);

        assertEquals("입금,1000,1000", transactionResult.toCSV());
    }
}