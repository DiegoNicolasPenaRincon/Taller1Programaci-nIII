package co.edu.uniquindio.agencia.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public abstract class Cliente {

    private String nombre, apellidos, identificacion, direccion,telefono;

}
