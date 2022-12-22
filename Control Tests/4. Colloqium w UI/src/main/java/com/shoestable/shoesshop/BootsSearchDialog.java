package com.shoestable.shoesshop;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BootsSearchDialog {
    @FXML
    private TextField to_find;
    private Stage dialogStage;
    private Shop shop;
    public static Boots result;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public static Boots getResult() {
       return result;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() throws IOException {
        if (isInputValid()) {
            shop = new Shop();
            shop.setBoots("input.txt");
            result = shop.getShop().get(shop.binarySearch(to_find.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";


        if (to_find.getText() == null || to_find.getText().length() == 0) {
            errorMessage += "No valid count!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
