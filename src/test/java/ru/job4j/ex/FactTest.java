package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test (expected = IllegalArgumentException.class)
    public void whenException() {
        Fact test = new Fact();
        int result = test.calc(-1);
    }

    @Test
    public void whenCorrect() {
        Fact test = new Fact();
        assertThat(test.calc(5), is(120));
    }

}