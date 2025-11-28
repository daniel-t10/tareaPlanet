package com.ejemplo.api.spring.dogbreed;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "dog_breed")
@Data
public class DogBreedEntity {

    @Id
    private Integer id;

    private String name;
    private String origin;
    private String size;

    private Integer lifeSpanYears;
}