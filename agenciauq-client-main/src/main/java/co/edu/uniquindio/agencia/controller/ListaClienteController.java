package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaClienteController {
    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Cliente, String> colApellido;

    @FXML
    private TableColumn<Cliente, String> colDireccion;

    @FXML
    private TableColumn<Cliente, String> colEmail;

    @FXML
    private TableColumn<Cliente, String> colFecha;

    @FXML
    private TableColumn<Cliente, String> colID;

    @FXML
    private TableColumn<Cliente, String> colNIT;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, String> colTel;

    @FXML
    private TableColumn<Cliente, String> colTipo;

    @FXML
    private TableView<Cliente> tablaCliente;
}
