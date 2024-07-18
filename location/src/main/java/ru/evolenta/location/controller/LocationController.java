package ru.evolenta.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.location.model.Location;
import ru.evolenta.location.repository.LocationRepository;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @GetMapping("/all")
    public Iterable<Location> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @GetMapping
    public Optional<Location> findByName(@RequestParam("name") String name) {
        return repository.findLocationByNameLikeIgnoreCase(name);
    }

    @PostMapping
    public ResponseEntity<Location> save(@RequestBody Location location) {
        if (repository.findById(location.getId()).isPresent()) {
            return new ResponseEntity<>(repository.findById(location.getId()).get(), HttpStatus.BAD_REQUEST);
        }
        return repository.findLocationByNameLikeIgnoreCase(location.getName()).isPresent()
                ? new ResponseEntity<>(repository.findLocationByNameLikeIgnoreCase(location.getName()).get(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(location), HttpStatus.CREATED);
    }
}
