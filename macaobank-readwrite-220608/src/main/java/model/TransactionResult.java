package model;

public class TransactionResult {

    private Transaction transaction;
    private int amount;

    public TransactionResult(Transaction transaction, int amount) {
        this.transaction = transaction;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object other) {
        TransactionResult otherTransactionResult = (TransactionResult) other;

        return otherTransactionResult.transaction.equals(transaction) && otherTransactionResult.amount == amount;
    }

    public String[] toValues() {
        return new String[] {
                transaction.getType(),
                transaction.getAmount().toString(),
                Integer.toString(amount)};
    }

    public String toCSV() {
        return String.join(",", toValues());
    }
}
