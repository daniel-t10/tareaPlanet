package com.ejemplo.api.spring.planet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping
    public List<PlanetDTO> getAll() {
        return planetService.getAllPlanets();
    }

    @GetMapping("/{id}")
    public PlanetDTO getOne(@PathVariable Integer id) {
        return planetService.getPlanetById(id);
    }

    @PostMapping
    public PlanetDTO create(@RequestBody PlanetDTO dto) {
        return planetService.createPlanet(dto);
    }

    @PutMapping("/{id}")
    public PlanetDTO update(@PathVariable Integer id, @RequestBody PlanetDTO dto) {
        return planetService.updatePlanet(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        planetService.deletePlanet(id);
        return "Planet deleted successfully";
    }
}
