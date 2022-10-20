module com.example.multitools {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.multitools to javafx.fxml;
    exports com.example.passGen;
    exports com.example.multitools;
}