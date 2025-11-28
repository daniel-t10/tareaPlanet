package com.ejemplo.api.spring.dogbreed;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DogBreedRepository extends JpaRepository<DogBreedEntity, Integer> {

}