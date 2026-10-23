module com.tableapp {
    requires javafx.controls;
    exports com.tableapp;
    requires javafx.fxml;
    opens com.tableapp to javafx.fxml;
}
