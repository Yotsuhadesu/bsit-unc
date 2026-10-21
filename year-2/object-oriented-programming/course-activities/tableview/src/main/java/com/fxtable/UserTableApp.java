package com.fxtable;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserTableApp extends Application {
    public static class User {
        private final String name;
        private final String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {   
            return this.name;
        }
        public String getEmail() {
            return this.email;
        }
    }

    @Override
    public void start(Stage stage) {
        ObservableList<User> userList = FXCollections.observableArrayList();
        
        TableView<User> table = new TableView<>();

        TableColumn<User, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().add(nameCol);

        TableColumn<User, String> emailCol =  new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.getColumns().add(emailCol);

        table.setItems(userList);


        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter your name");
        TextField emailInput = new TextField();
        emailInput.setPromptText("Enter your email address");
        Button addButton = new Button("Add User");
        addButton.setOnAction(e -> {
            if (!nameInput.getText().isBlank() && !emailInput.getText().isBlank()) {
                userList.add(new User(nameInput.getText(), emailInput.getText()));
                nameInput.clear();
                emailInput.clear();
            }
        });
        
        HBox form = new HBox(nameInput, emailInput, addButton);
        VBox root = new VBox(table, form);
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 480, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}