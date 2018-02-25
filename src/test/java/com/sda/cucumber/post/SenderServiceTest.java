package com.sda.cucumber.post;

import org.junit.Assert;
import org.junit.Test;

public class SenderServiceTest {

    @Test
    public void shouldSendMessageSuccessfully(){
        //Given
        SenderService senderService = new SenderService();
        String message = "Hello World";
        String from = "qwerty";
        String to = "abc";

        //When
        boolean sendMessageResult = senderService.sendMessage(from, to, message);

        //Then
        Assert.assertTrue("Message was not sent successfully.", sendMessageResult);
        //Assert.assertTrue("Message was not sent successfully.", );
    }
}
