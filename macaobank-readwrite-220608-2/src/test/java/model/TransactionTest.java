package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void creation() {
        Transaction transaction = new Transaction("입금", 1000);

        assertEquals("transaction(입금,1000)", transaction.toString());
    }

    @Test
    void process() {
        Transaction transaction = new Transaction("입금", 1000);

        assertEquals(1100, transaction.process(100));
    }
}
