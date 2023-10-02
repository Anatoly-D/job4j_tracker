package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old item name")); /* Добавляется в tracker новая заявка */
        String replacedName = "New item name";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1", "New item name", "0", "2"}
        );

        List<UserAction> actions = List.of(new ShowAllItemsAction(out),
                new ReplaceItemAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1", "0", "2"}
        );
        List<UserAction> actions = List.of(new ShowAllItemsAction(out),
                new DeleteItemAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program." + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(new ReplaceItemAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Replace Item." + ln
                        + "1. Exit Program." + ln
                        + "=== Replace Item ===" + ln
                        + "Item was replaced." + ln
                        + "Menu:" + ln
                        + "0. Replace Item." + ln
                        + "1. Exit Program." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindAllActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("testItemName"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = List.of(new ShowAllItemsAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all Items." + ln
                        + "1. Exit Program." + ln
                        + "=== Show all Items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all Items." + ln
                        + "1. Exit Program." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("TestItemName"));
        Input in = new StubInput(
                new String[] {"0", "TestItemName", "1"}
        );
        List<UserAction> actions = List.of(new FindByNameAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                + "0. Find Items by name." + ln
                + "1. Exit Program." + ln
                + "=== Find Items by name ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Find Items by name." + ln
                + "1. Exit Program." + ln
                + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenFindByIdActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("TestItemName"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        List<UserAction> actions = List.of(new FindByIdAction(out),
                new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find Item by id." + ln
                        + "1. Exit Program." + ln
                        + "=== Find Item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find Item by id." + ln
                        + "1. Exit Program." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"4", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program." + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenValidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit Program." + ln
                        + "=== Exit Program ===" + ln
        );
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }
}