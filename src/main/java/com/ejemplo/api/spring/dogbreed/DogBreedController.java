package com.ejemplo.api.spring.dogbreed;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
@RequestMapping(value = "api/dog-breeds", produces = MediaType.APPLICATION_JSON_VALUE)
public class DogBreedController {

    private final DataSource dataSource;

    // ✅ FIXED: constructor name must match class name
    public DogBreedController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/test-db")
    public String testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "✔ Connected! SQL Server version: "
                    + connection.getMetaData().getDatabaseProductVersion()
                    + " | Database: " + connection.getCatalog();
        } catch (Exception e) {
            return "❌ Connection FAILED: " + e.getMessage();
        }
    }
}
