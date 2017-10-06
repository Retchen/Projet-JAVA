package com.cesi.seatingplan.service;

import com.cesi.seatingplan.dao.model.Materiel;
import com.cesi.seatingplan.dao.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@Service
public class MaterielService {
    private final MaterielRepository materielRepository;

    @Autowired
    public MaterielService(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    public Materiel findById(Long id){
        return this.materielRepository.findById(id);
    }

    public Materiel save(Materiel materiel) {
        return this.materielRepository.save(materiel);
    }

    public List<Materiel> findAll() {
        return this.materielRepository.findAll();
    }

    public void delete(Long id) {
        this.materielRepository.delete(id);
    }
}