module com.example.whatevent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.whatevent to javafx.fxml;
    exports com.example.whatevent;
}