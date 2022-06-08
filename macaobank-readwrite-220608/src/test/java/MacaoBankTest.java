import model.Transaction;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MacaoBankTest {

    @Test
    void loadTransaction() throws FileNotFoundException {
        MacaoBank macaoBank = new MacaoBank();

        assertEquals(new Transaction("입금", 1000), macaoBank.loadTransaction().get(0));
    }
}
