package com.cesi.seatingplan.service;

import com.cesi.seatingplan.dao.model.Partie;
import com.cesi.seatingplan.dao.repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@Service
public class PartieService {
    private final PartieRepository partieRepository;

    @Autowired
    public PartieService(PartieRepository partieRepository) {
        this.partieRepository = partieRepository;
    }

    public Partie findById(Long id){
        return this.partieRepository.findById(id);
    }

    public Partie save(Partie partie) {
        return this.partieRepository.save(partie);
    }

    public List<Partie> findAll() {
        return this.partieRepository.findAll();
    }

    public void delete(Long id) {
        this.partieRepository.delete(id);
    }
}