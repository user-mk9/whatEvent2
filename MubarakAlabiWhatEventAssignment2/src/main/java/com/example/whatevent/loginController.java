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


public class loginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text feedbackText;

    @FXML
    private PasswordField sPassword;

    @FXML
    private TextField sUsername;

    @FXML
    void handleClearFields(ActionEvent event) {
       sUsername.clear();
       sPassword.clear();
       feedbackText.setText("");
    }

    @FXML
    void handlelogin(ActionEvent event) throws IOException {
        System.out.println("Name: "+sUsername.getText() + " Password: " + sPassword.getText());

        userDetails user;

        if (sUsername.getText().equals("admin") && sPassword.getText().equals("admin")) {
            feedbackText.setText ("LOGIN SUCCESSFUL!");
            root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


        for (int i = 0; i <HelloApplication.users.size(); i++) {
             user = HelloApplication.users.get(i);
            if (sUsername.getText().equals(user.getName()) && sPassword.getText().equals(user.getPassword())) {
                root = FXMLLoader.load(getClass().getResource("organiser.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                feedbackText.setText ("LOGIN SUCCESSFUL!");
                // login successful
            }
            else {
                feedbackText.setText ("LOGIN UNSUCCESSFUL!");
                // login unsuccessful
            }
        }
        }





    @FXML
    void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
