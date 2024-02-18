package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ListaProductoController {
    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Producto, String> colAprob;

    @FXML
    private TableColumn<Producto, String> colEnvasado;

    @FXML
    private TableColumn<Producto, String> colExis;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colPais;

    @FXML
    private TableColumn<Producto, String> colPeso;

    @FXML
    private TableColumn<Producto, String> colTemp;

    @FXML
    private TableColumn<Producto, String> colTipo;

    @FXML
    private TableColumn<Producto, String> colValor;

    @FXML
    private TableColumn<Producto, String> colVenci;

    @FXML
    private TableView<Producto> tablaProducto;

    private Stage stage;

    public void setStage(Stage PrimaryStage) {
        stage=PrimaryStage;
    }

    public void regresar() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Ventanas/inicio.fxml"));
        Parent root=loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        InicioController controller =loader.getController();
        controller.setStage(stage);
        stage.show();
        this.stage.close();
    }

}
