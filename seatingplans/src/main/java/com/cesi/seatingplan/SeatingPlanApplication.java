package com.cesi.seatingplan;

import com.cesi.seatingplan.dao.model.*;
import com.cesi.seatingplan.dao.repository.*;
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

    @Autowired
    PartieRepository partieRepository;

    @Autowired
    CollaborateurRepository collaborateurRepository;

    @Autowired
    EtageRepository etageRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    BureauRepository bureauRepository;

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
        materiels.add(new Materiel("Materiel 1", 1));
        materiels.add(new Materiel("Materiel 2", 2));
        materielRepository.save(materiels);
        LOG.info("FIN == Construction table MATERIEL");

        LOG.info("Construction table PARTIE");
        List<Partie> parties = new ArrayList<>();
        parties.add(new Partie("Partie 1"));
        parties.add(new Partie("Partie 2"));
        partieRepository.save(parties);
        LOG.info("FIN == Construction table MATERIEL");

        LOG.info("Construction table COLLABORATEUR");
        List<Collaborateur> collaborateurs = new ArrayList<>();
        collaborateurs.add(new Collaborateur("Collaborateur 1"));
        collaborateurs.add(new Collaborateur("Collaborateur 2"));
        collaborateurRepository.save(collaborateurs);
        LOG.info("FIN == Construction table COLLABORATEUR");

        LOG.info("Construction table ETAGE");
        List<Etage> etages = new ArrayList<>();
        etages.add(new Etage("Etage 1"));
        etages.add(new Etage("Etage 2"));
        etageRepository.save(etages);
        LOG.info("FIN == Construction table ETAGE");

        LOG.info("Construction table PLAN");
        List<Plan> plans = new ArrayList<>();
        plans.add(new Plan("Plan 1"));
        plans.add(new Plan("Plan 2"));
        planRepository.save(plans);
        LOG.info("FIN == Construction table PLAN");

        LOG.info("Construction table BUREAU");
        List<Bureau> bureaux = new ArrayList<>();
        bureaux.add(new Bureau(1));
        bureaux.add(new Bureau(2));
        bureauRepository.save(bureaux);
        LOG.info("FIN == Construction table BUREAU");



    }
}