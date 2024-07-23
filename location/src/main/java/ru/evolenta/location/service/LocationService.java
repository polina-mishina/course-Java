package ru.evolenta.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.evolenta.location.model.Location;
import ru.evolenta.location.model.Weather;
import ru.evolenta.location.repository.LocationRepository;

import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<Weather> redirectRequestWeather(String name) {
        Optional<Location> locationOptional = repository.findByName(name);
        if (locationOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Location location = locationOptional.get();
        String url = String.format("http://localhost:8082/weather?lat=%s&lon=%s", location.getLatitude(), location.getLongitude());
        return new ResponseEntity<>(restTemplate.getForObject(url, Weather.class), HttpStatus.OK);
    }

    public ResponseEntity<Location> save(Location location) {
        if (repository.findById(location.getId()).isPresent()) {
            return new ResponseEntity<>(repository.findById(location.getId()).get(), HttpStatus.BAD_REQUEST);
        }
        return repository.findByName(location.getName()).isPresent()
                ? new ResponseEntity<>(repository.findByName(location.getName()).get(), HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(repository.save(location), HttpStatus.CREATED);
    }

    public ResponseEntity<Location> updateByName(String name, Location location) {
        Optional<Location> locationOptional = repository.findByName(name);
        if (locationOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Location updatedLocation = locationOptional.get();
        updatedLocation.setName(location.getName());
        updatedLocation.setLatitude(location.getLatitude());
        updatedLocation.setLongitude(location.getLongitude());

        return new ResponseEntity<>(repository.save(updatedLocation), HttpStatus.OK);
    }
}
