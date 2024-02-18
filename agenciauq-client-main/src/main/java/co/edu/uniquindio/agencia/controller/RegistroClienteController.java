package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.Almacen;
import co.edu.uniquindio.agencia.model.CampoVacioException;
import co.edu.uniquindio.agencia.model.IdentificacionNoValidaException;
import co.edu.uniquindio.agencia.model.TelefonoNoValidoException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistroClienteController implements Initializable{

    private final Almacen almacen=Almacen.getInstance();
    @FXML
    private DatePicker DateNacimiento;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnRegistrar;

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

    private Stage stage;

    public void setStage(Stage PrimaryStage) {
        stage=PrimaryStage;
    }

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

    public void registrarCliente() {
        String esNatural=comboTipo.getSelectionModel().getSelectedItem();
        try
        {
            almacen.validarValoresGeneralesClientes(txtNombre.getText(),txtApellido.getText(),txtID.getText(),txtDireccion.getText(),txtTelefono.getText());
            if(esNatural.equals("Natural"))
            {
                almacen.registrarClienteNatural(txtNombre.getText(),txtApellido.getText(),txtID.getText(),txtDireccion.getText(),txtTelefono.getText(),txtEmail.getText(),DateNacimiento.getValue().toString());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Se ha registrado con exito N");
                alert.setHeaderText(null);
                alert.show();
            }
            else
            {
                almacen.registrarClienteJuridico(txtNombre.getText(),txtApellido.getText(),txtID.getText(),txtDireccion.getText(),txtTelefono.getText(),txtNIT.getText());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Se ha registrado con exito J");
                alert.setHeaderText(null);
                alert.show();
            }
        }
        catch (TelefonoNoValidoException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Su telefono debe contener 7 digitos ");
            alert.setHeaderText(null);
            alert.show();
        }
        catch (CampoVacioException ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.setHeaderText(null);
            alert.show();
        }
        catch (NumberFormatException ex2)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Su telefono y su identificacion deben contener unicamente numeros ");
            alert.setHeaderText(null);
            alert.show();
        }
        catch (NullPointerException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Debe enviar una fecha valida ");
            alert.setHeaderText(null);
            alert.show();
        }
        catch (IdentificacionNoValidaException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText(null);
            alert.show();
        }
    }
}
