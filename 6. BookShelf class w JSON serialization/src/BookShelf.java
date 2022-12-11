import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Book implements Comparable <Book> {
    private String name;
    private String author;
    public String getName() {
        return this.name;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setName(String name_) {
        this.name = name_;
    }
    public void setAuthor(String author_){
        this.author = author_;
    }
    public Book(String name_, String author_){
        this.name = name_;
        this.author = author_;
    }
    public Book(){
        this.name = "";
        this.author = "";
    }
    @Override public String toString(){
        return this.author + ", \"" + this.name + "\"";
    }
    @Override public boolean equals(Object b2){
        if (!(b2 instanceof Book)) return false;
        if (this.name == ((Book)b2).getName() && this.author == ((Book)b2).author)
            return true;
        return false;
    }
    @Override public int compareTo(Book b2){
        return this.name.compareTo(b2.name);
    }
}

class BookComparator implements Comparator<Book> {
    @Override public int compare(Book b1, Book b2) {
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}

class BookShelf {
    private ArrayList<Book> Shelf;
    public BookShelf (Book param) {
        Shelf.add(param);
    }
    public BookShelf() {
        Shelf = new ArrayList<Book>();
    }
    public void getShelf(FileWriter fw) throws IOException {
        for (int i = 0; i < Shelf.size(); i++) {
            fw.write(Shelf.get(i).toString() + "\n");
        }
    }

    public void outShelf() {
        for (int i = 0; i < Shelf.size(); i++) {
            System.out.println(Shelf.get(i).toString());
        }
    }

    public ArrayList<Book> getShelf() {
        return Shelf;
    }
    public void InsertBook (Book to_insert){
        Shelf.add(to_insert);
    }
    public void NameSort(){
        Collections.sort(Shelf);
    }
    public void AuthorSort() {
        Shelf.sort((Book lhs, Book rhs)->{
            if (lhs.getAuthor().equals(rhs.getAuthor())) {
                return lhs.getName().compareTo(rhs.getName());
            }
            else return lhs.getAuthor().compareTo(rhs.getAuthor());
        });
    }

    public int AuthorBooks(String author_){
        List<Book> books = Shelf.stream().filter(book -> book.getAuthor().equals(author_)).collect(Collectors.toList());
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        return books.size();
    }

    public void AuthorsGroupped(){
        Map<String, List<Book>> booksByAuthor = new HashMap(Shelf.stream().collect(Collectors.groupingBy(Book::getAuthor)));
        for (Map.Entry<String, List<Book>> item : booksByAuthor.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }

    public String binarySearch(Book to_search){
        int index = Collections.binarySearch(Shelf, to_search);
        if (index > 0) return Shelf.get(index).toString();
        else return "No";
    }
    @Override public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Shelf.size(); i++) {
            str.append(Shelf.get(i).toString() + "\n");
        }
        return str.toString();
    }
}

