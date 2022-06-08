import model.Account;
import model.Transaction;
import model.TransactionResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MacaoBank {
    public static void main(String[] args) throws IOException {
        MacaoBank application = new MacaoBank();

        application.run();
    }

    private void run() throws IOException {
        Account account = new Account();

        // Input
        List<Transaction> transactions = loadTransaction();

        // Process
        List<TransactionResult> transactionResults = account.process(transactions);

        // Output
        extractTransactionResults(transactionResults);
    }

    private void extractTransactionResults(List<TransactionResult> transactionResults) throws IOException {
        FileWriter fileWriter = new FileWriter("output.csv");

        for (TransactionResult transactionResult : transactionResults) {
            fileWriter.write(transactionResult.toCSV());
        }

        fileWriter.close();
    }

    public List<Transaction> loadTransaction() throws FileNotFoundException {
        List<Transaction> transactions = new ArrayList<>();

        File file = new File("input.csv");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.next();

            Transaction transaction = parseTransaction(line);

            transactions.add(transaction);
        }

        return transactions;
    }

    private Transaction parseTransaction(String line) {
        String[] words = line.split(",");
        int amount = Integer.parseInt(words[1]);

        return new Transaction(words[0], amount);
    }
}
