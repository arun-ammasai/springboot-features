package com.bcv.app.controller;

import com.bcv.app.data.LoadData;
import com.bcv.app.entity.Person;
import com.bcv.app.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SpringJdbcController {
    @Autowired
    PersonRepository repository;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoadData.class);

    @GetMapping("/allpersons")
    public List<Person> fetchAll() {
        List<Person> persons = new ArrayList<>();
        repository.findAll().forEach(per -> {
            persons.add(per);
        });
        return persons;
    }

    @GetMapping("user/{id}")
    public Person getPerson(@PathVariable(name = "id") long id) throws Exception{
        Optional<Person> byId = repository.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        }else{
            throw new Exception("Person Not Found !!!");
        }
    }

    @PutMapping("/update-user/{id}/{name}")
    public Person updatePerson(@PathVariable(name = "id") long id,@PathVariable(name = "name") String name) throws Exception{
        Optional<Person> byId = repository.findById(id);
        if(byId.isPresent()) {
            Person person = byId.get();
            person.setFirstName(name);
            repository.save(person);
            return person;
        }else{
            throw new Exception("Person Not Found !!!");
        }
    }

    @DeleteMapping("delete-person/{id}")
    public String deletePerson(@PathVariable(name = "id") long id) throws Exception{
        Optional<Person> byId = repository.findById(id);
        if(byId.isPresent()) {
            repository.delete(byId.get());
            return "Person Deleted Successfully !!!!";
        }else{
            throw new Exception("Person Not Found !!!");
        }
    }
}

