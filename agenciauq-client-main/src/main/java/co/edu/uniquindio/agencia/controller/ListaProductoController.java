package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListaProductoController implements Initializable {

    private final Almacen almacen=Almacen.getInstance();
    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Refrigerante, String> colAprob;

    @FXML
    private TableColumn<Envasado, String> colEnvasado;

    @FXML
    private TableColumn<Producto, String> colExis;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Envasado, String> colPais;

    @FXML
    private TableColumn<Envasado, String> colPeso;

    @FXML
    private TableColumn<Refrigerante,String> colTemp;

    @FXML
    private TableColumn<Producto, String> colTipo;

    @FXML
    private TableColumn<Producto, String> colValor;

    @FXML
    private TableColumn<Perecedero, String> colVenci;

    @FXML
    private TableColumn<Producto, String> colCod;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colTipo.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getTipo()));
        colCod.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getCodigo()));
        colNombre.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getNombre()));
        colValor.setCellValueFactory(cellData-> new SimpleStringProperty(Double.toString(cellData.getValue().getValorUnitario())));
        colExis.setCellValueFactory(cellData-> new SimpleStringProperty(String.valueOf(cellData.getValue().getCantExistencias())));
        colVenci.setCellValueFactory(cellData-> new SimpleStringProperty(String.valueOf(cellData.getValue().getVencimiento())));
        colCod.setCellValueFactory(cellData-> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigo())));
        colTemp.setCellValueFactory(cellData-> new SimpleStringProperty(String.valueOf(cellData.getValue().getTemperaturaRecomendada())));
        colEnvasado.setCellValueFactory(cellData-> new SimpleStringProperty(String.valueOf(cellData.getValue().getFechaEnvasado())));
        colPeso.setCellValueFactory(cellData-> new SimpleStringProperty(String.valueOf(cellData.getValue().getPeso())));
        colPais.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getPais().toString()));


        ObservableList<Producto> listaProducto= FXCollections.observableArrayList(almacen.getListaProductos());
        tablaProducto.setItems(listaProducto);
    }
}
