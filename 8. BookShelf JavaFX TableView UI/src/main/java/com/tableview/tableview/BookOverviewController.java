package com.tableview.tableview;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BookOverviewController {
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> nameColumn;

    @FXML
    private Label author;
    @FXML
    private Label name;

    private Main main;

    public BookOverviewController() {
    }

    @FXML
    private void initialize() {
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        showBookDetails(null);

        bookTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
    }

    @FXML
    private void handleDeleteBook() throws IOException {
        int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        BookShelf books = objectMapper.readValue(new File("books.json"), BookShelf.class);
        books.getShelf().remove(selectedIndex);
        FileOutputStream fout = new FileOutputStream("books.json");
        objectMapper.writeValue(fout, books);
        if (selectedIndex >= 0) {
            bookTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson() throws IOException {
        Book book = new Book();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        BookShelf books = objectMapper.readValue(new File("books.json"), BookShelf.class);
        books.InsertBook(book);
        boolean okClicked = main.showBookEditDialog(book);
        if (okClicked) {
            FileOutputStream fout = new FileOutputStream("books.json");
            main.getBookData().add(book);
            objectMapper.writeValue(fout, books);
        }
    }

    @FXML
    private void handleEditPerson() throws IOException {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        BookShelf books = objectMapper.readValue(new File("books.json"), BookShelf.class);
        books.getShelf().remove(selectedBook);
        if (selectedBook != null) {
            boolean okClicked = main.showBookEditDialog(selectedBook);
            if (okClicked) {
                showBookDetails(selectedBook);
                books.InsertBook(selectedBook);
                FileOutputStream fout = new FileOutputStream("books.json");
                objectMapper.writeValue(fout, books);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table.");

            alert.showAndWait();
        }
    }

    public void setMainApp(Main main) {
        this.main = main;
        bookTable.setItems(main.getBookData());
    }

    private void showBookDetails(Book person) {
        if (person != null) {
            author.setText(person.getAuthor());
            name.setText(person.getName());
        } else {
            author.setText("");
            name.setText("");
        }
    }
}