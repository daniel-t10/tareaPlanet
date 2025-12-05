package com.ejemplo.api.spring.planet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;
	
	public List<PlanetDTO> getAllPlanets(){
		List<PlanetEntity> planets = planetRepository.findAll();
		return planets.stream().map(this::convertPlanetEntityToPlanetDTO).toList();
	}
	public PlanetDTO getPlanetById(Integer id) {
		PlanetEntity entity = planetRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No encontrado"));
		return convertPlanetEntityToPlanetDTO(entity);
	}
	//crear
	public PlanetDTO createPlanet(PlanetDTO dto) {
		PlanetEntity entity = convertPlanetDTOToPlanetEntity(dto);
		PlanetEntity saved = planetRepository.save(entity);
		return convertPlanetEntityToPlanetDTO(saved);
	}
	//updatear
	public PlanetDTO updatePlanet(Integer id, PlanetDTO dto) {
		PlanetEntity entity = planetRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No encontrado"));
		entity.setNombre(dto.getNombre());
		entity.setRadio(dto.getRadio());
		entity.setMasa(dto.getMasa());
		entity.setTieneAnillos(dto.getTieneAnillos());
		
		PlanetEntity updated = planetRepository.save(entity);
		return convertPlanetEntityToPlanetDTO(updated);
	}
	//delete
	public void deletePlanet(Integer id) {
		if(!planetRepository.existsById(id)) {
			throw new RuntimeException("no encontrado");
		}
		planetRepository.deleteById(id);
	}
	

	private PlanetDTO convertPlanetEntityToPlanetDTO(PlanetEntity planetEntity) {
	    PlanetDTO planetDTO = new PlanetDTO();
	    planetDTO.setId(planetEntity.getId());
	    planetDTO.setNombre(planetEntity.getNombre());
	    planetDTO.setRadio(planetEntity.getRadio());
	    planetDTO.setMasa(planetEntity.getMasa());
	    planetDTO.setTieneAnillos(planetEntity.getTieneAnillos());
	    return planetDTO;
	}
	
	private PlanetEntity convertPlanetDTOToPlanetEntity(PlanetDTO dto) {
	    PlanetEntity entity = new PlanetEntity();
	    entity.setId(dto.getId());
	    entity.setNombre(dto.getNombre());
	    entity.setRadio(dto.getRadio());
	    entity.setMasa(dto.getMasa());
	    entity.setTieneAnillos(dto.getTieneAnillos());
	    return entity;
	}
}
