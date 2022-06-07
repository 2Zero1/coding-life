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
        MacaoBank macaoBank = new MacaoBank();
        macaoBank.run();
    }

    private void run() throws IOException {
        // 준비

        Account account = new Account();

        // 입력

        List<Transaction> transactions = loadTransaction();

        // 처리

        List<TransactionResult> transactionResults = account.process(transactions);

        // 출력

        saveTransactionResults(transactionResults);
    }

    public void saveTransactionResults(
            List<TransactionResult> transactionResults) throws IOException {
        FileWriter fileWriter = new FileWriter("output.csv");

        for (TransactionResult transactionResult: transactionResults) {
            fileWriter.write(transactionResult.toCsvRow() + "\n");
        }
        String line = "잔액,100,100";

        fileWriter.write(line);
        fileWriter.close();

    }

    public List<Transaction> loadTransaction() throws FileNotFoundException {
        List<Transaction> transactions = new ArrayList<>();

        File file = new File("input.csv");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Transaction transaction = parseTransaction(line);

            transactions.add(transaction);
        }

        return transactions;
    }

    public Transaction parseTransaction(String text) {
        String[] words = text.split(",");
        int amount = Integer.parseInt(words[1]);
        return new Transaction(words[0], amount);
    }
}
