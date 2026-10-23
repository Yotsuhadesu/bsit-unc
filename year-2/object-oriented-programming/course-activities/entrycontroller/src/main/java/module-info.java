module com.entryapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.entryapp to javafx.fxml;
    exports com.entryapp;
}
