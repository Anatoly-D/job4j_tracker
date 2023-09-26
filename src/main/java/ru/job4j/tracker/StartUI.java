package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] userActions) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            UserAction action = userActions[select];
            run = action.execute(input, tracker);
        }
    }

    public void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };

        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] userActions = new UserAction[]{
                new CreateAction(),
                new ShowAllItemsAction(),
                new ReplaceItemAction(),
                new DeleteItemAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, userActions);
    }
}


