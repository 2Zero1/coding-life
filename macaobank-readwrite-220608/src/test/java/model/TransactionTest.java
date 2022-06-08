package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {
    @Test
    void creation() {
        Transaction transaction = new Transaction("입금", 1000);

        assertEquals("입금", transaction.getType());
        assertEquals(1000, transaction.getAmount());
    }

    @Test
    void process() {
        assertEquals(2000, new Transaction("입금", 1000).process(1000));

        assertEquals(1000, new Transaction("잔액", 1000).process(1000));

        assertEquals(0, new Transaction("출금", 1000).process(1000));
    }
}
