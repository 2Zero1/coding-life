import model.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;


class MacaoBankTest {

    @Test
    void loadTransactions() throws FileNotFoundException {
        MacaoBank macaoBank = new MacaoBank();

        List<Transaction> transactions = macaoBank.loadTransaction();

        assertEquals(4, transactions.size());

        assertEquals(new Transaction("입금", 1000), transactions.get(0));
    }
}
