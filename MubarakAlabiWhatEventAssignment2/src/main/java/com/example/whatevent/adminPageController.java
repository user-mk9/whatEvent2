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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class adminPageController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea adminTextArea;

    @FXML
    private TextField emailField;



    @FXML
    void exitToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listAllEventsBtn(ActionEvent event) {

        //event is stored in ""
        String result = "";

        for (int i=0; i<HelloApplication.events.size();i++){

            result += HelloApplication.events.get(i).getId() + " , " + HelloApplication.events.get(i).getEventTitle() + " , " +
                    HelloApplication.events.get(i).getEventDescription() + " , " + HelloApplication.events.get(i).getEventType() +
                    " , " + HelloApplication.events.get(i).getEventLocation() + " , " + HelloApplication.events.get(i).getEventVenue() +
                    " , " + HelloApplication.events.get(i).getTotalPrice() + "\n" ;
        }
        adminTextArea.setText(result);
    }

    @FXML
    void listAllOrganisers(ActionEvent event) {
        String result = "";
        for (int i=0; i<HelloApplication.users.size();i++) {
            result += "Name: "+HelloApplication.users.get(i).getName() + " - " + "Email: " + HelloApplication.users.get(i).getEmail() + "\n" ;
        }
        adminTextArea.setText(result);
    }

//list details of organiser
    @FXML
    void listDetails(ActionEvent event) {
        //variable users is created
        userDetails users;

        String email;

        try{
            email = emailField.getText();
        }
        catch (Exception e){
            return;
        }
        for (int i=0; i<HelloApplication.users.size();i++){
            users = HelloApplication.users.get(i);
            if(email.equals(users.getEmail())){
                adminTextArea.setText(users.getName() + "\n" + users.getEmail() + "\n" + users.getPhone() +
                        "\n" + users.getWebsite());
                return;
            }
        }

    }

    @FXML
    void listEvents(ActionEvent event) {
        userDetails users;
        String email;

        //Try catch block to check if email has been entered
        try{
            email = emailField.getText();
        }
        catch (Exception e){
            return;
        }
        //Looping through stored user details to check if email matches
        for (int i=0; i<HelloApplication.users.size();i++){
            users = HelloApplication.users.get(i);
            if(email.equals(users.getEmail())){

                //array list to store events associated with the email
                event events;
                ArrayList<String> eventListByOrganiser = new ArrayList<String>();
                for (int j=0; j<HelloApplication.events.size();j++) {
                    events = HelloApplication.events.get(j);
                    if (events.getOrganiser().equals(email)) {
                        eventListByOrganiser.add("Event ID: "+events.getId() + " - " + "Event Title: "+events.getEventTitle() +"\n");
                    }
                }

                //Setting the text area to the string of events associated with the email
                adminTextArea.setText(eventListByOrganiser.toString());
                return;
            }
        }
    }



    // Method to delete an organiser from the system
// This method reads the email of the organiser from the email field and searches for the organiser in the users ArrayList
// If the organiser is found, the organiser is removed from the system and all events associated with the organiser are deleted
// The method then saves the changes to the users file and displays a message to the adminTextArea
    @FXML
    void deleteOrganiser(ActionEvent event){
        userDetails users;
        String email;
        try{
            email = emailField.getText(); // get the email from the emailField
        }catch (Exception e){
            return;
        }
        for (int i=0; i<HelloApplication.users.size();i++){ // loop through the users ArrayList
            users = HelloApplication.users.get(i);
            if(email.equals(users.getEmail())){ // if the organiser is found
                HelloApplication.users.remove(i); // remove the organiser from the users ArrayList
                for(int j=0; j<HelloApplication.events.size(); j++){ // loop through the events ArrayList
                    if(HelloApplication.events.get(j).getOrganiser().equals(email)){ // if the event is organised by the organiser
                        HelloApplication.events.remove(j); // remove the event from the events ArrayList
                    }
                }
                HelloApplication.saveOrgs(); // save the changes to the users file
                adminTextArea.setText("Organiser has been removed"); // display a message to the adminTextArea
                return;
            }
        }
        adminTextArea.setText("Organiser not found"); // if the organiser is not found, display a message to the adminTextArea
    }

}
