package org.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.example.models.Account;
import org.example.services.TransferService;
import org.example.utils.AccountPageGenerator;
import org.example.utils.FormParser;
import org.example.utils.GreetingPageGenerator;
import org.example.utils.MessageWriter;
import org.example.utils.PageGenerator;
import org.example.utils.RequestBodyReader;
import org.example.utils.TransferPageGenerator;
import org.example.utils.TransferSuccessPageGenerator;


public class MakaoBank {
    private final FormParser formParser;
    
    private final List<Account> accounts;
    private final Account account;
    private final TransferService transferService;
    
    public static void main(String[] args) throws IOException {
        MakaoBank application = new MakaoBank();
        application.run();
    }
    
    public MakaoBank() {
        formParser = new FormParser();
        
        accounts = List.of(
            new Account("1234", "Ashal", 3000),
            new Account("2345", "JOKER", 1000)
        );
        account = accounts.get(0);
        
        transferService = new TransferService(accounts);
    }
    
    private void run() throws IOException {
        InetSocketAddress address = new InetSocketAddress(8000);
        
        HttpServer httpServer = HttpServer.create(address, 0);
        
        httpServer.createContext("/", (exchange) -> {
            // 1. 입력
            
            URI requestURI = exchange.getRequestURI();
            String path = requestURI.getPath();
            
            String method = exchange.getRequestMethod();
            
            String requestBody = new RequestBodyReader(exchange).body();
            
            Map<String, String> formData = formParser.parse(requestBody);
            
            // 2. 처리
            
            PageGenerator pageGenerator = process(path, method, formData);
            
            // 3. 출력
            
            new MessageWriter(exchange).write(pageGenerator.html());
        });
        
        httpServer.start();
        
        System.out.println("Server is listening... http://localhost:8000/");
    }
    
    public PageGenerator process(String path, String method,
                                 Map<String, String> formData) {
        String[] steps = path.substring(1).split("/");
        return switch (steps[0]) {
            case "account" -> processAccount(steps.length > 1 ? steps[1] : "");
            case "transfer" -> processTransfer(method, formData);
            default -> new GreetingPageGenerator();
        };
    }
    
    private AccountPageGenerator processAccount(String identifier) {
        Account found = accounts.stream()
            .filter(account -> account.identifier().equals(identifier))
            .findFirst()
            .orElse(account);
        return new AccountPageGenerator(found);
    }
    
    private PageGenerator processTransfer(String method,
                                          Map<String, String> formData) {
        if (method.equals("GET")) {
            return processTransferGet();
        }
        
        return processTransferPost(formData);
    }
    
    private TransferPageGenerator processTransferGet() {
        return new TransferPageGenerator(account);
    }
    
    private TransferSuccessPageGenerator processTransferPost(
        Map<String, String> formData) {
        transferService.transfer(
            account.identifier(), formData.get("to"),
            Long.parseLong(formData.get("amount")));
        
        return new TransferSuccessPageGenerator(account);
    }
}
