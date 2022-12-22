module com.shoestable.shoesshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.shoestable.shoesshop to javafx.fxml;
    exports com.shoestable.shoesshop;
}