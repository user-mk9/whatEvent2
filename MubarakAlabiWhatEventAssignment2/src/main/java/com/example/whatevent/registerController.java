/*
Mubarak Alabi
27/12/22
*/
package com.example.whatevent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class registerController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private PasswordField confPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField socM1Field;

    @FXML
    private TextField socM2Field;

    @FXML
    private TextField websiteField;

    @FXML
    private Text regFeedback;


    @FXML
    void exitToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleCreateAccount(ActionEvent event) {
        if(nameField.getText().equals(null)||nameField.getText().equals("")) {
            regFeedback.setText("Fill in all * fields");
            return;
        }
        if(passwordField.getText().equals(null)||passwordField.getText().equals("")) {
            regFeedback.setText("Fill in all * fields");
            return;
        }
        if(confPasswordField.getText().equals(null)||confPasswordField.getText().equals("")) {
            regFeedback.setText("Fill in all * fields");
            return;
        }
        if(emailField.getText().equals(null)||emailField.getText().equals("")) {
            regFeedback.setText("Fill in all * fields");
            return;
        }
        if(phoneField.getText().equals(null)||phoneField.getText().equals("")) {
            regFeedback.setText("Fill in all * fields");
            return;
        }
        if(websiteField.getText().equals(null)||websiteField.getText().equals("")) {
            regFeedback.setText("Fill in all * fields");
            return;
        }
        try {
            if(!(passwordField.getText().equals(confPasswordField.getText()))) {
                regFeedback.setText("Passwords do not match");
            }
            else if(passwordField.getText().length()<3) {
                regFeedback.setText("Password must be longer than 3 characters");
            }
            else if(phoneField.getText().length() != 9) {
                regFeedback.setText("Phone must be 9 digits long");
            }
            else {
                for(userDetails u : HelloApplication.users) {
                    if(nameField.getText().equals(u.getName())) {
                        regFeedback.setText("Name already in use");
                        return;
                    }
                    if(emailField.getText().equals(u.getEmail())) {
                        regFeedback.setText("Email already in use");
                        return;
                    }
                    if(phoneField.getText().equals(u.getPhone())) {
                        regFeedback.setText("Phone already in use");
                        return;
                    }
                }

                //Create a new registered user object and add it to the users ArrayList
                userDetails newUser = new userDetails(nameField.getText(), passwordField.getText(), emailField.getText(), confPasswordField.getText(), phoneField.getText(), websiteField.getText());
                HelloApplication.users.add(newUser);
                regFeedback.setText("Successful Organiser Created");
                HelloApplication.saveOrgs();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

