package com.example.assignment3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController is a REST controller that handles HTTP requests related to
 * animals. It provides endpoints for CRUD operations and search filters.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get all animals
     * @return List of all animals
     */
    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    /**
     * Get an animal by ID
     * @param id the animal ID
     * @return animal with matching ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getById(@PathVariable Long id) {
        Animal animal = service.getById(id);
        return (animal != null)
                ? new ResponseEntity<>(animal, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Get animals by partial name match
     * @param search partial name
     * @return matching animals
     */
    @GetMapping("/name")
    public ResponseEntity<List<Animal>> getByName(@RequestParam String search) {
        return new ResponseEntity<>(service.getByName(search), HttpStatus.OK);
    }

    /**
     * Get animals by habitat
     * @param habitat exact match
     * @return matching animals
     */
    @GetMapping("/habitat/{habitat}")
    public ResponseEntity<List<Animal>> getByHabitat(@PathVariable String habitat) {
        return new ResponseEntity<>(service.getByHabitat(habitat), HttpStatus.OK);
    }

    /**
     * Create a new animal entry
     * @param animal request body
     * @return created animal
     */
    @PostMapping
    public ResponseEntity<Animal> create(@RequestBody Animal animal) {
        return new ResponseEntity<>(service.create(animal), HttpStatus.CREATED);
    }

    /**
     * Update an existing animal
     * @param id animal ID to update
     * @param animal updated values
     * @return updated animal
     */
    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal) {
        Animal updated = service.update(id, animal);
        return (updated != null)
                ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete an animal by ID
     * @param id ID to delete
     * @return updated list of animals
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Animal>> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}