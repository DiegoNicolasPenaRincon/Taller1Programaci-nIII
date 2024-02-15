package co.edu.uniquindio.agencia.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Refrigerante extends Producto {

    private String codigoAprobacion;

    private double temperaturaRecomendada;

}
