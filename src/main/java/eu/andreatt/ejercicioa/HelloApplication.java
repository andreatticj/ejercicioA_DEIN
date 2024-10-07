package eu.andreatt.ejercicioa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación JavaFX.
 *
 * Esta clase se encarga de iniciar la aplicación y cargar la interfaz
 * gráfica definida en el archivo FXML correspondiente. Se configura
 * la escena y se muestra la ventana principal.
 */
public class HelloApplication extends Application {

    /**
     * Método que se llama al iniciar la aplicación.
     *
     * @param stage La ventana principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar el archivo FXML y crear la escena
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ejercicioA.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Configurar la ventana principal
        stage.setTitle("ENCUESTA"); // Título de la ventana
        stage.setScene(scene); // Establecer la escena en la ventana
        stage.setWidth(550); // Ancho de la ventana
        stage.setHeight(440); // Alto de la ventana
        stage.setResizable(false); // Hacer que la ventana no sea redimensionable
        stage.show(); // Mostrar la ventana
    }

    /**
     * Método principal de la aplicación.
     *
     * Este método inicia la aplicación JavaFX.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        launch(); // Llamar al método launch para iniciar la aplicación
    }
}
