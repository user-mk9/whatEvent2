/*
Mubarak Alabi
27/12/22
*/
package com.example.whatevent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class organiserPageController {

    ObservableList<String> EventTypeList = FXCollections.observableArrayList( "Concert", "Drive-thru", "Movie", "Games-Night");
    ObservableList<String> EventLocationList = FXCollections.observableArrayList( "Dublin", "Waterford", "Kildare", "Carlow" );

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text eventTextArea;

    @FXML
    private TextField eventDescription;

    @FXML
    private ChoiceBox<String> eventLocation;

    @FXML
    private TextField eventTitle;

    @FXML
    private ChoiceBox<String> eventType;

    @FXML
    private TextField eventVenue;

    @FXML
    private TextField totalPrice;

    @FXML
    private TextField idField;

    @FXML
    private TextField dateTimeAdded;

    @FXML
    private TextField orgCreate;

    @FXML
    private ImageView imgs;

    @FXML
    private void initialize(){
        eventType.setValue("Concert");
        eventType.setItems(EventTypeList);

        eventLocation.setValue("Dublin");
        eventLocation.setItems(EventLocationList);
    }

    @FXML
    void createEvent(ActionEvent event) {
        { event newEvent = new event(eventTitle.getText(), eventDescription.getText(), eventType.getValue(),
                eventLocation.getValue(), eventVenue.getText(), totalPrice.getText(), dateTimeAdded.getText(), orgCreate.getText());
            HelloApplication.events.add(newEvent);
            HelloApplication.saveEvents();//save event when created
        }
        eventTitle.clear();
        eventDescription.clear();
        eventVenue.clear();
        totalPrice.clear();
        dateTimeAdded.clear();

        eventType.valueProperty().set(null);
        eventLocation.valueProperty().set(null);

    }

    @FXML
    void handleReadDetails(ActionEvent event) {
        event events;
        int id;
        //It takes the id and organiser entered by the user and searches for the event with the corresponding values
        //Only users that know the organiser name who created an event can read,update and delete an event
        // depending on the event type, an image is set to the imageview
        try {
            id = Integer.parseInt(idField.getText());
        }
        catch (Exception e){
            return;
        }
        for (int i=0; i<HelloApplication.events.size();i++){
            events =  HelloApplication.events.get(i);
            if (id == events.getId () && orgCreate.getText ().equals (events.getOrganiser ())) {

                eventTitle.setText(events.getEventTitle());
                eventDescription.setText(events.getEventDescription());
                eventType.setValue(events.getEventType());
                eventLocation.setValue(events.getEventLocation());
                eventVenue.setText(events.getEventVenue());
                totalPrice.setText(events.getTotalPrice());
                dateTimeAdded.setText(events.getDateTimeAdded());
                orgCreate.setText(events.getOrganiser());

                //this does not work but i have tried implement but
                // it does not stop me from doing anything, i am still able to do everthing else
                // Set the image depending on the event type
                if (events.getEventType().equals("Concert")) {
                    // Set the image to concert.jpg
                    imgs.setImage(new Image("concert.jpg"));
                } else if (events.getEventType().equals("Drive-thru")) {
                    // Set the image to drive-thru.jpg
                    imgs.setImage(new Image("drive-thru.jpg"));
                } else if (events.getEventType().equals("Movie")) {
                    // Set the image to movie.jpg
                    imgs.setImage(new Image("movie.jpg"));
                } else if (events.getEventType().equals("Games-Night")) {
                    // Set the image to games-night.jpg
                    imgs.setImage(new Image("games-night.jpg"));
                }
                return;
            }

        }


    }


    @FXML
    void handleUpdateDetails(ActionEvent event) throws IOException {
        event events;
        int id;
        try {
            id = Integer.parseInt(idField.getText());
        }
        catch (Exception e){
            return;
        }
        for (int i=0; i<HelloApplication.events.size();i++){
            events =  HelloApplication.events.get(i);
            if (id == events.getId () && orgCreate.getText ().equals (events.getOrganiser ())) {
                events.setEventTitle(eventTitle.getText());
                events.setEventDescription(eventDescription.getText());
                events.setEventType(eventType.getValue());
                events.setEventLocation(eventLocation.getValue());
                events.setEventVenue(eventVenue.getText());
                events.setTotalPrice(totalPrice.getText());
                events.setDateTimeAdded(dateTimeAdded.getText());
                events.setOrganiser(orgCreate.getText());

                return;
            }

        }

    }

    @FXML
    void deleteEvent (ActionEvent event) {
        event events;
        int id;
        try {
            id = Integer.parseInt (idField.getText ());
        } catch (Exception e) {
            return;
        }
        for (int i = 0; i < HelloApplication.events.size (); i++) {
            events = HelloApplication.events.get (i);
            if (id == events.getId () && orgCreate.getText ().equals (events.getOrganiser ())) {
                HelloApplication.events.remove (i);
                eventTextArea.setText ("Event has been Deleted");
                //save events when an event is deleted
                HelloApplication.saveEvents();
                return;
            }
        }
    }

    @FXML
    void exitToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void eventSummary(ActionEvent event) {
        String result = "";
        if (HelloApplication.events.size() == 0) {
            result = "No events available";
        } else {
            for (int i=0; i<HelloApplication.events.size();i++) {
                result += HelloApplication.events.get(i).getId() + " - " + HelloApplication.events.get(i).getEventTitle() +"," +"\t" ;
            }
        }
        eventTextArea.setText(result);
    }



}