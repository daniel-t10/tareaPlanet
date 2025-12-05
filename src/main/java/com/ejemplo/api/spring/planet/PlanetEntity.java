package com.ejemplo.api.spring.planet;

import jakarta.persistence.*;

@Entity
@Table(name = "planet")
public class PlanetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "radius_km")
    private Integer radio;

    @Column(name = "mass_1e24kg")
    private Double masa;

    @Column(name = "has_rings")
    private Boolean tieneAnillos;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getRadio() { return radio; }
    public void setRadio(Integer radio) { this.radio = radio; }

    public Double getMasa() { return masa; }
    public void setMasa(Double masa) { this.masa = masa; }

    public Boolean getTieneAnillos() { return tieneAnillos; }
    public void setTieneAnillos(Boolean tieneAnillos) { this.tieneAnillos = tieneAnillos; }
}
