package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("f"),
                new Item("z"),
                new Item("a")
        );
        List<Item> expected = Arrays.asList(
                new Item("a"),
                new Item("f"),
                new Item("z")
        );
        items.sort(new ItemAscByName());
        assertThat(items.equals(expected)).isTrue();
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("f"),
                new Item("z"),
                new Item("a")
        );
        List<Item> expected = Arrays.asList(
                new Item("z"),
                new Item("f"),
                new Item("a")
        );
        items.sort(new ItemDescByName());
        assertThat(items.equals(expected)).isTrue();
    }
}