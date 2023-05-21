package com.portfolio.met.Dto;

import javax.validation.constraints.NotBlank;
/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class dtohys {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    
    // constructores

    public dtohys() {
    }

    public dtohys(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
    
    // getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }    
   }
