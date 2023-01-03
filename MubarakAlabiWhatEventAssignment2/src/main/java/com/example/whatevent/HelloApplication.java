/*
Mubarak Alabi
27/12/22
*/
package com.example.whatevent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public static ArrayList<userDetails> users;
    public static ArrayList<event> events;

//DOES NOT WORK
//This method saves the events that have been created
//It stores the events in an xml file called "events.xml"
//It uses a FileOutputStream and an ObjectOutputStream to write the events to the file
    public static void saveEvents(){
        try{
            FileOutputStream file = new FileOutputStream("events.xml");
            ObjectOutputStream i = new ObjectOutputStream(file);

            i.writeObject(users);
            i.close();
            file.close();
            System.out.println("evs has been saved");
            System.out.println(events);
        }catch(IOException ex){
            System.out.println("IOException is caught");
        }

    }

    //DOES NOT WORK
    //This method loads the events that have been stored in the "events.xml" file
//It uses a FileInputStream and an ObjectInputStream to read the events from the file
//It stores the events in an ArrayList called "events"
    public static void loadEvents(){
        try{
            FileInputStream file = new FileInputStream("events.xml");
            ObjectInputStream i = new ObjectInputStream(file);

            events =(ArrayList<event>) i.readObject();
            i.close();
            file.close();
            System.out.println("evs has been loaded");

            System.out.println(events);
        }catch(IOException | ClassNotFoundException ex){
            System.out.println("IOException is caught");
        }

    }

    public static void saveOrgs(){
        try{
            //saving to file "organisers.ser"
            FileOutputStream file = new FileOutputStream("organisers.ser");
            ObjectOutputStream i = new ObjectOutputStream(file);

            i.writeObject(events);
            i.close();
            file.close();
            System.out.println("org has been saved");
            System.out.println(users);
        }catch(IOException ex){
            System.out.println("IOException is caught");
        }

    }

    public static void loadOrgs(){
        try{
            //read from file
            FileInputStream file = new FileInputStream("organisers.ser");
            ObjectInputStream i = new ObjectInputStream(file);

            users =(ArrayList<userDetails>) i.readObject();
            i.close();
            file.close();
            System.out.println("org has been loaded");

            System.out.println(users);
        }catch(IOException | ClassNotFoundException ex){
            System.out.println("IOException is caught");
        }

    }

    public HelloApplication(){
        events= new ArrayList<>();
        users=new ArrayList<>();
        popData();
        popDataUsers();
    }

    public ArrayList<event> getEvents(){
        return events;
    }

    private void popData() {
        /*events.add(new event("Shakers","Hip Hop", "Concert", "Dublin",
                "O2 Arena", "25", "11/11/11", "mk"));
        events.add(new event("RocknRoll","Rock", "Concert", "Dublin",
                "New Arena", "16", "11/11/11", "mk"));
        events.add(new event("Romeo & Juliet","Theatre", "Movie", "Kildare",
                "O2 Arena", "40", "11/11/11", "mk"));*/
    }

    private void popDataUsers() {
     //   users.add(new userDetails("mk","123", "mk@.ie", "123", "0826261921","www.mk321.ie"));
    }


//This start method is used to launch the WhatEvent? application.
    @Override
    public void start(Stage stage) {
        //It loads the list of organizations and events stored in the system,


        try {
            loadOrgs();
            loadEvents();
            Parent root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("evs.css");
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }



    }


    public static void main(String[] args) {
        launch();
    }




}

