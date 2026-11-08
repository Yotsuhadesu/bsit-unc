package com.transactionfx;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class TransactionAppController {
    @FXML
    private Button btnAddRecord;
    @FXML
    private Button btnClearRecord;
    @FXML
    private Button btnDeleteRecord;
    @FXML
    private Button btnDltDelete;
    @FXML
    private Button btnDltSearch;
    @FXML
    private Button btnExitApplication;
    @FXML
    private Button btnSaveRecord;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnUpdClear;
    @FXML
    private Button btnUpdSearch;
    @FXML
    private Button btnUpdUpdate;
    @FXML
    private Button btnUpdateRecord;
    @FXML
    private Button btnViewList;
    @FXML
    private Button btnViewPendings;
    @FXML
    private Button btnViewRecord;
    @FXML
    private Button btnViewTotalSales;
    @FXML
    private Label lblContactNumber;
    @FXML
    private Label lblDeliveryAddress;
    @FXML
    private Label lblDeliveryFee;
    @FXML
    private Label lblDltMessage;
    @FXML
    private Label lblItemPrice;
    @FXML
    private Label lblItemQuantity;
    @FXML
    private Label lblOperationStatus;
    @FXML
    private Label lblPaymentMethod;
    @FXML
    private Label lblTotalSales;
     @FXML
    private TextField txtSearch;
    @FXML
    private TextField txtDltTransactionID;

    // text fields for add record
    @FXML
    private TextField txtItemName;
    @FXML
    private TextField txtItemPrice;
    @FXML
    private TextField txtItemQuantity;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtContactNumber;
    @FXML
    private TextField txtDeliveryAddress;
    @FXML
    private TextField txtDeliveryFee;
    @FXML
    private TextField txtFirstName;

    // text fields for update record
    @FXML
    private TextField txtUpdContactNumber;
    @FXML
    private TextField txtUpdFirstName;
    @FXML
    private TextField txtUpdLastName;
    @FXML
    private TextField txtUpdTransactionID;
    
    @FXML
    void searchDltButtonClicked(ActionEvent event) {

    }
    @FXML
    void updateButtonClicked(ActionEvent event) {

    }
    @FXML
    void deleteButtonClicked(ActionEvent event) {

    }
    @FXML
    void updateSearchButtonClicked(ActionEvent event) {

    }

    // table and columns
    @FXML
    private TableView<Transaction> tblTransaction;
    @FXML
    private TableColumn<Transaction, Integer> clmID;
    @FXML
    private TableColumn<Transaction, LocalDate> clmDate;
    @FXML
    private TableColumn<Transaction, String> clmFirstName;
    @FXML
    private TableColumn<Transaction, String> clmLastName;
    @FXML
    private TableColumn<Transaction, String> clmItem;
    @FXML
    private TableColumn<Transaction, String> clmStatus;
    @FXML
    private TableColumn<Transaction, BigDecimal> clmTotal;
    
    // combo boxes
    @FXML
    private ComboBox<String> cbPaymentMethod;
    @FXML
    private ComboBox<String> cbSearch;
    @FXML
    private ComboBox<String> cbTransactionStatus;
    @FXML
    private ComboBox<String> cbUpdStatus;
        
    // panes
    @FXML
    private VBox addRecordPane;
    @FXML
    private VBox showRecordPane;
    @FXML
    private VBox updateRecordPane;
    @FXML
    private VBox deleteRecordPane;
    @FXML
    private VBox totalSalesPane;

    private List<VBox> panes;
    ArrayList<Transaction> transactions;


    @FXML
    private void initialize() {
        panes = List.of(addRecordPane, showRecordPane, updateRecordPane, deleteRecordPane, totalSalesPane);
        showPage(addRecordPane);

        cbPaymentMethod.getItems().addAll("GCash", "Cash");
        cbTransactionStatus.getItems().addAll("Pending", "Settled");
        cbUpdStatus.getItems().addAll("Pending", "Settled");
        cbSearch.getItems().addAll("ID", "Last Name");
        
        cbPaymentMethod.setValue("GCash");
        cbTransactionStatus.setValue("Pending");
        cbUpdStatus.setValue("Pending");
        cbSearch.setValue("ID");

        clmID.setCellValueFactory(new PropertyValueFactory<>("recordID"));
        clmDate.setCellValueFactory(new PropertyValueFactory<>("tranDate"));
        clmLastName.setCellValueFactory(new PropertyValueFactory<>("cusLastName"));
        clmFirstName.setCellValueFactory(new PropertyValueFactory<>("cusFirstName"));
        clmItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        clmStatus.setCellValueFactory(new PropertyValueFactory<>("tranStatus"));
        clmTotal.setCellValueFactory(new PropertyValueFactory<>("totAmount"));

        transactions = FileHandler.loadTransactions();
    }
    private void showPage(VBox chosen) {
        for (VBox pane : panes) {
            pane.setVisible(false);
            pane.setManaged(false);
        }
        chosen.setVisible(true);
        chosen.setManaged(true);
    }
    private void showTransactions(List<Transaction> toShow) {
        tblTransaction.setItems(FXCollections.observableArrayList(toShow));
    }

    // buttons for switching panes
    @FXML
    void addRecordButtonClicked(ActionEvent event) {
        showPage(addRecordPane);
    }

    @FXML
    void deleteRecordButtonClicked(ActionEvent event) {
        showPage(deleteRecordPane);
    }
    @FXML
    void exitApplicationButtonClicked(ActionEvent event) {

    }
    @FXML
    void updateRecordButtonClicked(ActionEvent event) {
        showPage(updateRecordPane);
    }
    @FXML
    void viewListButtonClicked(ActionEvent event) {
        showPage(showRecordPane);
        showTransactions(transactions);
    }
    @FXML
    void viewPendingsButtonClicked(ActionEvent event) {
        showPage(showRecordPane);
        ArrayList<Transaction> pendingTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getTranStatus().equalsIgnoreCase("Pending")) {
                pendingTransactions.add(transaction);
            }
        }
        showTransactions(pendingTransactions);
    }
    @FXML
    void viewRecordButtonClicked(ActionEvent event) {
        showPage(showRecordPane);
    }
    @FXML
    void viewTotalSalesButtonClicked(ActionEvent event) {
        showPage(totalSalesPane);
    }

    @FXML
    void saveRecordButtonClicked(ActionEvent event) {
        String cusLastName = txtLastName.getText().trim();
        if (!stringInputValidation("Last name", cusLastName)) {
            return;
        }
        String cusFirstName = txtFirstName.getText().trim();
        if (!stringInputValidation("First name", cusFirstName)) {
            return;
        }
        String cusConNum = txtContactNumber.getText().trim();
        if (!stringInputValidation("Contact number", cusConNum)) {
            return;
        }
        String delAddress = txtDeliveryAddress.getText().trim();
        if (!stringInputValidation("Delivery address", delAddress)) {
            return;
        }
        String itemName = txtItemName.getText().trim();
        if (!stringInputValidation("Item name", itemName)) {
            return;
        }
        int quantity;
        try {
            quantity = Integer.parseInt(txtItemQuantity.getText().trim());
        } catch (NumberFormatException e) {
            lblOperationStatus.setText("Quantity must be a whole number.");
            return;
        }
        BigDecimal itemPrice;
        try {
            itemPrice = new BigDecimal(txtItemPrice.getText().trim());
        } catch (NumberFormatException e) {
            lblOperationStatus.setText("Item price must be a number.");
            return;
        }
        BigDecimal delFee;
        try {
            delFee = new BigDecimal(txtDeliveryFee.getText().trim());
        } catch (NumberFormatException e) {
            lblOperationStatus.setText("Delivery fee must be a number.");
            return;
        }
        
        // setting the new record using the inputs
        Transaction newTransaction = new Transaction();
        newTransaction.setTranID(FileHandler.getLastTranId() + 1);
        newTransaction.setTranDate(LocalDate.now());
        newTransaction.setCusLastName(cusLastName);
        newTransaction.setCusFirstName(cusFirstName);
        newTransaction.setCusConNum(cusConNum);
        newTransaction.setDelAddress(delAddress);
        newTransaction.setItem(itemName);
        newTransaction.setTranStatus(cbTransactionStatus.getValue());
        newTransaction.setPayMethod(cbPaymentMethod.getValue());
        try {
            newTransaction.setItemQuantity(quantity);
            newTransaction.setItemPrice(itemPrice);
            newTransaction.setDelFee(delFee);
            newTransaction.compTotAmount();
        } catch (InvalidTransactionException e) {
            lblOperationStatus.setText(e.getMessage());
            return;
        }
        transactions.add(newTransaction);
        boolean isSuccess = FileHandler.saveTransactions(transactions);
        if (isSuccess) {
            lblOperationStatus.setText("New transaction record saved.");
        } else {
            lblOperationStatus.setText("Transaction record failed to save.");
        }
    }

    // clear button for update record pane
    @FXML
    void clearButtonClicked(ActionEvent event) {
        txtUpdLastName.clear();
        txtUpdFirstName.clear();
        txtUpdContactNumber.clear();
        txtUpdTransactionID.clear();
        cbUpdStatus.setValue("Pending");
        lblOperationStatus.setText("Inputs cleared.");
    }
    // clear button for add record pane
    @FXML
    void clearRecordButtonClicked(ActionEvent event) {
        txtLastName.clear();
        txtFirstName.clear();
        txtContactNumber.clear();
        txtDeliveryAddress.clear();
        txtItemName.clear();
        txtItemPrice.clear();
        txtItemQuantity.clear();
        txtDeliveryFee.clear();
        cbPaymentMethod.setValue("GCash");
        cbTransactionStatus.setValue("Pending");
        lblOperationStatus.setText("Inputs cleared.");
    }

    @FXML
    void searchButtonClicked(ActionEvent event) {
        ArrayList<Transaction> foundTransactions = new ArrayList<>();
        int tranCount = 0;
        if (cbSearch.getValue().equals("ID")) {
            try {
                int tranID = Integer.parseInt(txtSearch.getText().trim());
                for (Transaction transaction : transactions) {
                    if (tranID == transaction.getRecordID()) {
                        foundTransactions.add(transaction);
                        tranCount++;
                    }
                }
            } catch (NumberFormatException e) {
                lblOperationStatus.setText("Invalid ID entered.");
                return;
            }
        } else {
            String lastName = txtSearch.getText().trim();
            if (!lastName.isBlank()) {
                for (Transaction transaction : transactions) {
                    if (lastName.equalsIgnoreCase(transaction.getCusLastName())) {
                        foundTransactions.add(transaction);
                        tranCount++;
                    }
                }
            } else {
                lblOperationStatus.setText("Invalid last name entered.");
                return;
            }
        }

        showTransactions(foundTransactions);
        if (!foundTransactions.isEmpty()) {
            lblOperationStatus.setText( tranCount + " transactions found");
        } else {
            lblOperationStatus.setText("No transactions found");
        }
        txtSearch.clear();
    }

    private boolean stringInputValidation(String info, String input) {
        if (input.isBlank() || input.contains("\t")) {
            lblOperationStatus.setText(info + " is required.");
            return false;
        } else {
            return true;
        }
    }
}