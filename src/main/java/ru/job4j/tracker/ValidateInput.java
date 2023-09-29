package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;
    private final Output output;

    public ValidateInput(Output output, Input input) {
        this.input = input;
        this.output = output;
    }

    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException e) {
                output.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}
