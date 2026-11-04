package com.transactionfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private ComboBox<?> cbPaymentMethod;
    @FXML
    private ComboBox<?> cbSearch;
    @FXML
    private ComboBox<?> cbTransactionStatus;
    @FXML
    private ComboBox<?> cbUpdStatus;
    @FXML
    private TableColumn<?, ?> clmDate;
    @FXML
    private TableColumn<?, ?> clmFirstName;
    @FXML
    private TableColumn<?, ?> clmID;
    @FXML
    private TableColumn<?, ?> clmItem;
    @FXML
    private TableColumn<?, ?> clmLastName;
    @FXML
    private TableColumn<?, ?> clmStatus;
    @FXML
    private TableColumn<?, ?> clmTotal;
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
    private TableView<?> tblTransaction;
    @FXML
    private TextField txtContactNumber;
    @FXML
    private TextField txtDeliveryAddress;
    @FXML
    private TextField txtDeliveryFee;
    @FXML
    private TextField txtDltTransactionID;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtItemName;
    @FXML
    private TextField txtItemPrice;
    @FXML
    private TextField txtItemQuantity;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtSearch;
    @FXML
    private TextField txtUpdContactNumber;
    @FXML
    private TextField txtUpdFirstName;
    @FXML
    private TextField txtUpdLastName;
    @FXML
    private TextField txtUpdTransactionID;
    
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

    // buttons for switching panes
    @FXML
    void addRecordButtonClicked(ActionEvent event) {

    }
    @FXML
    void clearButtonClicked(ActionEvent event) {

    }
    @FXML
    void clearRecordButtonClicked(ActionEvent event) {

    }
    @FXML
    void deleteButtonClicked(ActionEvent event) {

    }
    @FXML
    void deleteRecordButtonClicked(ActionEvent event) {

    }
    @FXML
    void exitApplicationButtonClicked(ActionEvent event) {

    }
    @FXML
    void saveRecordButtonClicked(ActionEvent event) {

    }
    @FXML
    void searchButtonClicked(ActionEvent event) {

    }
    @FXML
    void searchDltButtonClicked(ActionEvent event) {

    }
    @FXML
    void updateButtonClicked(ActionEvent event) {

    }
    @FXML
    void updateRecordButtonClicked(ActionEvent event) {

    }
    @FXML
    void updateSearchButtonClicked(ActionEvent event) {

    }
    @FXML
    void viewListButtonClicked(ActionEvent event) {

    }
    @FXML
    void viewPendingsButtonClicked(ActionEvent event) {

    }
    @FXML
    void viewRecordButtonClicked(ActionEvent event) {

    }
    @FXML
    void viewTotalSalesButtonClicked(ActionEvent event) {

    }
}