/*
Mubarak Alabi
27/12/22
*/
package com.example.whatevent;

public class event {
    // =====  static field for the class

//Review static keyword:

    private static int eventId=111;


//    ======= instance fields



    private int id;

    private String eventTitle;

    private String eventDescription;

    private String eventType;

    private String eventLocation;

    private String eventVenue;

    private String totalPrice;

    private String dateTimeAdded;

    private String organiser;






    // ========  Constructor
    public event(String eventTitle, String eventDescription, String eventType, String eventLocation,
                 String eventVenue, String totalPrice, String dateTimeAdded, String organiser) {

        super();

        this.id = eventId++;

        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventType = eventType;
        this.eventLocation = eventLocation;
        this.eventVenue = eventVenue;
        this.totalPrice = totalPrice;
        this.dateTimeAdded = dateTimeAdded;
        this.organiser = organiser;
    }//end of Constructor



// ============ Getters and Setters

    public static int getEventId() {   //Notice method is Static !!
        return eventId;
    }

    public static void setEventId(int eventId) {  //Notice method is Static !!

        event Event = null;
        Event.eventId = eventId;
    }

    public int getId() {

        return id;

    }



    public void setId(int id) {

        this.id = id;

    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDateTimeAdded() {
        return dateTimeAdded;
    }

    public void setDateTimeAdded(String dateTimeAdded) {
        this.dateTimeAdded = dateTimeAdded;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }



// TODO update toString() method to also return the Category and Sub-Category

//You could use an if ...else statement to return "IN STOCK" or "OUT OF STOCK"
//      depending on whether the inStock field is true or false
// Here we are using an Alternative way. The Conditional Assignment Instruction:

// If you do not understand the Conditional Assignment, look at: https://www.w3schools.in/java-tutorial/operators/conditional/


    @Override
    public String toString() {
        return "event{" +
                "id=" + id +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventVenue='" + eventVenue + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", dateTimeAdded='" + dateTimeAdded + '\'' +
                ", organiser='" + organiser + '\'' +
                '}';
    }
}