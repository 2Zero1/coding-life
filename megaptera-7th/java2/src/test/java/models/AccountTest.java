package models;

import org.example.models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    void creation() {
        Account account = new Account("1234", "Ashal", 3000);
        
        assertEquals("1234", account.identifier());
    }
}
