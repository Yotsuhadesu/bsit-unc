package com.example;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class StudentEntry extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        GridPane formGrid = new GridPane();

        // labels
        Label lrnLabel = new Label("LRN:");
        Label lastNameLabel = new Label("Last Name:");
        Label firstNameLabel = new Label("First Name:");
        Label middleNameLabel = new Label("Middle Name:");
        Label birthDateLabel = new Label("Birth Date:");
        Label contactLabel = new Label("Contact Number:");
        Label addressLabel = new Label("Address:");

        // text fields
        TextField lrnField = new TextField();
        TextField lastNameField = new TextField();
        TextField firstNameField = new TextField();
        TextField middleNameField = new TextField();
        TextField birthDateField = new TextField();
        TextField contactField = new TextField();
        TextField addressField = new TextField();

        // buttons
        Button saveButton = new Button("Save");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        Button viewButton = new Button("View");
        Button exitButton = new Button("Exit");
        saveButton.setMinWidth(200);
        editButton.setMinWidth(200);
        deleteButton.setMinWidth(200);
        viewButton.setMinWidth(200);
        exitButton.setMinWidth(200);

        // put elements to grid
        formGrid.add(lrnLabel, 0, 0);
        formGrid.add(lastNameLabel, 0, 1);
        formGrid.add(firstNameLabel, 0, 2);
        formGrid.add(middleNameLabel, 0, 3);
        formGrid.add(birthDateLabel, 0, 4);
        formGrid.add(contactLabel, 0, 5);
        formGrid.add(addressLabel, 0, 6);
        
        formGrid.add(lrnField, 1, 0);
        formGrid.add(lastNameField, 1, 1);
        formGrid.add(firstNameField, 1, 2);
        formGrid.add(middleNameField, 1, 3);
        formGrid.add(birthDateField, 1, 4);
        formGrid.add(contactField, 1, 5);
        formGrid.add(addressField, 1, 6);

        formGrid.add(saveButton, 0, 7);
        formGrid.add(editButton, 1, 7);
        formGrid.add(deleteButton, 2, 7);
        formGrid.add(viewButton, 2, 0);
        formGrid.add(exitButton, 2, 1);
        
        formGrid.setPadding(new Insets(20)); // padding
        formGrid.setVgap(5);    // vertical gap 
        formGrid.setHgap(5);    // horizontal gap

        Scene scene = new Scene(formGrid);
        stage.setTitle("Student Entry");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}