package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
public class Almacen {

    private ArrayList<ClienteNatural> listaClientesNaturales;

    private ArrayList<ClienteJuridico> listaClientesJuridicos;

    private ArrayList<Producto> listaProductos;

    private static Almacen Almacen;

    public static Almacen getInstance(){
        if(Almacen ==null){
            Almacen =new Almacen();
        }
        return Almacen;
    }

    private Almacen(){
        this.listaClientesNaturales=new ArrayList<ClienteNatural>();
        this.listaClientesJuridicos=new ArrayList<ClienteJuridico>();
        this.listaProductos=new ArrayList<>();
    }

    public void registrarCliente(String nombre, String apellido,String ID, String direccion, String telefono, String NIT,String email,String nacimiento,String esNatural) throws CampoVacioException {
        String campoObligatorio="Este campo es obligatorio";
        validarCampoVacio(nombre,campoObligatorio);
        validarCampoVacio(ID,campoObligatorio);
        validarCampoVacio(direccion,campoObligatorio);
        validarCampoVacio(telefono,campoObligatorio);
        validarCampoVacio(apellido,campoObligatorio);
        if(esNatural.equals("Natural"))
        {
            validarCampoVacio(nacimiento,campoObligatorio);
            validarCampoVacio(email,campoObligatorio);
            ClienteNatural natural=new ClienteNatural(nombre,apellido,ID,direccion,telefono,email,LocalDate.parse(nacimiento));
            listaClientesNaturales.add(natural);
        }
        else
        {
            validarCampoVacio(NIT,campoObligatorio);
            ClienteJuridico juridico=new ClienteJuridico(nombre,apellido,ID,direccion,telefono,NIT);
            listaClientesJuridicos.add(juridico);
        }

    }


    //Validaciones
     public void validarCampoVacio(String cualquiera,String msg) throws CampoVacioException {
        if(cualquiera.isEmpty()||cualquiera==null)
        {
            throw new CampoVacioException(msg);
        }
     }
}
