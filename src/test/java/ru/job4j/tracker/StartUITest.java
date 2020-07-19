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
        Item[] expectedItems = {new Item(1, answers[0]),new Item(1, answers[1]), new Item(1, answers[2])};
        assertThat(tracker.findAll(), is(expectedItems));
    }
}