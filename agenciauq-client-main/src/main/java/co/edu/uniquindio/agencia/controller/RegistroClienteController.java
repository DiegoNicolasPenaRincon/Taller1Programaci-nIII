package co.edu.uniquindio.agencia.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistroClienteController implements Initializable{
    @FXML
    private DatePicker DateNacimiento;

    @FXML
    private Button btnRegresar;

    @FXML
    private ComboBox<String> comboTipo;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNIT;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Pane panelJ;

    @FXML
    private Pane panelN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        panelN.setVisible(false);
        panelJ.setVisible(false);
        comboTipo.getItems().addAll("Seleccione:", "Natural", "Juridica");
        comboTipo.getSelectionModel().selectFirst();
        comboTipo.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Seleccione:":
                    panelN.setVisible(false);
                    panelJ.setVisible(false);
                    break;
                case "Natural":
                    panelN.setVisible(true);
                    panelJ.setVisible(false);
                    break;
                case "Juridica":
                    panelN.setVisible(false);
                    panelJ.setVisible(true);
                    break;
            }
        });
    }
}
