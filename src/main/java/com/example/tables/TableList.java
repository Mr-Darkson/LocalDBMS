package com.example.tables;

import java.util.ArrayList;

public class TableList {
    private String nameId;
    public int colCount = 0;
    public int rowCount = 0;
    ArrayList<TableColumn> columns;


    public TableList(String nameId) {
        this.nameId = nameId;
    }


    //Getters and setters
    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getNameId() {
        return nameId;
    }
}
