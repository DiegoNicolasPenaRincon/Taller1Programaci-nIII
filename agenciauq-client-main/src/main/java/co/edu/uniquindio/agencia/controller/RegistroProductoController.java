package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.model.*;
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

public class RegistroProductoController implements Initializable {

    private final Almacen almacen=Almacen.getInstance();

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRegresar;

    @FXML
    private ComboBox<PaisOrigen> comboPais;

    @FXML
    private ComboBox<String> comboTipo;

    @FXML
    private DatePicker dateEnvasado;

    @FXML
    private DatePicker dateVencimiento;

    @FXML
    private Pane panelE;

    @FXML
    private Pane panelP;

    @FXML
    private Pane panelR;

    @FXML
    private TextField txtAprobacion;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtExistencia;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtTemp;

    @FXML
    private TextField txtValor;

    private Stage stage;

    public void setStage(Stage PrimaryStage) {
        stage=PrimaryStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        panelR.setVisible(false);
        panelE.setVisible(false);
        panelP.setVisible(false);
        comboTipo.getItems().addAll("Seleccione:", "Envasado", "Refrigerado", "Perecedero");
        comboTipo.getSelectionModel().selectFirst();
        comboTipo.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Seleccione:":
                    panelE.setVisible(false);
                    panelR.setVisible(false);
                    panelP.setVisible(false);
                    break;
                case "Envasado":
                    panelE.setVisible(true);
                    panelR.setVisible(false);
                    panelP.setVisible(false);
                    break;
                case "Refrigerado":
                    panelE.setVisible(false);
                    panelR.setVisible(true);
                    panelP.setVisible(false);
                    break;
                case "Perecedero":
                    panelE.setVisible(false);
                    panelR.setVisible(false);
                    panelP.setVisible(true);
                    break;
            }
        });
        PaisOrigen[] paises=PaisOrigen.values();
        comboPais.getItems().add(null);
        comboPais.getItems().addAll(paises);
        comboPais.setValue(null);

    }

    public void registrarProducto(){
        try
        {
            String tipoProducto = comboTipo.getSelectionModel().getSelectedItem();

            almacen.registrarProducto(tipoProducto,
                    txtCodigo.getText(),
                    txtNombre.getText(),
                    txtDescripcion.getText(),
                    txtValor.getText(),
                    txtExistencia.getText(),
                    dateVencimiento.getValue(),
                    txtAprobacion.getText(),
                    txtTemp.getText(),
                    dateEnvasado.getValue(),
                    txtPeso.getText(),
                    comboPais.getValue());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Se ha registrado correctamente el producto. ");
            alert.show();

        }
        catch (CampoVacioException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText(null);
            alert.show();
        }
        catch(NumberFormatException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("El valor unitario, la cantidad de existencias, la temperatura recomendada y el peso del envase deben ser numeros reales no caracteres");
            alert.setHeaderText(null);
            alert.show();
        }
        catch (TipoNoEspecificadoException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText(null);
            alert.show();
        } catch (ProductoRegistradoException e) {
            throw new RuntimeException(e);
        }
        catch (No8CaracteresException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText(null);
            alert.show();
        }
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
