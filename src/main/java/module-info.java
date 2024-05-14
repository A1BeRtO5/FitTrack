module com.example.daylik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.daylik to javafx.fxml;
    exports com.example.daylik;
}