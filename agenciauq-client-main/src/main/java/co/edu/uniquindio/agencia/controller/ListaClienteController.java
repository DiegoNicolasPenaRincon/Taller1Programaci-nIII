package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.Almacen;
import co.edu.uniquindio.agencia.model.Cliente;
import co.edu.uniquindio.agencia.model.ClienteJuridico;
import co.edu.uniquindio.agencia.model.ClienteNatural;
import javafx.beans.Observable;
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

public class ListaClienteController implements Initializable {
    private final Almacen almacen=Almacen.getInstance();

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Cliente, String> colApellido;

    @FXML
    private TableColumn<Cliente, String> colDireccion;

    @FXML
    private TableColumn<ClienteNatural, String> colEmail;

    @FXML
    private TableColumn<ClienteNatural, String> colFecha;

    @FXML
    private TableColumn<Cliente, String> colID;

    @FXML
    private TableColumn<ClienteJuridico, String> colNIT;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, String> colTel;

    @FXML
    private TableColumn<Cliente, String> colTipo;

    @FXML
    private TableView<Cliente> tablaCliente;

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
        colTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoCliente()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        colID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));

        colNIT.setCellValueFactory(cellData ->{ if (cellData.getValue() instanceof ClienteJuridico) {
            return new SimpleStringProperty(((ClienteJuridico) cellData.getValue()).getNit());
        }
        return null;
                });
        colDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        colTel.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        colEmail.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof ClienteNatural) {
                return new SimpleStringProperty((cellData.getValue()).getEmail());
            }
            return null;
        });

        colFecha.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof ClienteNatural) {
                return new SimpleStringProperty(cellData.getValue().getNacimiento().toString());
            }
            return null;
        });
        ObservableList<Cliente> listaClientes= FXCollections.observableArrayList(almacen.getListaClientes());
        tablaCliente.setItems(listaClientes);
    }
}
