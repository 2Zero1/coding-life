package org.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import org.example.models.Account;
import org.example.utils.AccountPageGenerator;
import org.example.utils.GreetingPageGenerator;
import org.example.utils.MessageWriter;
import org.example.utils.PageGenerator;

public class MakaoBank {
    public static void main(String[] args) throws IOException {
        MakaoBank application = new MakaoBank();
        application.run();
    }
    
    private void run() throws IOException {
        InetSocketAddress address = new InetSocketAddress(8000);
    
        HttpServer httpServer = HttpServer.create(address, 0);
        
        httpServer.createContext("/", (exchange -> {
            // 1. 입력
            
            URI requestURI = exchange.getRequestURI();
            String path = requestURI.getPath();
            
            String name = path.substring(1);
    
            // 2. 처리
    
            PageGenerator pageGenerator = new GreetingPageGenerator();
            
            if (path.equals("/account")) {
                Account account = new Account("1234", "Ashal", 3000);
                pageGenerator = new AccountPageGenerator(account);
            }
            
            String content = pageGenerator.html();
            
            // 3. 출력
    
            MessageWriter messageWriter = new MessageWriter(exchange);
            messageWriter.write(content);
        }));
        
        httpServer.start();
    }
}