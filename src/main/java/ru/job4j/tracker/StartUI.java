package ru.job4j.tracker;

import java.util.List;

public class StartUI {
    private final Output output;

    StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> userActions) {
        boolean run = true;
        while (run) {
            this.showMenu(userActions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= userActions.size()) {
                output.println("Wrong input, you can select: 0 .. " + (userActions.size() - 1));
                continue;
            }
            UserAction action = userActions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Menu:");
        for (UserAction action : actions) {
            output.println(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> userActions = List.of(
                new CreateAction(output),
                new ShowAllItemsAction(output),
                new ReplaceItemAction(output),
                new DeleteItemAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output));
        new StartUI(output).init(input, tracker, userActions);
    }
}


