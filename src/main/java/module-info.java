module com.example.sc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sc to javafx.fxml;
    exports com.example.sc;
    exports util;
    opens util to javafx.fxml;
    exports service;
    opens  service to javafx.fxml;
}