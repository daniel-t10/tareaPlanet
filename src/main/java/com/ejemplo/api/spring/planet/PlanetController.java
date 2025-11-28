package com.ejemplo.api.spring.planet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/planets", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlanetController {
	
	 @Autowired PlanetService planetService;
	 
	 @GetMapping
	 public ResponseEntity<List<PlanetDTO>> getAllPlanets(){
		 List<PlanetDTO> planets = planetService.getAllPlanets();
		 return new ResponseEntity<List<PlanetDTO>>(planets, HttpStatus.OK);
	 }

}
