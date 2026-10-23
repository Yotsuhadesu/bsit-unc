package com.entryapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TableColumn<Student, String> colLastName;
    @FXML
    private TableColumn<Student, String> colFirstName;
    @FXML
    private TableColumn<Student, String> colMiddleName;
    @FXML
    private TableColumn<Student, String> colGender;
    @FXML
    private TableColumn<Student, String> colBirthday;
    @FXML
    private TableColumn<Student, String> colAddress;
    @FXML
    private TableColumn<Student, String> colContactNumber;

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
    TableView<Student> tableStudents;
    ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    void submit(ActionEvent event) {
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String middleName = middleNameField.getText();
        String gender = genderField.getText();
        String birthday = birthdayField.getText();
        String address = addressField.getText();
        String contactNumber = contactNumberField.getText();
        if (!lastName.isBlank() && !firstName.isBlank() && !gender.isBlank() && !birthday.isBlank() && !address.isBlank() && !contactNumber.isBlank()) {
            studentList.add(new Student(lastName, firstName, middleName, gender, birthday, address, contactNumber));
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
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
    }
}
