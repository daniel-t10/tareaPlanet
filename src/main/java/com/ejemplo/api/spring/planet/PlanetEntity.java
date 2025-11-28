package com.ejemplo.api.spring.planet;




import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "planet")
@Getter
@Setter

public class PlanetEntity {

	@Id
	@Column (nullable = false, updatable=false, name="id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, name="name")
	private String nombre;
	
	@Column(name="radius_km")
	private Integer radio;
	
	@Column(name = "mass_1e24kg")
	private BigDecimal mass;
	
	@Column(name="has_rings")
	private Boolean tieneAnillos;
}
