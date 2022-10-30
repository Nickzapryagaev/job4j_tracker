package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rst = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                rst[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(rst, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int idToReplace = indexOf(id);
        if (idToReplace != -1) {
            item.setId(id);
            items[idToReplace] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        int indexToDelete = indexOf(id);
        if (indexToDelete != -1) {
            System.arraycopy(items, indexToDelete + 1, items,
                    indexToDelete, size - 1 - indexToDelete);
            items[size - 1] = null;
            size--;
            result = true;
        }
        return result;
    }
}