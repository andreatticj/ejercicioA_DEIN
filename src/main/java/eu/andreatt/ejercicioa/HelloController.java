/**
 * Sample Skeleton for 'ejercicioA.fxml' Controller Class
 */

package eu.andreatt.ejercicioa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class HelloController {

    @FXML // fx:id="btnAceptar"
    private Button btnAceptar; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancelar"
    private Button btnCancelar; // Value injected by FXMLLoader

    @FXML // fx:id="chkDeporte"
    private CheckBox chkDeporte; // Value injected by FXMLLoader

    @FXML // fx:id="comboEdades"
    private ComboBox<String> comboEdades; // Value injected by FXMLLoader

    @FXML // fx:id="grpSexo"
    private ToggleGroup grpSexo; // Value injected by FXMLLoader

    @FXML // fx:id="listaDeportes"
    private ListView<String> listaDeportes; // Value injected by FXMLLoader

    @FXML // fx:id="sliderCine"
    private Slider sliderCine; // Value injected by FXMLLoader

    @FXML // fx:id="sliderCompras"
    private Slider sliderCompras; // Value injected by FXMLLoader

    @FXML // fx:id="sliderTelevision"
    private Slider sliderTelevision; // Value injected by FXMLLoader

    @FXML // fx:id="txtHermanos"
    private TextField txtHermanos; // Value injected by FXMLLoader

    @FXML // fx:id="txtProfesion"
    private TextField txtProfesion; // Value injected by FXMLLoader




    @FXML
    void initialize() {
        ObservableList<String> elementosCombo = FXCollections.observableArrayList("Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70");
        comboEdades.setItems(elementosCombo);
        comboEdades.setValue(elementosCombo.get(0));

        ObservableList<String> elementosLista = FXCollections.observableArrayList("Tenis", "Fútbol","Baloncesto","Natación","Ciclismo","Otro");
        listaDeportes.setItems(elementosLista);
    }

}