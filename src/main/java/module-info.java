module com.example.sc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;


    opens com.example.sc to javafx.fxml;
    exports com.example.sc;
    exports com.example.util;
    opens com.example.util to javafx.fxml;
    exports com.example.service;
    opens com.example.service to javafx.fxml;
}