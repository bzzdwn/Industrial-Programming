import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonSerialization  {
    public static void main(String[] args) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        FileOutputStream fout = new FileOutputStream("book.json");

        /*BookShelf shelf = new BookShelf();
        shelf.InsertBook(new Book("Differential Equations", "Alsevich"));
        shelf.InsertBook(new Book("Mathematician Analysis", "Levakov"));
        shelf.InsertBook(new Book("Algebra and Geometry", "Filipcov"));
        shelf.InsertBook(new Book("Mathematician Analysis", "Mazanik"));
        shelf.InsertBook(new Book("Differential Equations", "Mazanik"));
        shelf.InsertBook(new Book("AG Tasks", "Filipcov"));*/
        /*shelf.AuthorSort();
        objectMapper.writeValue(fout, shelf);
        System.out.println(shelf.AuthorBooks("Mazanik"));
        fout.close();*/
        //Map<String, Object> pers = objectMapper.readValue(new File("book.json"), Map.class);

        //System.out.println(pers.get("name"));
        //System.out.println(pers.get("author"));

        BookShelf books = objectMapper.readValue(new File("book.json"), BookShelf.class);
        books.outShelf();
        System.out.println("-------------------------------------");
        books.AuthorsGroupped();

    }
}
