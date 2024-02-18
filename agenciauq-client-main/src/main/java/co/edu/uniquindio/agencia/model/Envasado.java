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

    public Envasado(String tipo, String codigo, String nombre, String descripcion, double valorUni, int cantExis,
                    LocalDate fechaEnvasado, float peso, PaisOrigen pais){
        super(tipo, codigo, nombre, descripcion, valorUni, cantExis);
        this.fechaEnvasado=fechaEnvasado;
        this.peso=peso;
        this.pais=pais;
    }

}
