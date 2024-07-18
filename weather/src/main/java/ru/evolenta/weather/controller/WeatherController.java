package ru.evolenta.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.weather.model.Weather;
import ru.evolenta.weather.repository.WeatherRepository;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository repository;

    @GetMapping
    public Optional<Weather> findByLatAndLon(@RequestParam("lat") Double lat, @RequestParam("lon") Double lon) {
        return repository.findWeatherByLatitudeAndLongitude(lat, lon);
    }

    @PostMapping
    public ResponseEntity<Weather> save(@RequestBody Weather weather) {
        Weather saved = repository.save(weather);
        return ResponseEntity.ok(saved);
    }
}
