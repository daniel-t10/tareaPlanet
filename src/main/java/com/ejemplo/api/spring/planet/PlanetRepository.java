package com.ejemplo.api.spring.planet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<PlanetEntity, Integer> {

	PlanetEntity save(PlanetDTO entity);

}
