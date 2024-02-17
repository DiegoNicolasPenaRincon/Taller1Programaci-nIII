package co.edu.uniquindio.agencia.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public abstract class Producto {

    private String codigo,nombre,descripcion;
    private double valorUnitario;
    private int cantExistencias;
}
