package com.shoestable.shoesshop;

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
public class TableController {
    @FXML
    private TableView<Boots> bookTable;
    @FXML
    private TableColumn<Boots, String> markColumn;
    @FXML
    private TableColumn<Boots, String> nameColumn;

    @FXML
    private Label mark;
    @FXML
    private Label name;
    @FXML
    private Label date;
    @FXML
    private Label price;
    @FXML
    private Label count;

    private MainApp main;

    public TableController() {
    }

    @FXML
    private void initialize() {
        markColumn.setCellValueFactory(cellData -> cellData.getValue().markProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        showBookDetails(null);

        bookTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
    }

    @FXML
    private void handleSearch() throws IOException {
        Boots book = new Boots();


        boolean okClicked = main.showSearchDialog(book);
        if (okClicked) {

            showBookDetails(BootsSearchDialog.result);
            bookTable.getSelectionModel().select(BootsSearchDialog.result);
        }


    }

    @FXML
    private void handleDeleteBook() throws IOException {
        Boots book = new Boots();
        Shop shop = new Shop();
        shop.setBoots("input.txt");
        int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            bookTable.getItems().remove(selectedIndex);
            shop.getShop().remove(selectedIndex);
            shop.NameSort();
            shop.outBoots("input.txt");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Boots Selected");
            alert.setContentText("Please select a boots in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson() throws IOException {
        Boots book = new Boots();
        Shop shop = new Shop();
        shop.setBoots("input.txt");

        boolean okClicked = main.showBootEditDialog(book);
        if (okClicked) {
            main.getBootData().add(book);
            shop.InsertBoot(book);
            shop.NameSort();
            shop.outBoots("input.txt");
        }
    }

    @FXML
    private void handleEditPerson() throws IOException {
        Boots selectedBook = bookTable.getSelectionModel().getSelectedItem();

        if (selectedBook != null) {
            boolean okClicked = main.showBootEditDialog(selectedBook);
            if (okClicked) {
                showBookDetails(selectedBook);

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

    public void setMainApp(MainApp main) {
        this.main = main;
        bookTable.setItems(main.getBootData());
    }

    private void showBookDetails(Boots person) {
        if (person != null) {
            mark.setText(person.getMark());
            name.setText(person.getName());
            price.setText(person.getPrice().toString());
            count.setText(person.getCount().toString());
            date.setText(person.getDate());
        } else {
            mark.setText("");
            name.setText("");
            price.setText("");
            date.setText("");
            count.setText("");
        }
    }
}