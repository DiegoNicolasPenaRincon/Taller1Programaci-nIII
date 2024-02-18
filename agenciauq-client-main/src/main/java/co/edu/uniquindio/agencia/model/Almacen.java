package co.edu.uniquindio.agencia.model;

import co.edu.uniquindio.agencia.controller.ClienteRegistradoException;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
public class Almacen {

    //private ArrayList<ClienteNatural> listaClientesNaturales;

    //private ArrayList<ClienteJuridico> listaClientesJuridicos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;

    private static Almacen Almacen;

    public static Almacen getInstance(){
        if(Almacen ==null){
            Almacen =new Almacen();
        }
        return Almacen;
    }

    private Almacen(){
      //  this.listaClientesNaturales=new ArrayList<>();
        //this.listaClientesJuridicos=new ArrayList<>();
        this.listaClientes=new ArrayList<>();

        this.listaProductos=new ArrayList<>();
    }

    public void registrarCliente(String nombre, String apellido,String ID,
                                 String direccion, String telefono, String NIT,String email,LocalDate nacimiento,String esNatural) throws CampoVacioException, TelefonoNoValidoException, IdentificacionNoValidaException, ClienteRegistradoException {
        validarCampoVacio(nombre,"Debe especificar el nombre del cliente");
        validarCampoVacio(ID,"Debe especificar la identificacion del cliente");
        validarCampoVacio(direccion,"Debe especificar la direccion del cliente");
        validarCampoVacio(telefono,"Debe especificar el telefono del cliente");
        validarCampoVacio(apellido,"Debe especificar los apellidos del cliente");
        validarTelefono(telefono);
        validarIdentificacion(ID);
        int IDApoyo=Integer.parseInt(ID);
        int telefonoApoyo=Integer.parseInt(ID);

        if(esNatural.equals("Natural"))
        {
            validarCampoVacio(String.valueOf(nacimiento),"Debe especificar la fecha de nacimiento del producto");
            validarCampoVacio(email,"Debe especificar el email");
            ClienteNatural natural=new ClienteNatural("Natural",nombre,apellido,ID,direccion,telefono,email,nacimiento);
            verificarRegistro(natural);
          //  listaClientesNaturales.add(natural);
            listaClientes.add(natural);
        }
        else if(esNatural.equals("Juridico"))
        {
            validarCampoVacio(NIT,"Debe especificar el NIT del cliente");
            ClienteJuridico juridico=new ClienteJuridico("Juridico", nombre,apellido,ID,direccion,telefono,NIT);
            //listaClientesJuridicos.add(juridico);
            verificarRegistro(juridico);
            listaClientes.add(juridico);
        }

    }

    public void registrarProducto(String tipo, String codigo, String nombre,String descripcion, String valorUni, String cantExis, LocalDate vencimiento,
                                  String codigoAprobacion, String temperaturaRecomendada, LocalDate fechaEnvasado, String peso, PaisOrigen pais) throws CampoVacioException {

        validarCampoVacio(codigo,"Debe especificar el codigo del producto");
        validarCampoVacio(nombre,"Debe especificar el nombre del producto");
        validarCampoVacio(descripcion,"Debe especificar la descripcion del producto");
        validarCampoVacio(valorUni,"Debe especificar el valor unitario del producto");
        validarCampoVacio(cantExis,"Debe especificar la cantidad de existencias que hay del producto");

        double valorUnitario=Double.parseDouble(valorUni);
        int cantidadExis=Integer.parseInt(cantExis);

        if(tipo.equals("Perecedero")){
            validarCampoVacio(String.valueOf(vencimiento),"Debe especificar la fecha de vencimiento");
            Perecedero perecedero=new Perecedero(tipo, codigo, nombre, descripcion,valorUnitario, cantidadExis, vencimiento);
            listaProductos.add(perecedero);
        }
        else if(tipo.equals("Refrigerante")){
            validarCampoVacio(codigoAprobacion,"Debe especificar el codigo de aprobacion");
            validarCampoVacio(String.valueOf(temperaturaRecomendada),"Debe especificar la temperatura recomendada");
            float temperatura=Float.parseFloat(temperaturaRecomendada);
            Refrigerante refrigerante=new Refrigerante(tipo, codigo, nombre, descripcion, valorUnitario, cantidadExis, codigoAprobacion, temperatura);
            listaProductos.add(refrigerante);
        } else if (tipo.equals("Envasado")) {
            validarCampoVacio(String.valueOf(fechaEnvasado),"Debe especificar la fecha de envasado del producto");
            validarCampoVacio(String.valueOf(peso),"Debe especificar el peso del producto");
            float pesoEnvase=Float.parseFloat(peso);
            validarCampoVacio(String.valueOf(pais),"Debe especificar el pais de origen del producto");
            Envasado envasado=new Envasado(tipo, codigo, nombre, descripcion, valorUnitario, cantidadExis, fechaEnvasado, pesoEnvase, pais);
            listaProductos.add(envasado);

        }
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

    public void validarIdentificacion(String identificacion) throws IdentificacionNoValidaException {
        if(identificacion.length()!=8)
        {
            throw new IdentificacionNoValidaException("Su identificacion debe contener unicamente 8 caracteres");
        }

    }

    public void verificarRegistro(Cliente cliente) throws ClienteRegistradoException {
        for(int i=0;i<listaClientes.size();i++)
        {
            if(cliente.equals(listaClientes.get(i)))
            {
                throw new ClienteRegistradoException("Ese cliente ya esta registrado");
            }
        }
    }
}
