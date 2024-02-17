package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClienteNatural extends Cliente {

    private String email;

    private LocalDate nacimiento;

    public ClienteNatural(String nombre, String apellido, String ID, String direccion, String telefono,
                          String email, LocalDate fechaNac){
        super(nombre, apellido, ID, direccion, telefono);
        this.email=email;
        this.nacimiento=fechaNac;
    }
}
