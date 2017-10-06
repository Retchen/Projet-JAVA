package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dao.model.Type;
import com.cesi.seatingplan.service.TypeService;
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
@RequestMapping("/api/types")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public ResponseEntity<List<Type>> findAll(){
        List<Type> types = this.typeService.findAll();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    // /types/{id}
    @GetMapping("{id}")
    public ResponseEntity<Type> findById(@PathVariable("id") Long id){
        Type type = this.typeService.findById(id);
        return new ResponseEntity<Type>(type, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Type> save(@Valid @RequestBody Type type){
        Type typeCreated = this.typeService.save(type);
        return new ResponseEntity<>(typeCreated, HttpStatus.CREATED);
    }

    // /types/{id}
    @PutMapping("{id}")
    public ResponseEntity<Type> update(@Valid @RequestBody Type newType, @PathVariable("id") Long id){

        HttpStatus httpStatus;
        Type oldType = this.typeService.findById(id);

        if (oldType != null){
            newType.setId(oldType.getId());
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Type typeUpdated = this.typeService.save(newType);

        return new ResponseEntity<>(typeUpdated, httpStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        this.typeService.delete(id);
    }

}
