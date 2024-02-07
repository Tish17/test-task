package org.example;

import org.example.service.EmailService;
import org.example.service.impl.EmailServiceImpl;

public class Main {

    public static void main(String[] args) {
        EmailService emailService = new EmailServiceImpl();
        String input = "Word1 word2  email1@gmail.com. Word3 word4  email2@gmail.com. Word5 word6";
        System.out.println(emailService.getEmailListFromString(input));
    }
}