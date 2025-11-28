package com.ejemplo.api.spring.dogbreed;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogBreedService {

    @Autowired 
    DogBreedRepository dogBreedRepository;

    public List<DogBreedDTO> getAllDogBreeds() {
        return dogBreedRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private DogBreedDTO toDTO(DogBreedEntity entity) {
        DogBreedDTO dto = new DogBreedDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setOrigin(entity.getOrigin());
        dto.setSize(entity.getSize());
        dto.setLifeSpanYears(entity.getLifeSpanYears());
        return dto;
    }
}
