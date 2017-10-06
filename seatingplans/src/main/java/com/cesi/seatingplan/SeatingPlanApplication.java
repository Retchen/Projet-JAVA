package com.cesi.seatingplan;

import com.cesi.seatingplan.dao.model.Batiment;
import com.cesi.seatingplan.dao.model.Materiel;
import com.cesi.seatingplan.dao.model.Type;
import com.cesi.seatingplan.dao.repository.BatimentRepository;
import com.cesi.seatingplan.dao.repository.TypeRepository;
import com.cesi.seatingplan.dao.repository.MaterielRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SeatingPlanApplication implements CommandLineRunner {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    BatimentRepository batimentRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    MaterielRepository materielRepository;

    public static void main(String[] args) {
        SpringApplication.run(SeatingPlanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        LOG.info("Construction table BATIMENT");
        List<Batiment> batiments = new ArrayList<>();
        batiments.add(new Batiment("Batiment A"));
        batiments.add(new Batiment("Batiment B"));
        batimentRepository.save(batiments);
        LOG.info("FIN == Construction table BATIMENT");


        LOG.info("Construction table TYPE");
        List<Type> types = new ArrayList<>();
        types.add(new Type("Bureau"));
        types.add(new Type("Chaise"));
        typeRepository.save(types);
        LOG.info("FIN == Construction table TYPE");

        LOG.info("Construction table MATERIEL");
        List<Materiel> materiels = new ArrayList<>();
        materiels.add(new Materiel("Materiel 1"));
        materiels.add(new Materiel("Materiel 2"));
        materielRepository.save(materiels);
        LOG.info("FIN == Construction table MATERIEL");




    }
}