package com.ejemplo.api.spring.planet;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanetDTO {

    private Integer id; 

    @NotNull
    @Size(max = 45)
    private String nombre;

    @NotNull
    private Integer radio;

    @NotNull
    private double masa;

    @NotNull
    private Boolean tieneAnillos;
}
