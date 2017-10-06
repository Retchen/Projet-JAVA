package com.cesi.seatingplan.service;

import com.cesi.seatingplan.dao.model.Batiment;
import com.cesi.seatingplan.dao.repository.BatimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@Service
public class BatimentService {
    private final BatimentRepository batimentRepository;

    @Autowired
    public BatimentService(BatimentRepository batimentRepository) {
        this.batimentRepository = batimentRepository;
    }

    public Batiment findById(Long id){
        return this.batimentRepository.findById(id);
    }

    public Batiment save(Batiment batiment) {
        return this.batimentRepository.save(batiment);
    }

    public List<Batiment> findAll() {
        return this.batimentRepository.findAll();
    }

    public void delete(Long id) {
        this.batimentRepository.delete(id);
    }
}