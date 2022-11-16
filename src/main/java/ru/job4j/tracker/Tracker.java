package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> rst = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                rst.add(item);
            }
        }
        return rst;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int idToReplace = indexOf(id);
        boolean result = idToReplace != -1;
        if (result) {
            item.setId(id);
            items.set(idToReplace, item);
        }
        return result;
    }

    public boolean delete(int id) {
        int indexToDelete = indexOf(id);
        boolean result = indexToDelete != -1;
        if (result) {
            items.remove(indexToDelete);
        }
        return result;
    }
}