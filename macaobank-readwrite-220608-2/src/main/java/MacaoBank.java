/*
1. 거래 내역 불러오기
    - transcation 구현 (완료)
    - 파일에 있는것을 가져온다. (완료)
    - List에 넣어준다.(완료)
2. 거래 내역 처리하기
    - TransactionResult는 amount(잔액)와 해당 transaction 의 참조를 갖는다.(완료)
    - account가 transactions를 받아서 거래에 대한 처리를 한다.(완료)
    - 처리한 후에 transactionResults를 반환한다.(완료)
3. 거래 내역 결과 파일에 저장
    - 저장하기
*/

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

        List<Transaction> transactions = loadTransaction();

        List<TransactionResult> transactionResults = account.process(transactions);

        saveTransactionResult(transactionResults);
    }

    public void saveTransactionResult(List<TransactionResult> transactionResults) throws IOException {
        FileWriter fileWriter = new FileWriter("output.csv");

        for (TransactionResult transactionResult : transactionResults) {
            String line = transactionResult.toCsvRow();
            fileWriter.write(line + "\n");
        }

        fileWriter.close();
    }

    public List<Transaction> loadTransaction() throws FileNotFoundException {
        File file = new File("input.csv");

        Scanner scanner = new Scanner(file);

        List<Transaction> transactions = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(",");

            transactions.add(new Transaction(words[0], Integer.parseInt(words[1])));
        }

        return transactions;
    }

}
