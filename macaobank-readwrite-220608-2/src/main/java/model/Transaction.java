package model;

import java.util.List;

public class Transaction {
    String type;
    int amount;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "transaction(" + type + "," + amount + ")";
    }

    @Override
    public boolean equals(Object other) {
        Transaction otherTransaction = (Transaction) other;

        return otherTransaction.type.equals(type) && otherTransaction.amount == amount;
    }

    public int process(int amount) {
        if (type.equals("잔액")) {
            return amount;
        }

        if (type.equals("입금")) {
            return amount + this.amount;
        }

        if(type.equals("출금")) {
            return amount - this.amount;
        }

        return this.amount;
    }
}
