package com.cesi.seatingplan.dao.repository;

import com.cesi.seatingplan.dao.model.Partie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.stream.Stream;

/**
 * Created by eliot on 27/09/2017.
 */
@Repository
public interface PartieRepository extends JpaRepository<Partie, Long> {
    Partie findById(Long id);
}