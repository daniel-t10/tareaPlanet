package com.ejemplo.api.spring.dogbreed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/dog-breeds", produces = MediaType.APPLICATION_JSON_VALUE)
public class DogBreedController {

    @Autowired 
    DogBreedService dogBreedService;

    @GetMapping
    public ResponseEntity<List<DogBreedDTO>> getAll() {
        List<DogBreedDTO> list = dogBreedService.getAllDogBreeds();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
