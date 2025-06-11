package com.example.assignment3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService service;

    // Redirect root path to animals list
    @GetMapping("/")
    public String redirectToAnimalsList() {
        return "redirect:/animals";
    }

    // List animals
    @GetMapping("/animals")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalsList", service.getAll());
        model.addAttribute("title", "All Animals");
        return "animals-list";
    }

    // Show animal details
    @GetMapping("/animals/{id}")
    public String getAnimalById(@PathVariable Long id, Model model) {
        Animal animal = service.getById(id);
        if (animal == null) {
            return "redirect:/animals";
        }
        model.addAttribute("animal", animal);
        model.addAttribute("title", "Animal Details");
        return "animal-details";
    }

    // Search by name
    @GetMapping("/animals/name")
    public String getAnimalsByName(@RequestParam String search, Model model) {
        model.addAttribute("animalsList", service.getByName(search));
        model.addAttribute("title", "Animals Matching: " + search);
        return "animals-list";
    }

    // Filter by habitat
    @GetMapping("/animals/habitat/{habitat}")
    public String getAnimalsByHabitat(@PathVariable String habitat, Model model) {
        model.addAttribute("animalsList", service.getByHabitat(habitat));
        model.addAttribute("title", "Animals in Habitat: " + habitat);
        return "animals-list";
    }

    // Show create form
    @GetMapping("/animals/createForm")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("title", "Create New Animal");
        return "animals-create";
    }

    // Handle create form submission
    @PostMapping("/animals")
    public String createAnimal(@ModelAttribute Animal animal) {
        service.create(animal);
        return "redirect:/animals";
    }

    // Show update form
    @GetMapping("/animals/updateForm/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Animal animal = service.getById(id);
        if (animal == null) {
            return "redirect:/animals";
        }
        model.addAttribute("animal", animal);
        model.addAttribute("title", "Update Animal");
        return "animals-update";
    }

    // Handle update form submission
    @PostMapping("/animals/update/{id}")
    public String updateAnimal(@PathVariable Long id, @ModelAttribute Animal animal) {
        service.update(id, animal);
        return "redirect:/animals";
    }

    // Delete animal
    @GetMapping("/animals/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/animals";
    }
}