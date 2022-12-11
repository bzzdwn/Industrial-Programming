import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write("");
        fileWriter.close();
        Shop shop = new Shop();
        shop.setBoots("input.txt");
        shop.getBoots("output.txt");
        shop.NameSort();
        shop.getBoots("output.txt");
        shop.binarySearch("Boots Nike", "output.txt");
        shop.PriceSort();
        shop.getBoots("output.txt");
        shop.getDateBoots("12.2020", "output.txt");
        shop.DateGroupped("output.txt");
    }
}
