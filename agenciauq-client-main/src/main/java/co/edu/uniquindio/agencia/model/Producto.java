package co.edu.uniquindio.agencia.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Producto {

    private String tipo, codigo,nombre,descripcion;
    private double valorUnitario;
    private int cantExistencias;
}
