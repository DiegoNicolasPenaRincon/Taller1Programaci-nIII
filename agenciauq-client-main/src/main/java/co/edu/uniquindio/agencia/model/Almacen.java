package co.edu.uniquindio.agencia.model;

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
                                 String direccion, String telefono, String NIT,String email,LocalDate nacimiento,String esNatural) throws CampoVacioException {
        String campoObligatorio="Este campo es obligatorio";
        validarCampoVacio(nombre);
        validarCampoVacio(ID);
        validarCampoVacio(direccion);
        validarCampoVacio(telefono);
        validarCampoVacio(apellido);
        if(esNatural.equals("Natural"))
        {
            validarCampoVacio(String.valueOf(nacimiento));
            validarCampoVacio(email);
            ClienteNatural natural=new ClienteNatural("Natural",nombre,apellido,ID,direccion,telefono,email,nacimiento);
          //  listaClientesNaturales.add(natural);
            listaClientes.add(natural);
        }
        else
        {
            validarCampoVacio(NIT);
            ClienteJuridico juridico=new ClienteJuridico("Juridico", nombre,apellido,ID,direccion,telefono,NIT);
            //listaClientesJuridicos.add(juridico);
            listaClientes.add(juridico);
        }

    }

    public void registrarProducto(String tipo, String codigo, String nombre,String descripcion, String valorUni, String cantExis, LocalDate vencimiento,
                                  String codigoAprobacion, String temperaturaRecomendada, LocalDate fechaEnvasado, String peso, PaisOrigen pais) throws CampoVacioException {

        validarCampoVacio(codigo);
        validarCampoVacio(nombre);
        validarCampoVacio(descripcion);
        validarCampoVacio(valorUni);
        validarCampoVacio(cantExis);

        double valorUnitario=Double.parseDouble(valorUni);
        int cantidadExis=Integer.parseInt(cantExis);

        if(tipo.equals("Perecedero")){
            validarCampoVacio(String.valueOf(vencimiento));
            Perecedero perecedero=new Perecedero(tipo, codigo, nombre, descripcion,valorUnitario, cantidadExis, vencimiento);
            listaProductos.add(perecedero);
        }
        else if(tipo.equals("Refrigerante")){
            validarCampoVacio(codigoAprobacion);
            validarCampoVacio(String.valueOf(temperaturaRecomendada));
            float temperatura=Float.parseFloat(temperaturaRecomendada);
            Refrigerante refrigerante=new Refrigerante(tipo, codigo, nombre, descripcion, valorUnitario, cantidadExis, codigoAprobacion, temperatura);
            listaProductos.add(refrigerante);
        } else if (tipo.equals("Envasado")) {
            validarCampoVacio(String.valueOf(fechaEnvasado));
            validarCampoVacio(String.valueOf(peso));
            float pesoEnvase=Float.parseFloat(peso);
            validarCampoVacio(String.valueOf(pais));
            Envasado envasado=new Envasado(tipo, codigo, nombre, descripcion, valorUnitario, cantidadExis, fechaEnvasado, pesoEnvase, pais);
            listaProductos.add(envasado);

        }
    }


    //Validaciones
     public void validarCampoVacio(String cualquiera) throws CampoVacioException {
         String msg="Este campo es obligatorio";
        if(cualquiera.isEmpty()||cualquiera==null)
        {
            throw new CampoVacioException(msg);
        }

     }

}
