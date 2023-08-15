module com.example.reactivecalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.reactivecalc to javafx.fxml;
    exports com.example.reactivecalc;
}