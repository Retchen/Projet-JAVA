package com.cesi.seatingplan.service;

import com.cesi.seatingplan.dao.model.Bureau;
import com.cesi.seatingplan.dao.repository.BureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@Service
public class BureauService {
    private final BureauRepository bureauRepository;

    @Autowired
    public BureauService(BureauRepository bureauRepository) {
        this.bureauRepository = bureauRepository;
    }

    public Bureau findById(Long id){
        return this.bureauRepository.findById(id);
    }

    public Bureau save(Bureau bureau) {
        return this.bureauRepository.save(bureau);
    }

    public List<Bureau> findAll() {
        return this.bureauRepository.findAll();
    }

    public void delete(Long id) {
        this.bureauRepository.delete(id);
    }
}