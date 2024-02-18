package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Refrigerante extends Producto {

    private String codigoAprobacion;

    private float temperaturaRecomendada;

    public Refrigerante(String tipo, String codigo, String nombre, String descripcion, double valorUni, int cantExis,
                        String codigoAprobacion, float temperaturaRecomendada){
        super(tipo, codigo, nombre, descripcion, valorUni, cantExis);
        this.codigoAprobacion=codigoAprobacion;
        this.temperaturaRecomendada=temperaturaRecomendada;
    }

}
