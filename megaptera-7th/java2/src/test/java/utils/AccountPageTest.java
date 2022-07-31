package utils;

import org.example.models.Account;
import org.example.utils.AccountPageGenerator;
import org.example.utils.PageGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountPageTest {
    @Test
    void html() {
        Account account = new Account("1234", "A", 3000);
    
        PageGenerator pageGenerator = new AccountPageGenerator(account);
        
        String html = pageGenerator.html();
        
        assertTrue(html.contains("계좌번호: 1234"), "계좌번호 문제: " + html);
    }
}
