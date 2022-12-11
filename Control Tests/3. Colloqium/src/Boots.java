import java.text.NumberFormat;

public class Boots implements Comparable <Boots> {
    private String name;
    private String date;
    private int count;
    private double price;


    public Boots(String n, String d, String f, int c, double p){
        name = n;
        date = d;
        count = c;
        price = p;
    }

    public Boots(){
        name = "";
        date = "";
        count = 0;
        price = 0;
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
        return this.name.compareTo(m2.name);
    }
    public int getCount() {
        return count;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }


    public String getName() {
        return name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(double price) {
        this.price = price;
    }

}
