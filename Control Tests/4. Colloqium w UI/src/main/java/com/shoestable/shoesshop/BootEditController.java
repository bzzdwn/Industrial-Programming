package com.shoestable.shoesshop;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BootEditController {
    @FXML
    private TextField authorField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField countField;

    private Stage dialogStage;
    private Boots book;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Boots book) {
        this.book = book;
        authorField.setText(book.getMark());
        nameField.setText(book.getName());
        priceField.setText(book.getPrice().toString());
        dateField.setText(book.getDate());
        countField.setText(book.getCount().toString());

    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            book.setMark(authorField.getText());
            book.setName(nameField.getText());
            book.setCount(Integer.parseInt(countField.getText()));
            book.setDate(dateField.getText());
            book.setPrice(Double.parseDouble(priceField.getText()));
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

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (authorField.getText() == null || authorField.getText().length() == 0) {
            errorMessage += "No valid author name!\n";
        }
        if (priceField.getText() == null || priceField.getText().length() == 0) {
            errorMessage += "No valid price!\n";
        }
        if (dateField.getText() == null || dateField.getText().length() == 0) {
            errorMessage += "No valid date!\n";
        }
        if (countField.getText() == null || countField.getText().length() == 0) {
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
