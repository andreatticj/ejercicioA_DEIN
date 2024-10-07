/**
 * Controlador para la clase 'ejercicioA.fxml'.
 *
 * Esta clase se encarga de controlar las interacciones y la lógica de los componentes
 * definidos en el archivo FXML 'ejercicioA.fxml'. Gestiona la entrada de datos por parte
 * del usuario, actualiza elementos de la interfaz gráfica y valida los datos ingresados
 * en el formulario.
 */
package eu.andreatt.ejercicioa;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Window;

public class HelloController {

    @FXML // fx:id="btnAceptar"
    private Button btnAceptar; // Botón "Aceptar" inyectado por el FXMLLoader

    @FXML // fx:id="btnCancelar"
    private Button btnCancelar; // Botón "Cancelar" inyectado por el FXMLLoader

    @FXML // fx:id="chkDeporte"
    private CheckBox chkDeporte; // Casilla de verificación para deportes inyectada por el FXMLLoader

    @FXML // fx:id="comboEdades"
    private ComboBox<String> comboEdades; // ComboBox para selección de edades inyectada por el FXMLLoader

    @FXML // fx:id="radioHombre"
    private RadioButton radioHombre; // RadioButton para seleccionar "Hombre" inyectada por el FXMLLoader

    @FXML // fx:id="radioMujer"
    private RadioButton radioMujer; // RadioButton para seleccionar "Mujer" inyectada por el FXMLLoader

    @FXML // fx:id="radioOtro"
    private RadioButton radioOtro; // RadioButton para seleccionar "Otro" inyectada por el FXMLLoader

    @FXML // fx:id="grpSexo"
    private ToggleGroup grpSexo; // Grupo de botones de selección para el sexo

    @FXML // fx:id="listaDeportes"
    private ListView<String> listaDeportes; // Lista de deportes inyectada por el FXMLLoader

    @FXML // fx:id="sliderCine"
    private Slider sliderCine; // Slider para medir afición al cine

    @FXML // fx:id="sliderCompras"
    private Slider sliderCompras; // Slider para medir afición a las compras

    @FXML // fx:id="sliderTelevision"
    private Slider sliderTelevision; // Slider para medir afición a la televisión

    @FXML // fx:id="txtHermanos"
    private TextField txtHermanos; // Campo de texto para ingresar el número de hermanos

    @FXML // fx:id="txtProfesion"
    private TextField txtProfesion; // Campo de texto para ingresar la profesión


    /**
     * Método ejecutado cuando se pulsa el botón "Aceptar".
     *
     * @param event El evento que dispara la acción
     */
    @FXML
    void aceptar(ActionEvent event) {
        String error = verificarInfo();
        Window win = ((Button) event.getSource()).getScene().getWindow();

        if (error.isEmpty()){
            mostrarAlertInfo(win); // Muestra una alerta con la información del usuario si no hay errores
        } else {
            mostrarAlertError(win); // Muestra una alerta de error si hay algún problema con la información
        }
    }

