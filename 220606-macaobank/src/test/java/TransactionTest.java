import model.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {
    @Test
    void creation() {
        Transaction transaction1 = new Transaction("잔액", 1000);
        Transaction transaction2 = new Transaction("잔액", 1000);

        assertEquals(transaction1, transaction2);
    }

    @Test
    void string() {
        Transaction transaction = new Transaction("입금", 1000);

        assertEquals("model.Transaction(입금: 1000)", transaction.toString());
    }

    @Test
    void process() {
        assertEquals(1000, (int) new Transaction("잔액", 1000).process(0));
        assertEquals(1100, (int) new Transaction("입금", 1000).process(100));

        assertEquals(1000, (int) new Transaction("입금", 1000).process(0));
        assertEquals(1100, (int) new Transaction("입금", 1000).process(100));

        assertEquals(900, (int) new Transaction("출금", 100).process(1000));
    }
}