package com.sda.cucumber.post;

import org.junit.Assert;
import org.junit.Test;

public class UserStorageTest {

    @Test
    public void shouldCreateNewUserWithGivenNickname(){
        //Given
        UserStorage userStorage = new UserStorage();
        String nickname = "qwerty";

        //When
        boolean createNewUserResult = userStorage.createNewUser(nickname);

        //Then
        Assert.assertTrue("User was not created", createNewUserResult);
        Assert.assertTrue("User was not created", userStorage.isUserPresent(nickname));
    }
}
