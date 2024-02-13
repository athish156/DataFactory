module com.example.datafactory {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;




    opens com.example.datafactory to javafx.fxml;
    exports com.example.datafactory;
}