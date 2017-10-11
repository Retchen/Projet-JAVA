package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dao.model.Bureau;
import com.cesi.seatingplan.service.BureauService;
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
@RequestMapping("/api/bureaux")
public class BureauController {

    private final BureauService bureauService;

    @Autowired
    public BureauController(BureauService bureauService) {
        this.bureauService = bureauService;
    }

    @GetMapping
    public ResponseEntity<List<Bureau>> findAll(){
        List<Bureau> bureaux = this.bureauService.findAll();
        return new ResponseEntity<>(bureaux, HttpStatus.OK);
    }

    // /bureaux/{id}
    @GetMapping("{id}")
    public ResponseEntity<Bureau> findById(@PathVariable("id") Long id){
        Bureau bureau = this.bureauService.findById(id);
        return new ResponseEntity<Bureau>(bureau, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bureau> save(@Valid @RequestBody Bureau bureau){
        Bureau bureauCreated = this.bureauService.save(bureau);
        return new ResponseEntity<>(bureauCreated, HttpStatus.CREATED);
    }

    // /bureaux/{id}
    @PutMapping("{id}")
    public ResponseEntity<Bureau> update(@Valid @RequestBody Bureau newBureau, @PathVariable("id") Long id){

        HttpStatus httpStatus;
        Bureau oldBureau = this.bureauService.findById(id);

        if (oldBureau != null){
            newBureau.setId(oldBureau.getId());
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Bureau bureauUpdated = this.bureauService.save(newBureau);

        return new ResponseEntity<>(bureauUpdated, httpStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        this.bureauService.delete(id);
    }

}