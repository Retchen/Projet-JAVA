package com.cesi.seatingplan.dao.repository;

import com.cesi.seatingplan.dao.model.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by eliot on 27/09/2017.
 */
@Repository
public interface BatimentRepository extends JpaRepository<Batiment, Long> {
    Batiment findById(Long id);
}