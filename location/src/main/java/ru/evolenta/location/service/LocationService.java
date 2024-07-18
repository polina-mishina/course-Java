package ru.evolenta.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.evolenta.location.model.Location;
import ru.evolenta.location.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    public ResponseEntity<Location> save(Location location) {
        if (repository.findById(location.getId()).isPresent()) {
            return new ResponseEntity<>(repository.findById(location.getId()).get(), HttpStatus.BAD_REQUEST);
        }
        return repository.findLocationByNameLikeIgnoreCase(location.getName()).isPresent()
                ? new ResponseEntity<>(repository.findLocationByNameLikeIgnoreCase(location.getName()).get(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(location), HttpStatus.CREATED);
    }
}
