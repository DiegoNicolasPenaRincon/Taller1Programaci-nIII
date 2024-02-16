package co.edu.uniquindio.agencia.app;

import co.edu.uniquindio.agencia.controller.InicioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AgenciaApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader( AgenciaApp.class.getResource("/Ventanas/inicio.fxml") );
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("AlmacenUQ");
        InicioController controller = loader.getController();
        controller.setStage(stage);
        stage.show();

    }

    public static void main(String[] args) {
        launch( AgenciaApp.class, args );
    }
}