    /**
     * Muestra una alerta de información con los datos introducidos por el usuario.
     *
     * @param win Ventana padre de la alerta
     */
    private void mostrarAlertInfo(Window win) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(win);
        alert.setHeaderText(null);
        alert.setTitle("TUS DATOS");
        alert.setContentText(mostrarInfo()); // Muestra la información del usuario
        alert.showAndWait();
    }

    /**
     * Muestra una alerta de error si hay algún problema con los datos introducidos.
     *
     * @param win Ventana padre de la alerta
     */
    private void mostrarAlertError(Window win) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(win);
        alert.setHeaderText(null);
        alert.setTitle("TUS DATOS");
        alert.setContentText(verificarInfo()); // Muestra los errores encontrados
        alert.showAndWait();
    }

    /**
     * Recolecta y muestra la información del formulario completado por el usuario.
     *
     * @return Una cadena de texto con toda la información proporcionada por el usuario.
     */
    private String mostrarInfo(){
        String info = "";
        String profesion = txtProfesion.getText();
        String hermanos = txtHermanos.getText();
        String edad = comboEdades.getSelectionModel().getSelectedItem();
        String sexo = "";

        // Selección de sexo
        if (radioHombre.isSelected()){
            sexo = radioHombre.getText();
        } else if (radioMujer.isSelected()) {
            sexo = radioMujer.getText();
        } else {
            sexo = radioOtro.getText();
        }

        ObservableList<String> depSel = FXCollections.observableArrayList(listaDeportes.getSelectionModel().getSelectedItems());
        Double gustoCompras = sliderCompras.getValue();
        Double gustoTelevision = sliderTelevision.getValue();
        Double gustoCine = sliderCine.getValue();

        // Composición de la cadena de texto con la información proporcionada
        info = "Profesión: " + profesion + "\n" +
                "Nº hermanos: " + hermanos + "\n" +
                "Edad: " + edad + "\n" +
                "Sexo: " + sexo + "\n" +
                "Deportes que practicas: \n";

        // Añadir deportes seleccionados o mensaje si no hay deportes seleccionados
        if (depSel.size() == 0) {
            info += "\tNo practicas ningún deporte\n";
        } else {
            for (int j = 0; j < depSel.size(); j++) {
                info += "\t" + depSel.get(j) + "\n";
            }
        }

        // Aficiones
        info += "Grado de afición a las compras: " + gustoCompras + "\n" +
                "Grado de afición a ver la televisión: " + gustoTelevision + "\n" +
                "Grado de afición a ir al cine: " + gustoCine + "\n";

        return info;
    }

    /**
     * Verifica si los datos proporcionados en el formulario son válidos.
     *
     * @return Una cadena de texto con los errores encontrados o una cadena vacía si no hay errores.
     */
    private String verificarInfo(){
        String errores = "";

        // Verificar que el campo profesión no esté vacío
        if (txtProfesion.getText().isEmpty()){
            errores += "Hay que rellenar el campo profesión.\n";
        }

        // Verificar que el campo número de hermanos no esté vacío y sea un número válido
        if (txtHermanos.getText().isEmpty()){
            errores += "Hay que rellenar el campo Nº hermanos.\n";
        } else {
            try {
                Integer.parseInt(txtHermanos.getText()); // Intentar convertir a número
            } catch (NumberFormatException e) {
                errores += "El campo Nº hermanos debe ser un número válido.\n";
            }
        }

        // Verificar que se haya seleccionado un sexo
        if (!radioHombre.isSelected() && !radioMujer.isSelected() && !radioOtro.isSelected()){
            errores += "Hay que seleccionar un sexo.\n";
        }

        // Verificar si se seleccionó la opción de practicar deportes y si se ha elegido al menos uno
        if (chkDeporte.isSelected() && listaDeportes.getSelectionModel().getSelectedItems().isEmpty()){
            errores += "Tienes que indicar los deportes que practicas.\n";
        }

        return errores;
    }

    /**
     * Método ejecutado cuando se pulsa el botón "Cancelar".
     * Cierra la aplicación.
     *
     * @param event El evento que dispara la acción
     */
    @FXML
    void cancelar(ActionEvent event) {
        Platform.exit(); // Cierra la aplicación
    }

    /**
     * Método ejecutado cuando se marca o desmarca la casilla de verificación de deportes.
     * Si está seleccionada, habilita la lista de deportes.
     *
     * @param event El evento que dispara la acción
     */
    @FXML
    void ckhDeporteListener(ActionEvent event) {
        if (chkDeporte.isSelected()){
            listaDeportes.setDisable(false); // Habilitar la lista de deportes
        }
    }

    /**
     * Método que inicializa los elementos de la interfaz cuando se carga el controlador.
     * Establece valores predeterminados para los ComboBox y ListView.
     */
    @FXML
    void initialize() {
        // Inicializar el ComboBox de edades
        ObservableList<String> elementosCombo = FXCollections.observableArrayList("Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70");
        comboEdades.setItems(elementosCombo);
        comboEdades.setValue(elementosCombo.get(0)); // Valor predeterminado

        // Inicializar la lista de deportes
        ObservableList<String> elementosLista = FXCollections.observableArrayList("Tenis", "Fútbol", "Baloncesto", "Natación", "Ciclismo", "Otro");
        listaDeportes.setItems(elementosLista);
        listaDeportes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // Permitir selección múltiple
    }
}
