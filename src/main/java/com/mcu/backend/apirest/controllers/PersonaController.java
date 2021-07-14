package com.mcu.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mcu.backend.apirest.models.VinPersonas;
import com.mcu.backend.apirest.repository.PersonasRepository;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping()
public class PersonaController {
    public PersonasRepository personasRepository;

    // Constructor that receives the repository via dependency injection
    public PersonaController(PersonasRepository personasRepository){
        this.personasRepository = personasRepository;
    }

    // Get to /people that returns list of people
    @RequestMapping(value="/personas", method= RequestMethod.GET, headers="Accept= application/json")
    public List<VinPersonas> getAllTutorials() {
        
          List<VinPersonas> persona = new ArrayList<VinPersonas>();

          
         
        
        return personasRepository.findAll();
      }

    // Post to /people, takes in request body which must be of type Person
    @PostMapping("/persona")
    public List<VinPersonas> createPerson(@RequestBody VinPersonas newPerson){
        personasRepository.save(newPerson); //creates new person
        return personasRepository.findAll(); // returns all cats
    }

    // put to /people/:id, takes in the body and url param id
    @PutMapping("/persona/{id}")
    public List<VinPersonas> updatePerson(@RequestBody VinPersonas updatedPerson, @PathVariable Long id){
        // search for the person by id, map over the person, alter them, then save
        personasRepository.findById(id)
            .map(person -> {
                person.setNombrePers(updatedPerson.getNombrePers());
                return personasRepository.save(person); // save and return edits
            });

        return personasRepository.findAll(); // return all people
    }

    // delete request to /people/:id, deletes person based on id param
    @DeleteMapping("/persona/{id}")
    public List<VinPersonas> deleteCat(@PathVariable Long id){
        personasRepository.deleteById(id);
        return personasRepository.findAll();
    }
}