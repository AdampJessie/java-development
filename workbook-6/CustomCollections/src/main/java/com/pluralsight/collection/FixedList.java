package com.pluralsight.collection;

import javax.swing.*;
import java.util.List;

public class FixedList <T> {

    private List<T> items;
    private int maxSize;

    public FixedList(int maxSize) {
        this.maxSize = maxSize;
    }


    public void add(T item){

        items.add(item);
        System.out.println("Item has been added!");

    }

    public List<T> getItems(){

        return items;
    }
}
