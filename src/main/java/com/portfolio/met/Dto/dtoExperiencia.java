
package com.portfolio.met.Dto;

import javax.validation.constraints.NotBlank;
/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data		
@NoArgsConstructor
@AllArgsConstructor*/
public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
   
    // Constructores = vacío y select all

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    // Getter y Setter

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }   

    
}
