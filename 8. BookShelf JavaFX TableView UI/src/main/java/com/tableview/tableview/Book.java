package com.tableview.tableview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {

    private final StringProperty author;
    private final StringProperty name;

    public Book() {
        this(null, null);
    }

    public Book(String author, String name) {
        this.author = new SimpleStringProperty(author);
        this.name = new SimpleStringProperty(name);
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String author_) {
        this.author.set(author_);
    }

    public StringProperty authorProperty() {
        return author;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name_) {
        this.name.set(name_);
    }

    public StringProperty nameProperty() {
        return name;
    }
}