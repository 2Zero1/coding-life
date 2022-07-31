package services;

import java.util.List;
import org.example.models.Account;
import org.example.services.TransferService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferServiceTest {
    @Test
    void transfer() {
        List<Account> accounts = List.of(
            new Account("1", "joker", 1000),
            new Account("1", "joker", 1000)
        );
        
        Account sender = accounts.get(1);
        Account receiver = accounts.get(0);
    
        TransferService transferService = new TransferService(accounts);
        
        long oldSenderAmount = sender.amount();
        long oldReceiverAmount = receiver.amount();
        
        transferService.transfer("1234", "234", 1000);
        
        long newSenderAmount = sender.amount();
        long newReceiverAmount = receiver.amount();
        
        assertEquals(1000, oldSenderAmount - newSenderAmount);
        assertEquals(1000, newReceiverAmount - oldReceiverAmount);
    }
}
