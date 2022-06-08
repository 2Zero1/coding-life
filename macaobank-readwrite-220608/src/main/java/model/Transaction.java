package model;

public class Transaction {

    private String type;
    private int amount;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object other) {
        Transaction otherTransaction = (Transaction) other;

        return this.type.equals(otherTransaction.type) && this.amount == otherTransaction.amount;
    }

    public String getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public int process(int amount) {
        if (type.equals("잔액")) {
            return amount + this.amount;
        }
        if (type.equals("입금")) {
            return amount + this.amount;
        }
        if (type.equals("출금")) {
            return amount - this.amount;
        }

        return amount;
    }
}
