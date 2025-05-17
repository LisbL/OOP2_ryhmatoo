module com.example.oop_2ryhmatoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop_2ryhmatoo to javafx.fxml;
    exports com.example.oop_2ryhmatoo;
}