package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    //Create operation
    public Person create(String firstName, String lastName, int age)
    {
        return personRepository.save(new Person(firstName, lastName, age));
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getByFirstName(String firstName){
        return personRepository.findByFirstName(firstName);
    }

    public Person update(String firstName, String lastName, int age){
        Person p = personRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        return personRepository.save(p);
    }

    //Delete operation
    public void deleteAll(){
        personRepository.deleteAll();
    }

    public void delete(String firstName){
        personRepository.delete(personRepository.findByFirstName(firstName));
    }


}
