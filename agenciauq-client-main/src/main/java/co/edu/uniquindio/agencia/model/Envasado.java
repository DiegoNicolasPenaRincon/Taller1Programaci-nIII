package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Envasado extends Producto  {

    private LocalDate fechaEnvasado;
    private float peso;
    private PaisOrigen pais;

}
