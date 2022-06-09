package model;

public class TransactionResult {
    private Transaction transaction;
    private int amount;

    public TransactionResult(Transaction transaction, int amount) {
        this.transaction = transaction;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionResult(" + transaction + "," + amount + ")";
    }

    @Override
    public boolean equals(Object other) {
        TransactionResult otherTransactionResult = (TransactionResult) other;

        return otherTransactionResult.transaction.equals(transaction) && otherTransactionResult.amount == amount;
    }

    public int getAmount() {
        return amount;
    }

    public String toCsvRow() {
        return transaction.getType() + "," + transaction.getAmount() + "," + getAmount();
    }
}
