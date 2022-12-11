module com.tableview.tableview {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.tableview.tableview to javafx.fxml;
    exports com.tableview.tableview;
}