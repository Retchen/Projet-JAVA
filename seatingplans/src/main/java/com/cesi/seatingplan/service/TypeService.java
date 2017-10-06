package com.cesi.seatingplan.service;

import com.cesi.seatingplan.dao.model.Type;
import com.cesi.seatingplan.dao.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eliot on 27/09/2017.
 */
@Service
public class TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type findById(Long id){
        return this.typeRepository.findById(id);
    }

    public Type save(Type type) {
        return this.typeRepository.save(type);
    }

    public List<Type> findAll() {
        return this.typeRepository.findAll();
    }

    public void delete(Long id) {
        this.typeRepository.delete(id);
    }
}
