package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dao.model.Etage;
import com.cesi.seatingplan.service.EtageService;
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
@RequestMapping("/api/etages")
public class EtageController {

    private final EtageService etageService;

    @Autowired
    public EtageController(EtageService etageService) {
        this.etageService = etageService;
    }

    @GetMapping
    public ResponseEntity<List<Etage>> findAll(){
        List<Etage> etages = this.etageService.findAll();
        return new ResponseEntity<>(etages, HttpStatus.OK);
    }

    // /etages/{id}
    @GetMapping("{id}")
    public ResponseEntity<Etage> findById(@PathVariable("id") Long id){
        Etage etage = this.etageService.findById(id);
        return new ResponseEntity<Etage>(etage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Etage> save(@Valid @RequestBody Etage etage){
        Etage etageCreated = this.etageService.save(etage);
        return new ResponseEntity<>(etageCreated, HttpStatus.CREATED);
    }

    // /etages/{id}
    @PutMapping("{id}")
    public ResponseEntity<Etage> update(@Valid @RequestBody Etage newEtage, @PathVariable("id") Long id){

        HttpStatus httpStatus;
        Etage oldEtage = this.etageService.findById(id);

        if (oldEtage != null){
            newEtage.setId(oldEtage.getId());
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Etage etageUpdated = this.etageService.save(newEtage);

        return new ResponseEntity<>(etageUpdated, httpStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        this.etageService.delete(id);
    }

}
