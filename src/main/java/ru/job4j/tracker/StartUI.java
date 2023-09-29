package ru.job4j.tracker;

public class StartUI {
    private final Output output;

    StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] userActions) {
        boolean run = true;
        while (run) {
            this.showMenu(userActions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= userActions.length) {
                output.println("Wrong input, you can select: 0 .. " + (userActions.length - 1));
                continue;
            }
            UserAction action = userActions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        output.println("Menu:");
        for (int index = 0; index < actions.length; index++) {
            output.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(new ConsoleInput(), output);
        Tracker tracker = new Tracker();
        UserAction[] userActions = new UserAction[]{
                new CreateAction(output),
                new ShowAllItemsAction(output),
                new ReplaceItemAction(output),
                new DeleteItemAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, userActions);
    }
}


