package com.ejemplo.api.spring.dogbreed;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public DogBreedDTO createDogBreed(DogBreedDTO dogBreedDTO) {
        DogBreedEntity dogBreedEntity = toEntity(dogBreedDTO);
        DogBreedEntity savedEntity = dogBreedRepository.save(dogBreedEntity);
        return toDTO(savedEntity);
    }

    public DogBreedDTO updateDogBreed(@PathVariable Integer id, DogBreedDTO dogBreedDTO) {
        Optional<DogBreedEntity> optionalBreed = dogBreedRepository.findById(id);

        if (optionalBreed.isPresent()) {
            DogBreedEntity dogBreedEntity = optionalBreed.get();
            dogBreedEntity.setName(dogBreedDTO.getName());
            dogBreedEntity.setOrigin(dogBreedDTO.getOrigin());
            dogBreedEntity.setSize(dogBreedDTO.getSize());
            dogBreedEntity.setLifeSpanYears(dogBreedDTO.getLifeSpanYears());
            DogBreedEntity updatedEntity = dogBreedRepository.save(dogBreedEntity);
            return toDTO(updatedEntity);
        } else {
            throw new RuntimeException("Dog breed not found with id " + id);
        }
    }

    public void deleteDogBreed(Integer id) {
        if (dogBreedRepository.existsById(id)) {
            dogBreedRepository.deleteById(id);
        } else {
            throw new RuntimeException("Dog breed not found with id " + id); 
        }
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

    private DogBreedEntity toEntity(DogBreedDTO dto) {
        DogBreedEntity entity = new DogBreedEntity();
        entity.setName(dto.getName());
        entity.setOrigin(dto.getOrigin());
        entity.setSize(dto.getSize());
        entity.setLifeSpanYears(dto.getLifeSpanYears());
        return entity;
    }
}