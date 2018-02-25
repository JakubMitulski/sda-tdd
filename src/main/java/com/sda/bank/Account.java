package com.sda.bank;

public class Account {

    private int userId;
    private int amount;

    public Account(int userId, int amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }
}
