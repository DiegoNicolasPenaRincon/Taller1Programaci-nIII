package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.util.ArrayList;

@Getter
public class Almacen {

    private ArrayList<Cliente> listaClientes=new ArrayList<Cliente>();

    private ArrayList<Envasado> listaEnvasados=new ArrayList<Envasado>();

    private ArrayList<Perecedero> listaPerecedero=new ArrayList<Perecedero>();

    private ArrayList<Refrigerante> listaRefrigerantes=new ArrayList<Refrigerante>();

    private static Almacen Almacen;

    public static Almacen getInstance(){
        if(Almacen ==null){
            Almacen =new Almacen();
        }
        return Almacen;
    }



}
