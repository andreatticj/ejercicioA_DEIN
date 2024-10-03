module eu.andreatt.ejercicioa {
    requires javafx.controls;
    requires javafx.fxml;


    opens eu.andreatt.ejercicioa to javafx.fxml;
    exports eu.andreatt.ejercicioa;
}