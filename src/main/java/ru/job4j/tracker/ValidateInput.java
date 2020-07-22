package ru.job4j.tracker;

import javax.naming.Context;

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect input format. Try again.");
            }
        } while (invalid);
        return value;
    }
}
