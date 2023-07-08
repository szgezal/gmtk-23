module com.example.gmtk23 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gmtk23 to javafx.fxml;
    exports com.example.gmtk23;
}