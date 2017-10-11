package com.cesi.seatingplan.service;

import com.cesi.seatingplan.dao.model.Collaborateur;
import com.cesi.seatingplan.dao.repository.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@Service
public class CollaborateurService {
    private final CollaborateurRepository collaborateurRepository;

    @Autowired
    public CollaborateurService(CollaborateurRepository collaborateurRepository) {
        this.collaborateurRepository = collaborateurRepository;
    }

    public Collaborateur findById(Long id){
        return this.collaborateurRepository.findById(id);
    }

    public Collaborateur save(Collaborateur batiment) {
        return this.collaborateurRepository.save(batiment);
    }

    public List<Collaborateur> findAll() {
        return this.collaborateurRepository.findAll();
    }

    public void delete(Long id) {
        this.collaborateurRepository.delete(id);
    }
}

