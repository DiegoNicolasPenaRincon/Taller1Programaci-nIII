package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Perecedero extends Producto  {

    private LocalDate vencimiento;

    public Perecedero(String tipo, String codigo, String nombre, String descripcion, double valorUni, int cantExis, LocalDate vencimiento){
        super(tipo, codigo, nombre, descripcion, valorUni, cantExis);
        this.vencimiento=vencimiento;
    }
}
