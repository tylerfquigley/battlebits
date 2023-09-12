module com.example.battlebits {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.battlebits to javafx.fxml;
    exports com.example.battlebits;
}