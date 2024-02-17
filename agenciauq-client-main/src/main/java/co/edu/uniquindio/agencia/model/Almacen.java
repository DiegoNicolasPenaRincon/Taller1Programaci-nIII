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

    public Almacen(){
        this.listaClientes=new ArrayList<>();
        this.listaProductos=new ArrayList<>();
    }

    public void registrarClienteNatural(String nombre, String apellido,
                                        String ID, String direccion, String telefono, String email,
                                        LocalDate fechaNac ){
        ClienteNatural cliente=new ClienteNatural(nombre, apellido, ID, direccion, telefono, email, fechaNac);
        listaClientes.add(cliente);
    }

    public void registrarClienteJuridico(String nombre, String apellido,
                                         String ID, String direccion, String telefono, String NIT){
        ClienteJuridico cliente=new ClienteJuridico(nombre, apellido, ID, direccion, telefono, NIT);
        listaClientes.add(cliente);
    }




}
