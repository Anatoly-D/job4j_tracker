package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}
