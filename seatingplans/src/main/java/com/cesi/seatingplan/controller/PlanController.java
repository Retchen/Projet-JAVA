package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.dao.model.Plan;
import com.cesi.seatingplan.service.PlanService;
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
@RequestMapping("/api/plans")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public ResponseEntity<List<Plan>> findAll(){
        List<Plan> plans = this.planService.findAll();
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

    // /parties/{id}
    @GetMapping("{id}")
    public ResponseEntity<Plan> findById(@PathVariable("id") Long id){
        Plan plan = this.planService.findById(id);
        return new ResponseEntity<Plan>(plan, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Plan> save(@Valid @RequestBody Plan plan){
        Plan planCreated = this.planService.save(plan);
        return new ResponseEntity<>(planCreated, HttpStatus.CREATED);
    }

    // /parties/{id}
    @PutMapping("{id}")
    public ResponseEntity<Plan> update(@Valid @RequestBody Plan newPlan, @PathVariable("id") Long id){

        HttpStatus httpStatus;
        Plan oldPlan = this.planService.findById(id);

        if (oldPlan != null){
            newPlan.setId(oldPlan.getId());
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Plan planUpdated = this.planService.save(newPlan);

        return new ResponseEntity<>(planUpdated, httpStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        this.planService.delete(id);
    }

}

