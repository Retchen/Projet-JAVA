package com.cesi.seatingplan.service;

import com.cesi.seatingplan.dao.model.Plan;
import com.cesi.seatingplan.dao.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@Service
public class PlanService {
    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan findById(Long id){
        return this.planRepository.findById(id);
    }

    public Plan save(Plan plan) {
        return this.planRepository.save(plan);
    }

    public List<Plan> findAll() {
        return this.planRepository.findAll();
    }

    public void delete(Long id) {
        this.planRepository.delete(id);
    }
}