package com.entryapp;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserEntryController {
    @FXML
    private TableColumn<Person, String> colLastName;
    @FXML
    private TableColumn<Person, String> colFirstName;
    @FXML
    private TableColumn<Person, String> colMiddleName;
    @FXML
    private TableColumn<Person, Integer> colAge;
    @FXML
    private TableColumn<Person, String> colGender;
    @FXML
    private TableColumn<Person, LocalDate> colBirthday;
    @FXML
    private TableColumn<Person, String> colAddress;
    @FXML
    private TableColumn<Person, String> colContactNumber;

    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField middleNameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField contactNumberField;
    
    @FXML 
    TableView<Person> tableStudents;
    ObservableList<Person> studentList = FXCollections.observableArrayList();

    @FXML
    void submit(ActionEvent event) {
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String middleName = middleNameField.getText();
        String gender = genderField.getText();
        LocalDate birthday = null;
        String address = addressField.getText();
        String contactNumber = contactNumberField.getText();
        
        String strBirthday = birthdayField.getText();
        if (!strBirthday.isBlank()) {
            try {
                birthday = LocalDate.parse(strBirthday);
            } catch (DateTimeParseException e) {
                birthday = null;
            }
        }

        if (!lastName.isBlank() && !firstName.isBlank() && !gender.isBlank() && birthday != null && !address.isBlank() && !contactNumber.isBlank()) {
            studentList.add(new Person(lastName, firstName, middleName, gender, birthday, address, contactNumber));
            lastNameField.clear();
            firstNameField.clear();
            middleNameField.clear();
            genderField.clear();
            birthdayField.clear();
            addressField.clear();
            contactNumberField.clear();
        }
    }

    @FXML 
    void initialize() {
        tableStudents.setItems(studentList);
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
    }
}
