package com.sda.cucumber.bank;

import com.sda.bank.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BankTest {

    private Bank bank;

    @Before
    public void init(){
        this.bank = new Bank("test");
    }

    @Test
    public void shouldAddNewUser() {
        //Given
        User user = new User("Jan", "Kowalski");

        //When
        boolean result = bank.addUser(user);

        //Then
        Assert.assertTrue("Method returned false", result);
        Assert.assertEquals("User is not present in a bank list",1, bank.getNumberOfUsers());
    }

    @Test
    public void shouldNotAddNullUser(){
        //Given
        User user = null;

        //When
        boolean result = bank.addUser(user);

        //Then
        Assert.assertFalse("Method returned true", result);
        Assert.assertEquals("User is presented in a bank list.", 0, bank.getNumberOfUsers());
    }

    @Test
    public void shouldCreateAccountForGivenUser(){
        //Given
        UserService mockUserService = Mockito.mock(UserService.class);
        AccountService mockAccountService = Mockito.mock(AccountService.class);

        Mockito.when(mockUserService.addUser(Mockito.any(User.class))).thenReturn(true);
        Mockito.when(mockUserService.getNumberOfUsers()).thenReturn(1);
        Mockito.when(mockUserService.isUserPresent(Mockito.any(Integer.class))).thenReturn(true);

        Mockito.when(mockAccountService.addAccount(Mockito.any(Account.class))).thenReturn(true);
        Mockito.when(mockAccountService.getNumberOfAccounts()).thenReturn(1);

        bank.setAccountService(mockAccountService);
        bank.setUserService(mockUserService);

        User user = new User("Jan", "Kowalski");
        Account account = new Account(0,0);

        //When
        boolean userAddResult = bank.addUser(user);
        boolean accountAddResult = bank.createAccount(0,account);

        //Then
        Assert.assertTrue("User is not presented in a bank list.", userAddResult);
        Assert.assertEquals("User is not presented in a bank list", 1, bank.getNumberOfUsers());
        Assert.assertTrue("Account is not presented in a bank list.", accountAddResult);
        Assert.assertEquals("Account is not presented in a bank list.", 1, bank.getNumberOfAccounts());
    }

    @Test
    public void shouldNotCreateAccountForNotExistingUser(){
        //Given
        Account account = new Account(10,0);
        UserService mockUserService = Mockito.mock(UserService.class);
        AccountService mockAccountService = Mockito.mock(AccountService.class);

        Mockito.when(mockUserService.isUserPresent(Mockito.any(Integer.class))).thenReturn(false);

        Mockito.when(mockAccountService.addAccount(Mockito.any(Account.class))).thenReturn(false);
        Mockito.when(mockAccountService.getNumberOfAccounts()).thenReturn(0);

        bank.setUserService(mockUserService);
        bank.setAccountService(mockAccountService);

        //When
        boolean result = bank.createAccount(10, account);

        //Then
        Assert.assertFalse("Account was created", result);
        Assert.assertEquals("Account is not present", 0, bank.getNumberOfAccounts());
    }

    @Test
    public void shouldUpdateAccountAmount(){
        //Given
        User user = new User("Jan", "Kowalski");
        Account account = new Account(0,100);
        UserService mockUserService = Mockito.mock(UserService.class);
        AccountService mockAccountService = Mockito.mock(AccountService.class);

        Mockito.when(mockUserService.addUser(Mockito.any(User.class))).thenReturn(true);
        Mockito.when(mockUserService.isUserPresent(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockUserService.getNumberOfUsers()).thenReturn(1);
        Mockito.when(mockAccountService.addAccount(Mockito.any(Account.class))).thenReturn(true);
        Mockito.when(mockAccountService.isAccountPresent(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockAccountService.getNumberOfAccounts()).thenReturn(1);
        Mockito.when(mockAccountService.getAccount(Mockito.anyInt())).thenReturn(new Account(0,200));

        bank.setAccountService(mockAccountService);
        bank.setUserService(mockUserService);

        //When
        boolean userAddResult = bank.addUser(user);
        boolean accountAddResult = bank.createAccount(0, account);
        boolean changeAmountResult = bank.changeAmount(account, 100);

        //Then
        Assert.assertTrue("User is not present", userAddResult);

        Assert.assertEquals("User is not present", 1, bank.getNumberOfUsers());
        Assert.assertTrue("Account is not present", accountAddResult);
        Assert.assertEquals("Account is not present", 1, bank.getNumberOfAccounts());

        Assert.assertTrue("Change amount action failed", changeAmountResult);
        Assert.assertEquals("Amount of account is not valid", 200, bank.getAccount(0).getAmount());

    }
}