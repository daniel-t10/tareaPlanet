package com.ejemplo.api.spring.planet;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PlanetDTO {

	@NotNull
	private Integer id;
	
	@Size(max= 45)
	private String nombre;
	private Integer radio;
	private BigDecimal masa;
	private Boolean tieneAnillos;
}
