package com.ejemplo.api.spring.planet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;
	
	public List<PlanetDTO> getAllPlanets(){
		List<PlanetEntity> planets = planetRepository.findAll();
		return planets.stream().map(this::converterPlanetEntityToPlanetDTO).toList();
	}
	private PlanetDTO converterPlanetEntityToPlanetDTO(PlanetEntity planetEntity) {
		PlanetDTO planetDTO = new PlanetDTO();
		planetDTO.setId(planetEntity.getId());
		planetDTO.setMasa(planetEntity.getMass());
		planetDTO.setNombre(planetEntity.getNombre());
		planetDTO.setRadio(planetEntity.getRadio());
		planetDTO.setTieneAnillos(planetEntity.getTieneAnillos());
		return planetDTO;
	}
}
