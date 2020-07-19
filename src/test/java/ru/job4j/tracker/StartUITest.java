package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void WhenCreateItem() {
        String[] answers = {"first item", "second item", "third item"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(answers);
        StartUI.createItem(input,tracker);
        StartUI.createItem(input,tracker);
        StartUI.createItem(input,tracker);
        Item[] expectedItems = {new Item(1, answers[0]), new Item(2, answers[1]), new Item(3, answers[2])};
        assertThat(tracker.findAll(), is(expectedItems));
    }

    @Test
    public void WhenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "replaced item"};
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is(answers[1]));
    }

    @Test
    public void WhenDeleteItem() {
        Item item = new Item("new item");
        Tracker tracker = new Tracker();
        tracker.add(item);

        String[] answers = {"1"};
        StartUI.deleteItem(new StubInput(answers), tracker);
        assertThat(null, is(tracker.findById(Integer.valueOf(answers[0]))));

    }
}