package com.tableapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TableController {
    @FXML
    private TextField txtTitle;

    @FXML
    void btnOnClick(ActionEvent event) {
        Stage mainWindow = (Stage) txtTitle.getScene().getWindow();
        String title = txtTitle.getText();
        mainWindow.setTitle(title);
    }
}