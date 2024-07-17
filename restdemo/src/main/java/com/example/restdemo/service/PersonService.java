package com.example.restdemo.service;

import com.example.restdemo.dto.Message;
import com.example.restdemo.dto.Person;
import com.example.restdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public ResponseEntity<Person> addMessageToPerson(int personId, Message message) {
        Optional<Person> personOptional = repository.findById(personId);
        if(personOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personOptional.get();
        message.setPerson(person);
        message.setTime(LocalDateTime.now());
        person.addMessage(message);
        return new ResponseEntity<>(repository.save(person), HttpStatus.OK);
    }

    public void deleteMessageFromPerson(int personId, int messageId) {
        Optional<Person> personOptional = repository.findById(personId);
        if(personOptional.isPresent()) {
            Person person = personOptional.get();
            person.getMessages().removeIf(m -> m.getId() == messageId);
            repository.save(person);
        }
    }

    public ResponseEntity<Iterable<Message>> getMessagesByPersonId(int personId) {
        Optional<Person> personOptional = repository.findById(personId);
        if(personOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personOptional.get();
        return new ResponseEntity<>(person.getMessages(), HttpStatus.OK);
    }

    public ResponseEntity<Optional<Message>> getMessageByPersonIdAndMessageId(int personId, int messageId) {
        Optional<Person> personOptional = repository.findById(personId);
        if(personOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person person = personOptional.get();
        Optional<Message> message = person.getMessages().stream().filter(m -> m.getId() == messageId).findFirst();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
