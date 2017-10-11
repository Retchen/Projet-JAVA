package com.cesi.seatingplan.service;

import com.cesi.seatingplan.dao.model.Etage;
import com.cesi.seatingplan.dao.repository.EtageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@Service
public class EtageService {
    private final EtageRepository etageRepository;

    @Autowired
    public EtageService(EtageRepository etageRepository) {
        this.etageRepository = etageRepository;
    }

    public Etage findById(Long id){
        return this.etageRepository.findById(id);
    }

    public Etage save(Etage etage) {
        return this.etageRepository.save(etage);
    }

    public List<Etage> findAll() {
        return this.etageRepository.findAll();
    }

    public void delete(Long id) {
        this.etageRepository.delete(id);
    }
}
