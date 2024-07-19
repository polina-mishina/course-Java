package ru.evolenta.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.evolenta.person.model.Person;
import ru.evolenta.person.repository.PersonRepository;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public ResponseEntity<Person> save(Person person) {
        Optional<Person> personOptional = repository.findById(person.getId());
        return personOptional.map(value -> new ResponseEntity<>(value, HttpStatus.BAD_REQUEST))
                .orElseGet(() -> new ResponseEntity<>(repository.save(person), HttpStatus.CREATED));
    }
}
