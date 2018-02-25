package com.sda.cucumber.bank;

import com.sda.bank.Bank;
import com.sda.bank.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertEquals("User is not present in a bank list",1, bank.getUsers().size());
    }

    @Test
    public void shouldNotAddNullUser(){
        //Given
        User user = null;

        //When
        boolean result = bank.addUser(user);

        //Then
        Assert.assertFalse("Method returned true", result);
        Assert.assertEquals("User is presented in a bank list.", 0, bank.getUsers().size());
    }
}
