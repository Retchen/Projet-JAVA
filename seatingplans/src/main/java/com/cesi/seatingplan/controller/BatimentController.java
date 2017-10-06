package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dao.model.Batiment;
import com.cesi.seatingplan.service.BatimentService;
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
@RequestMapping("/api/batiments")
public class BatimentController {

    private final BatimentService batimentService;

    @Autowired
    public BatimentController(BatimentService batimentService) {
        this.batimentService = batimentService;
    }

    @GetMapping
    public ResponseEntity<List<Batiment>> findAll(){
        List<Batiment> batiments = this.batimentService.findAll();
        return new ResponseEntity<>(batiments, HttpStatus.OK);
    }

    // /batiments/{id}
    @GetMapping("{id}")
    public ResponseEntity<Batiment> findById(@PathVariable("id") Long id){
        Batiment batiment = this.batimentService.findById(id);
        return new ResponseEntity<Batiment>(batiment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Batiment> save(@Valid @RequestBody Batiment batiment){
        Batiment batimentCreated = this.batimentService.save(batiment);
        return new ResponseEntity<>(batimentCreated, HttpStatus.CREATED);
    }

    // /batiments/{id}
    @PutMapping("{id}")
    public ResponseEntity<Batiment> update(@Valid @RequestBody Batiment newBatiment, @PathVariable("id") Long id){

        HttpStatus httpStatus;
        Batiment oldBatiment = this.batimentService.findById(id);

        if (oldBatiment != null){
            newBatiment.setId(oldBatiment.getId());
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Batiment batimentUpdated = this.batimentService.save(newBatiment);

        return new ResponseEntity<>(batimentUpdated, httpStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        this.batimentService.delete(id);
    }

}
