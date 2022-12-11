package com.tableview.tableview;

import java.util.ArrayList;

public class BookShelf {
    private ArrayList<Book> Shelf;
    public BookShelf() {
        Shelf = new ArrayList<Book>();
    }
    public void InsertBook (Book to_insert){
        Shelf.add(to_insert);
    }
    public ArrayList<Book> getShelf() {
        return Shelf;
    }

}
