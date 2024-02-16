package co.edu.uniquindio.agencia.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioController {
    @FXML
    private Button btnListaCliente;
    
    @FXML
    private Button btnListaProducto;

    @FXML
    private Button btnRegistroCliente;

    @FXML
    private Button btnRegistroProducto;

    private Stage stage;

    public void setStage(Stage PrimaryStage) {
        stage=PrimaryStage;
    }

    public void mostrarMensaje(ActionEvent e){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Mensaje");
        alert.setContentText("Esta es una prueba");
        alert.show();

    }

    public void mostrarRegistroProducto() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Ventanas/RegistroProducto.fxml"));
        Parent root=loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        //RegistroProductoController controller =loader.getController();
      //  controller.init(stage, this, cliente);
        stage.show();
        this.stage.close();
    }

    public void mostrarRegistroCliente() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Ventanas/RegistroCliente.fxml"));
        Parent root=loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        //RegistroClienteController controller =loader.getController();
        //  controller.init(stage, this, cliente);
        stage.show();
        this.stage.close();
    }

    public void mostrarListaCliente() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Ventanas/ListaCliente.fxml"));
        Parent root=loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        //ListaClienteController controller =loader.getController();
        //  controller.init(stage, this, cliente);
        stage.show();
        this.stage.close();
    }

    public void mostrarListaProducto() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Ventanas/ListaProducto.fxml"));
        Parent root=loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        //ListaClienteController controller =loader.getController();
        //  controller.init(stage, this, cliente);
        stage.show();
        this.stage.close();
    }

}
