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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    event events;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<event, String> eventLocation;

    @FXML
    private ChoiceBox<String> eventLocationBox;

    @FXML
    private TableColumn<event, String> eventTitle;

    @FXML
    private TableColumn<event, String> eventType;

    @FXML
    private TableColumn<event, String> eventDesc;

    @FXML
    private TableColumn<event, String> dateAdded;

    @FXML
    private ChoiceBox<String> eventTypeBox;

    @FXML
    private TableColumn<event, String> eventVenue;

    @FXML
    private TextArea homeTextArea;

    @FXML
    private TableView<event> tableV;

    @FXML
    private TableColumn<event, String> totalPrice;


    ObservableList<String> EventLocationList = FXCollections.observableArrayList("Any Type", "Dublin", "Waterford", "Kildare", "Carlow" );
    ObservableList<String> types = FXCollections.observableArrayList("Any Type", "Concert", "Drive-thru", "Movie", "Games-Night");
    @FXML
    public void initialize(URL location, ResourceBundle resources){
        event events;




        ObservableList<event> data =
                FXCollections.observableArrayList(HelloApplication.events);

        eventTitle.setCellValueFactory(new PropertyValueFactory<event, String>("eventTitle"));
        eventDesc.setCellValueFactory(new PropertyValueFactory<event, String>("eventDescription"));
        eventType.setCellValueFactory(new PropertyValueFactory<event, String>("eventType"));
        eventLocation.setCellValueFactory(new PropertyValueFactory<event, String>("eventLocation"));
        eventVenue.setCellValueFactory(new PropertyValueFactory<event, String>("eventVenue"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<event, String>("totalPrice"));
        dateAdded.setCellValueFactory(new PropertyValueFactory<event, String>("dateTimeAdded"));


        eventTypeBox.setValue("Any Type");
        eventTypeBox.setItems(types);


        eventLocationBox.setValue("Any Type");
        eventLocationBox.setItems(EventLocationList);

     tableV.setItems(data);
    }

    @FXML
    void switchToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void switchToRegisterPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    String searchEvent(ActionEvent event) {
        String results= "";

        // Create a list for the tableView
        ObservableList<event> list = FXCollections.observableArrayList();

        for(event i: HelloApplication.events){
            if(eventTypeBox.getValue().equals("Any Type")){
                list.add(i);
            }else if (eventLocationBox.getValue().equals("Any Type")){
                list.add(i);
            }else if (i.getEventType().equals(eventTypeBox.getValue()) && i.getEventLocation().equals(eventLocationBox.getValue())){
                list.add(i);
            }
        }
        //Update the tableView with the list
        tableV.setItems(list);

        return results;

    }
}