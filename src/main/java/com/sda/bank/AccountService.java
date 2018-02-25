package com.sda.bank;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private List<Account> accounts;
    private static int counterId = 0;

    public AccountService() {
        this.accounts = new ArrayList<>();
    }

    public boolean addAccount(Account account) {
        boolean result = false;
        if (account != null) {
            account.setId(counterId++);
            accounts.add(account);
            result = true;
        }
        return result;
    }

    public Account getAccount(int accountId){
        throw new UnsupportedOperationException();
    }

    public int getNumberOfAccounts(){
        return accounts.size();
    }

    public boolean isAccountPresent(int id) {
        throw new UnsupportedOperationException();
    }
}
