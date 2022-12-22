package com.shoestable.shoesshop;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws IOException  {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Boots Shop");

        initRootLayout();

        showBookOverview();
    }
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ObservableList<Boots> bootsData = FXCollections.observableArrayList();

    public MainApp() throws IOException {
        //bootsData.add(new Boots("Krossy", "Adidas", "11.2022", 4, 13.99));
        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write("");
        fileWriter.close();
        Shop shop = new Shop();
        shop.setBoots("input.txt");
        shop.NameSort();
        shop.getBoots("output.txt");
        for (int i = 0; i < shop.getShop().size(); i++) {
            bootsData.add(shop.getShop().get(i));
        }
        shop.outBoots("input.txt");
    }
    public ObservableList<Boots> getBootData() {
        return bootsData;
    }

    public void showBookOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("TableView.fxml"));
            AnchorPane bookOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(bookOverview);

            TableController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showBootEditDialog(Boots book) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("BootsEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit boots");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            BootEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(book);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showSearchDialog(Boots book) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("SearchDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Find boots");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            BootsSearchDialog controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
            book = controller.getResult();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}