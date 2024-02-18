package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
public class Almacen {

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
        this.listaClientes=new ArrayList<Cliente>();

        this.listaProductos=new ArrayList<Producto>();
    }

    public void registrarCliente(String nombre, String apellido,String ID,
                                 String direccion, String telefono, String NIT,String email,LocalDate nacimiento,String esNatural) throws CampoVacioException, TelefonoNoValidoException, ClienteRegistradoException, No8CaracteresException {
        validarCampoVacio(nombre,"Debe especificar el nombre del cliente");
        validarCampoVacio(ID,"Debe especificar la identificacion del cliente");
        validarCampoVacio(direccion,"Debe especificar la direccion del cliente");
        validarCampoVacio(telefono,"Debe especificar el telefono del cliente");
        validarCampoVacio(apellido,"Debe especificar los apellidos del cliente");
        validarTelefono(telefono);
        validarIdentificacionYCodigo(ID,"Su identificacion debe contener 8 caracteres");
        int IDApoyo=Integer.parseInt(ID);
        int telefonoApoyo=Integer.parseInt(ID);

        if(esNatural.equals("Natural"))
        {
            if(nacimiento==null)
            {
                throw new CampoVacioException("Debe especificar la fecha de nacimiento ");
            }

            validarCampoVacio(email,"Debe especificar el email");
            ClienteNatural natural=new ClienteNatural("Natural",nombre,apellido,ID,direccion,telefono,email,nacimiento);
            verificarRegistro(natural);
          //  listaClientesNaturales.add(natural);
            listaClientes.add(natural);
        }
        else if(esNatural.equals("Juridica"))
        {
            validarCampoVacio(NIT,"Debe especificar el NIT del cliente");
            ClienteJuridico juridico=new ClienteJuridico("Juridico", nombre,apellido,ID,direccion,telefono,NIT);
            //listaClientesJuridicos.add(juridico);
            verificarRegistro(juridico);
            listaClientes.add(juridico);
        }

    }

    public void registrarProducto(String tipo, String codigo, String nombre,String descripcion, String valorUni, String cantExis, LocalDate vencimiento,
                                  String codigoAprobacion, String temperaturaRecomendada, LocalDate fechaEnvasado, String peso, PaisOrigen pais) throws CampoVacioException, TipoNoEspecificadoException, ProductoRegistradoException, No8CaracteresException {

        validarCampoVacio(codigo,"Debe especificar el codigo del producto");
        validarIdentificacionYCodigo(codigo,"El codigo identificativo del producto debe contener 8 caracteres");
        validarCampoVacio(nombre,"Debe especificar el nombre del producto");
        validarCampoVacio(descripcion,"Debe especificar la descripcion del producto");
        validarCampoVacio(valorUni,"Debe especificar el valor unitario del producto");
        validarCampoVacio(cantExis,"Debe especificar la cantidad de existencias que hay del producto");

        double valorUnitario=Double.parseDouble(valorUni);
        int cantidadExis=Integer.parseInt(cantExis);

        if(tipo.equals("Perecedero"))
        {
            if(vencimiento==null)
            {
                throw new CampoVacioException("Debe especificar la fecha de vencimiento del producto");
            }
            Perecedero perecedero=new Perecedero(tipo, codigo, nombre, descripcion,valorUnitario, cantidadExis, vencimiento);
            verificarProductos(perecedero);
            listaProductos.add(perecedero);
        }
        else if(tipo.equals("Refrigerante"))
        {
            validarCampoVacio(codigoAprobacion,"Debe especificar el codigo de aprobacion");
            validarIdentificacionYCodigo(codigoAprobacion,"El codigo de aprobacion debe contener 8 caracteres");
            validarCampoVacio(String.valueOf(temperaturaRecomendada),"Debe especificar la temperatura recomendada");
            float temperatura=Float.parseFloat(temperaturaRecomendada);
            Refrigerante refrigerante=new Refrigerante(tipo, codigo, nombre, descripcion, valorUnitario, cantidadExis, codigoAprobacion, temperatura);
            verificarProductos(refrigerante);
            listaProductos.add(refrigerante);
        }
        else if (tipo.equals("Envasado"))
        {
            if(fechaEnvasado==null)
            {
                throw new CampoVacioException("Debe especificar la fecha de vencimiento del producto");
            }
            validarCampoVacio(String.valueOf(peso),"Debe especificar el peso del producto");
            float pesoEnvase=Float.parseFloat(peso);
            if(pais==null)
            {
                throw new CampoVacioException("Debe especificar el pais de origen del producto");
            }
            Envasado envasado=new Envasado(tipo, codigo, nombre, descripcion, valorUnitario, cantidadExis, fechaEnvasado, pesoEnvase, pais);
            verificarProductos(envasado);
            listaProductos.add(envasado);
        }
        else
        {
            throw new TipoNoEspecificadoException("Debe especificar el tipo de producto");
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

    public void validarIdentificacionYCodigo(String cualquiera,String msg) throws No8CaracteresException {
        if(cualquiera.length()!=8)
        {
            throw new No8CaracteresException(msg);
        }

    }

    public void verificarRegistro(Cliente cliente) throws ClienteRegistradoException {
        for(int i=0;i<listaClientes.size();i++)
        {
            if(cliente.getIdentificacion().equals(listaClientes.get(i).getIdentificacion()))
            {
                throw new ClienteRegistradoException("Ese cliente ya esta registrado");
            }
        }
    }

    public void verificarProductos(Producto producto) throws ProductoRegistradoException {
        for(int i=0;i<listaProductos.size();i++)
        {
            if(producto.getCodigo().equals(listaProductos.get(i).getCodigo()))
            {
                throw new ProductoRegistradoException("Ese producto ya se encuentra registrado");
            }
        }
    }

}
