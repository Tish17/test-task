package org.example.service;

import org.example.service.impl.EmailServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailServiceTest {

    private final EmailService emailService = new EmailServiceImpl();

    @Test
    public void whenGivenOneEmail_thenOk() {
        String input = "aaa 123 test@test.com bbb 456";
        String expected = "test@test.com";

        List<String> emailList = emailService.getEmailListFromString(input);
        assertEquals(1, emailList.size());
        assertEquals(expected, emailList.get(0));
    }

    @Test
    public void whenGivenTwoEmail_thenOk() {
        String input = "test1@test.com bbb test2@test.com 456";
        String expected1 = "test1@test.com";
        String expected2 = "test2@test.com";

        List<String> emailList = emailService.getEmailListFromString(input);
        assertEquals(2, emailList.size());
        assertEquals(expected1, emailList.get(0));
        assertEquals(expected2, emailList.get(1));
    }

    @Test
    public void whenGivenNullInput_thenOk() {
        String input = null;

        List<String> emailList = emailService.getEmailListFromString(input);
        assertEquals(0, emailList.size());
    }

    @Test
    public void whenGivenEmptyInput_thenOk() {
        String input = "";

        List<String> emailList = emailService.getEmailListFromString(input);
        assertEquals(0, emailList.size());
    }

    @Test
    public void whenGivenBlankInput_thenOk() {
        String input = "    ";

        List<String> emailList = emailService.getEmailListFromString(input);
        assertEquals(0, emailList.size());
    }

    @Test
    public void whenGivenWrongEmail_thenOk() {
        String input = "aaa test@ bbb @test 123";

        List<String> emailList = emailService.getEmailListFromString(input);
        assertEquals(0, emailList.size());
    }
}
