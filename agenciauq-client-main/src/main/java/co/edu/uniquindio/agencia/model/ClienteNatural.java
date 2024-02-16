package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ClienteNatural extends Cliente {

    private String email;

    private LocalDate nacimiento;
}
