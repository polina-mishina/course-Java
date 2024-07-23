package ru.evolenta.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.evolenta.person.model.Person;
import ru.evolenta.person.model.Weather;
import ru.evolenta.person.repository.PersonRepository;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${location.url}")
    private String url;

    public ResponseEntity<Person> save(Person person) {
        Optional<Person> personOptional = repository.findById(person.getId());
        return personOptional.map(value -> new ResponseEntity<>(value, HttpStatus.BAD_REQUEST))
                .orElseGet(() -> new ResponseEntity<>(repository.save(person), HttpStatus.CREATED));
    }

    public ResponseEntity<Weather> getWeather(int id) {
        Optional<Person> personOptional = repository.findById(id);
        if (personOptional.isPresent()) {
            String location = personOptional.get().getLocation();
            Weather weather = restTemplate.getForObject(url +  location, Weather.class);
            return new ResponseEntity<>(weather, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Person> update(int id, Person person) {
        Optional<Person> personOptional = repository.findById(id);
        if (personOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        person.setId(id);
        return new ResponseEntity<>(repository.save(person), HttpStatus.OK);
    }
}
