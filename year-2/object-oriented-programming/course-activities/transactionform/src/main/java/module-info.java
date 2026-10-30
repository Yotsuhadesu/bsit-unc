module com.transactionfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.transactionfx to javafx.fxml;
    exports com.transactionfx;
}
