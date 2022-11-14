package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for (int[] row : array) {
            for (int cell : row) {
                list.add(i, cell);
                i++;
            }
        }
        return list;
    }
}