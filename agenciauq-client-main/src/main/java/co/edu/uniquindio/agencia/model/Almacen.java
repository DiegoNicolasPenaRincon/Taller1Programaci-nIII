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

    public void registrarClienteNatural(String nombre, String apellido,String ID, String direccion, String telefono,String email,String nacimiento) throws CampoVacioException {

        String campoObligatorio="Este campo es obligatorio";
        validarCampoVacio(nacimiento,campoObligatorio);
        validarCampoVacio(email,campoObligatorio);
        ClienteNatural natural=new ClienteNatural(nombre,apellido,ID,direccion,telefono,email,LocalDate.parse(nacimiento));
        listaClientesNaturales.add(natural);


    }

    public void registrarClienteJuridico(String nombre, String apellido,String ID, String direccion, String telefono,String NIT) throws CampoVacioException, TelefonoNoValidoException {

        String campoObligatorio="Este campo es obligatorio";
        validarCampoVacio(NIT,campoObligatorio);
        ClienteJuridico juridico=new ClienteJuridico(nombre,apellido,ID,direccion,telefono,NIT);
        listaClientesJuridicos.add(juridico);

    }


    //Validaciones
     public void validarCampoVacio(String cualquiera,String msg) throws CampoVacioException {
        if(cualquiera.isEmpty()||cualquiera==null)
        {
            throw new CampoVacioException(msg);
        }
     }

     public void validarTelefono(String telefono) throws TelefonoNoValidoException {
        if(telefono.length()!=7)
        {
            throw new TelefonoNoValidoException("El telefono debe contener unica y exclusivamente 7 digitos");
        }
     }

     public void validarValoresGeneralesClientes(String nombre, String apellido,String ID, String direccion, String telefono) throws CampoVacioException, TelefonoNoValidoException, IdentificacionNoValidaException {
         String campoObligatorio="Este campo es obligatorio";
         validarCampoVacio(nombre,campoObligatorio);
         validarCampoVacio(ID,campoObligatorio);
         validarCampoVacio(direccion,campoObligatorio);
         validarCampoVacio(telefono,campoObligatorio);
         validarTelefono(telefono);
         validarCampoVacio(apellido,campoObligatorio);
         validarIdentificacion(ID,"Su identificacion debe contener 8 caracteres");
     }

     public void validarIdentificacion(String identificacion,String msg) throws IdentificacionNoValidaException {
        if(identificacion.length()!=8)
        {
            throw new IdentificacionNoValidaException(msg);
        }
     }
}
