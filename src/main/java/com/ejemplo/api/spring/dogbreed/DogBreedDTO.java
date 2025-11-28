package com.ejemplo.api.spring.dogbreed;


import lombok.Data;

@Data
public class DogBreedDTO {
    private Integer id;
    private String name;
    private String origin;
    private String size;
    private Integer lifeSpanYears;
}