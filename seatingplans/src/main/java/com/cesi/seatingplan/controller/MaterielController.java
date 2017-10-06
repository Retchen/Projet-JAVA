package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dao.model.Materiel;
import com.cesi.seatingplan.service.MaterielService;
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
@RequestMapping("/api/materiels")
public class MaterielController {

    private final MaterielService materielService;

    @Autowired
    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @GetMapping
    public ResponseEntity<List<Materiel>> findAll(){
        List<Materiel> materiels = this.materielService.findAll();
        return new ResponseEntity<>(materiels, HttpStatus.OK);
    }

    // /materiels/{id}
    @GetMapping("{id}")
    public ResponseEntity<Materiel> findById(@PathVariable("id") Long id){
        Materiel materiel = this.materielService.findById(id);
        return new ResponseEntity<Materiel>(materiel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Materiel> save(@Valid @RequestBody Materiel materiel){
        Materiel materielCreated = this.materielService.save(materiel);
        return new ResponseEntity<>(materielCreated, HttpStatus.CREATED);
    }

    // /materiels/{id}
    @PutMapping("{id}")
    public ResponseEntity<Materiel> update(@Valid @RequestBody Materiel newMateriel, @PathVariable("id") Long id){

        HttpStatus httpStatus;
        Materiel oldMateriel = this.materielService.findById(id);

        if (oldMateriel != null){
            newMateriel.setId(oldMateriel.getId());
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Materiel materielUpdated = this.materielService.save(newMateriel);

        return new ResponseEntity<>(materielUpdated, httpStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        this.materielService.delete(id);
    }

}
