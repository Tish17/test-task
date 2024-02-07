package org.example.service.impl;

import org.example.service.EmailService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = Logger.getLogger(EmailServiceImpl.class.getName());
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z\\d.]+@[a-zA-Z\\d.]+[a-zA-Z]");

    /**
     * Retrieving emails from a string.
     * If the string is null, or is empty or contains only whitespaces,
     * returns empty list.
     *
     * @param input - the string potentially containing emails
     * @return a list of emails from the string
     */
    @Override
    public List<String> getEmailListFromString(String input) {
        LOGGER.info(String.format("getEmailListFromString() - starts with input = '%s'", input));

        //Checking input for non-null and non-emptiness
        if (input == null || input.isBlank()) {
            LOGGER.info("getEmailListFromString() - input string is null or contains only whitespaces");
            return List.of();
        }

        //Finding all emails in input and saving into a list
        List<String> emailList = new ArrayList<>();
        Matcher matcher = EMAIL_PATTERN.matcher(input);
        while (matcher.find()) {
            emailList.add(matcher.group());
        }

        LOGGER.info("getEmailListFromString() - ends with emailList = " + emailList);
        return emailList;
    }
}
