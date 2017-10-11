package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dao.model.Collaborateur;
import com.cesi.seatingplan.service.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

    private final CollaborateurService collaborateurService;

    @Autowired
    public CollaborateurController(CollaborateurService collaborateurService) {
        this.collaborateurService = collaborateurService;
    }

    @GetMapping
    public ResponseEntity<List<Collaborateur>> findAll(){
        List<Collaborateur> collaborateurs = this.collaborateurService.findAll();
        return new ResponseEntity<>(collaborateurs, HttpStatus.OK);
    }

    // /collaborateurs/{id}
    @GetMapping("{id}")
    public ResponseEntity<Collaborateur> findById(@PathVariable("id") Long id){
        Collaborateur collaborateur = this.collaborateurService.findById(id);
        return new ResponseEntity<Collaborateur>(collaborateur, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Collaborateur> save(@Valid @RequestBody Collaborateur collaborateur){
        Collaborateur collaborateurCreated = this.collaborateurService.save(collaborateur);
        return new ResponseEntity<>(collaborateurCreated, HttpStatus.CREATED);
    }

    // /collaborateurs/{id}
    @PutMapping("{id}")
    public ResponseEntity<Collaborateur> update(@Valid @RequestBody Collaborateur newCollaborateur, @PathVariable("id") Long id){

        HttpStatus httpStatus;
        Collaborateur oldCollaborateur = this.collaborateurService.findById(id);

        if (oldCollaborateur != null){
            newCollaborateur.setId(oldCollaborateur.getId());
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Collaborateur collaborateurUpdated = this.collaborateurService.save(newCollaborateur);

        return new ResponseEntity<>(collaborateurUpdated, httpStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        this.collaborateurService.delete(id);
    }

}
