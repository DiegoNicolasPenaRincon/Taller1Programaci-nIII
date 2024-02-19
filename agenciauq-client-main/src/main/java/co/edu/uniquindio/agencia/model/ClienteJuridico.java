package co.edu.uniquindio.agencia.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ClienteJuridico extends Cliente {
    private String nit;

    public ClienteJuridico(String tipo, String nombre, String apellido, String id, String direccion, String telefono, String nit){
        super(tipo, nombre, apellido, id, direccion, telefono);
        this.nit=nit;
    }
}
