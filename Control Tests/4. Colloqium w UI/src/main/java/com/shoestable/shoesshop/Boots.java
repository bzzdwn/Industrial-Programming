package com.shoestable.shoesshop;

import javafx.beans.property.*;

import java.text.NumberFormat;

public class Boots implements Comparable <Boots> {
    private final StringProperty name;
    private final StringProperty mark;
    private final StringProperty date;
    private final IntegerProperty count;
    private final DoubleProperty price;


    public Boots(String name, String mark, String date, int count, double price) {
        this.mark = new SimpleStringProperty(mark);
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.count = new SimpleIntegerProperty(count);
        this.price = new SimpleDoubleProperty(price);
    }

    public Boots(){
        this(null, null, null, 0, 0.0);
    }
    @Override public String toString(){
        return "Name: \""  + this.name + "\", Date: [" + this.date + "], Count: " + this.count + ", Price: " + this.price + ".";
    }
    @Override public boolean equals(Object b2){
        if (!(b2 instanceof Boots)) return false;
        if (this.name == ((Boots)b2).name && this.date == ((Boots)b2).date
                && this.count == ((Boots)b2).count
                && this.price == ((Boots)b2).price)
            return true;
        return false;
    }
    @Override
    public int compareTo(Boots m2){
        return this.getName().compareTo(m2.getName());
    }
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getMark() {
        return mark.get();
    }

    public void setMark(String mark) {
        this.mark.set(mark);
    }

    public StringProperty markProperty() {
        return mark;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public Integer getCount() {
        return count.get();
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public Double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

}

