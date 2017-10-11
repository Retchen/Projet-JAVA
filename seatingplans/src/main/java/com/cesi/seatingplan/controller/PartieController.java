package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dao.model.Partie;
import com.cesi.seatingplan.service.PartieService;
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
@RequestMapping("/api/parties")
public class PartieController {

    private final PartieService partieService;

    @Autowired
    public PartieController(PartieService partieService) {
        this.partieService = partieService;
    }

    @GetMapping
    public ResponseEntity<List<Partie>> findAll(){
        List<Partie> parties = this.partieService.findAll();
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }

    // /parties/{id}
    @GetMapping("{id}")
    public ResponseEntity<Partie> findById(@PathVariable("id") Long id){
        Partie partie = this.partieService.findById(id);
        return new ResponseEntity<Partie>(partie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Partie> save(@Valid @RequestBody Partie partie){
        Partie partieCreated = this.partieService.save(partie);
        return new ResponseEntity<>(partieCreated, HttpStatus.CREATED);
    }

    // /parties/{id}
    @PutMapping("{id}")
    public ResponseEntity<Partie> update(@Valid @RequestBody Partie newPartie, @PathVariable("id") Long id){

        HttpStatus httpStatus;
        Partie oldPartie = this.partieService.findById(id);

        if (oldPartie != null){
            newPartie.setId(oldPartie.getId());
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Partie partieUpdated = this.partieService.save(newPartie);

        return new ResponseEntity<>(partieUpdated, httpStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        this.partieService.delete(id);
    }

}
