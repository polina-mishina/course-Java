package ru.evolenta.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${weather.url}")
    private String weatherUrl;

    public ResponseEntity<Weather> redirectRequestWeather(String name) {
        Optional<Location> locationOptional = repository.findByName(name);
        if (locationOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Location location = locationOptional.get();
        String url = String.format("%s?lat=%s&lon=%s", weatherUrl, location.getLatitude(), location.getLongitude());
        return new ResponseEntity<>(restTemplate.getForObject(url, Weather.class), HttpStatus.OK);
    }

    public ResponseEntity<Location> save(Location location) {
        Optional<Location> locationOptional = repository.findById(location.getId());
        return locationOptional.map(value -> new ResponseEntity<>(value, HttpStatus.BAD_REQUEST))
                .orElseGet(() -> new ResponseEntity<>(repository.save(location), HttpStatus.CREATED));
    }

    public ResponseEntity<Location> updateByName(String name, Location location) {
        Optional<Location> locationOptional = repository.findByName(name);
        if (locationOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        location.setId(locationOptional.get().getId());
        return new ResponseEntity<>(repository.save(location), HttpStatus.OK);
    }
}
