/**
 * Sample Skeleton for 'ejercicioA.fxml' Controller Class
 */

package eu.andreatt.ejercicioa;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HelloController {

    @FXML // fx:id="btnAceptar"
    private Button btnAceptar; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancelar"
    private Button btnCancelar; // Value injected by FXMLLoader

    @FXML // fx:id="chkDeporte"
    private CheckBox chkDeporte; // Value injected by FXMLLoader

    @FXML // fx:id="comboEdades"
    private ComboBox<String> comboEdades; // Value injected by FXMLLoader

    @FXML // fx:id="radioHombre"
    private RadioButton radioHombre; // Value injected by FXMLLoader

    @FXML // fx:id="radioMujer"
    private RadioButton radioMujer; // Value injected by FXMLLoader

    @FXML // fx:id="radioOtro"
    private RadioButton radioOtro; // Value injected by FXMLLoader


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
    void aceptar(ActionEvent event) {

        String error = verificarInfo();
        Window win = ((Button) event.getSource()).getScene().getWindow();

        if (error.isEmpty()){
            mostrarAlertInfo(win);
        } else {
            mostrarAlertError(win);
        }
    }

    private void mostrarAlertInfo(Window win) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(win);
        alert.setHeaderText(null);
        alert.setTitle("TUS DATOS");
        alert.setContentText(mostrarInfo());
        alert.showAndWait();
    }

    private void mostrarAlertError(Window win) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(win);
        alert.setHeaderText(null);
        alert.setTitle("TUS DATOS");
        alert.setContentText(verificarInfo());
        alert.showAndWait();
    }

    private String mostrarInfo(){
        String info = "";
        String profesion = txtProfesion.getText();
        String hermanos = txtHermanos.getText();
        String edad = comboEdades.getSelectionModel().getSelectedItem();
        String sexo = "";
        if (radioHombre.isSelected()){
            sexo = radioHombre.getText();
        } else{
            if (radioMujer.isSelected()) {
                sexo = radioMujer.getText();
            }else {
                sexo = radioOtro.getText();
            }
        }
        ObservableList<String> depSel = FXCollections.observableArrayList(listaDeportes.getSelectionModel().getSelectedItems());
        Double gustoCompras = sliderCompras.getValue();
        Double gustoTelevision = sliderTelevision.getValue();
        Double gustoCine = sliderCine.getValue();

        info = "Profesión: "+profesion+"\n"+
                "Nº hermanos: "+hermanos+"\n"+
                "Edad: "+edad+"\n"+
                "Sexo: "+sexo+"\n"+
                "Deportes que practicas: \n\t"+depSel+"\n"+
                "Grado de aficion a las compas: "+gustoCompras+"\n"+
                "Grado de aficion a ver la television: "+gustoTelevision+"\n"+
                "Grado de aficion a ir al cine: "+gustoCine+"\n";
        return info;
    }

    private String verificarInfo(){
        String errores = "";
        if (txtProfesion.getText().isEmpty()){
            errores += "Hay que rellenar el campo profesion.\n";
        }
        if (txtHermanos.getText().isEmpty()){
            errores += "Hay que rellenar el campo Nº hermanos.\n";
        }
        if (!radioHombre.isSelected() && !radioMujer.isSelected() && !radioOtro.isSelected()){
            errores += "Hay que seleccionar un sexo.\n";
        }
        if (chkDeporte.isSelected() && listaDeportes.getSelectionModel().getSelectedItems().isEmpty()){
            errores += "Tienes que indicar los deportes que practicas";
        }
        return errores;
    }

    @FXML
    void cancelar(ActionEvent event) {
        Platform.exit();

    }


    @FXML
    void initialize() {
        ObservableList<String> elementosCombo = FXCollections.observableArrayList("Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70");
        comboEdades.setItems(elementosCombo);
        comboEdades.setValue(elementosCombo.get(0));

        ObservableList<String> elementosLista = FXCollections.observableArrayList("Tenis", "Fútbol","Baloncesto","Natación","Ciclismo","Otro");
        listaDeportes.setItems(elementosLista);

        if (chkDeporte.isSelected()){
            listaDeportes.setDisable(true);
        }
    }

}