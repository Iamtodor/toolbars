package com.todor.tooblars;

import com.todor.tooblars.model.Item;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

    public Utils() {}

    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            items.add(new Item(i + "", "Item"));
        }
        return items;
    }

}
