package com.example.tables;

import java.util.ArrayList;
import java.util.Objects;

public class TableColumn {
    public String title;
    private ArrayList<String> elements;

    //constructors
    public TableColumn(String title, ArrayList<String> elements) {
        this.title = title;
        this.elements = Objects.requireNonNullElseGet(elements, ArrayList::new);
    }
    public TableColumn(String title) {
        this.title = title;
        this.elements = new ArrayList<>();
    }

    public TableColumn() {
        this.title = "null";
        this.elements = new ArrayList<>();
    }

    //Actions

    public void add(String element) {
        this.elements.add(element);
    }

    public void add(int index, String element) {
        this.elements.add(index, element);
    }

    public String remove(int index) {

        return this.elements.remove(index);
    }

    public void set(int index, String element) {
        this.elements.set(index,element);
    }

    //---

}
