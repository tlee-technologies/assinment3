package com.example.assignment3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public List<Animal> getAll() {
        return repository.findAll();
    }

    public Animal getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Animal> getByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Animal> getByHabitat(String habitat) {
        return repository.findByHabitat(habitat);
    }

    public Animal create(Animal animal) {
        return repository.save(animal);
    }

    public Animal update(Long id, Animal updatedAnimal) {
        Animal existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(updatedAnimal.getName());
        existing.setDescription(updatedAnimal.getDescription());
        existing.setHabitat(updatedAnimal.getHabitat());
        existing.setDiet(updatedAnimal.getDiet());
        existing.setImageUrl(updatedAnimal.getImageUrl());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}