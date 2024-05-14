package com.example.daylik;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addToDB;

    @FXML
    private Label allPush;

    @FXML
    private Label allSQR;

    @FXML
    private Button closeButton;

    @FXML
    private TextField pushUpsTextField;

    @FXML
    private Button reloadB;
    Connect c = new Connect();
    static int oldPush;
    static int oldSqr;




    @FXML
    private TextField squattingTextField;

    @FXML
    void addToDBAction(ActionEvent event) {
        int a;
        int b;

        a = Integer.parseInt(pushUpsTextField.getText());
        b = Integer.parseInt(squattingTextField.getText());

        System.out.println("a= " + a);
        System.out.println("b= " + b);
        c.changeDB(a, b);

        allPush.setText(c.selectPUSHfromDB() + " віджимань");
        allSQR.setText(c.selectSQRfromDB() + " присідань");

        oldPush = Integer.parseInt(c.selectPUSHfromDB());
        oldSqr = Integer.parseInt(c.selectSQRfromDB());
        System.out.println("pldPus = " + oldPush);
        System.out.println("oldSqr = " + oldSqr);
        squattingTextField.setText("0");
        pushUpsTextField.setText("0");

    }

    @FXML
    void closeButtonAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void reloadBAction(ActionEvent event) {
        c.reloadDB();
        allPush.setText(  "0 віджимань");
        allSQR.setText(  "0 присідань");
        oldPush = Integer.parseInt(c.selectPUSHfromDB());
        oldSqr = Integer.parseInt(c.selectSQRfromDB());
        System.out.println("pldPus = " + oldPush);
        System.out.println("oldSqr = " + oldSqr);
    }

    @FXML
    void initialize() {
        allPush.setText(c.selectPUSHfromDB() + " віджимань");
        allSQR.setText(c.selectSQRfromDB() + " присідань");

        oldPush = Integer.parseInt(c.selectPUSHfromDB());
        oldSqr = Integer.parseInt(c.selectSQRfromDB());

        System.out.println("pldPus = " + oldPush);
        System.out.println("oldSqr = " + oldSqr);
        squattingTextField.setText("0");
        pushUpsTextField.setText("0");
    }

}
