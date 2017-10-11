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

        LOG.info("Mock des tables sans dépendances");

        LOG.info("Construction table TYPE");
        List<Type> types = new ArrayList<>();
        types.add(new Type("Bureau"));
        types.add(new Type("Chaise"));
        types.add(new Type("Open space"));
        typeRepository.save(types);
        LOG.info("FIN == Construction table TYPE");

        LOG.info("Construction table PARTIE");
        List<Partie> parties = new ArrayList<>();
        parties.add(new Partie("Partie 1"));
        parties.add(new Partie("Partie 2"));
        partieRepository.save(parties);
        LOG.info("FIN == Construction table PARTIE");

        LOG.info("Construction table ETAGE");
        List<Etage> etages = new ArrayList<>();
        etages.add(new Etage("Etage 1"));
        etages.add(new Etage("Etage 2"));
        etageRepository.save(etages);
        LOG.info("FIN == Construction table ETAGE");

        LOG.info("Construction table COLLABORATEUR");
        List<Collaborateur> collaborateurs = new ArrayList<>();
        collaborateurs.add(new Collaborateur("Collaborateur 1"));
        collaborateurs.add(new Collaborateur("Collaborateur 2"));
        collaborateurRepository.save(collaborateurs);
        LOG.info("FIN == Construction table COLLABORATEUR");


        LOG.info("Mock des tables avec dépendances");


        LOG.info("Construction table BATIMENT");
        List<Batiment> batiments = new ArrayList<>();
        batiments.add(new Batiment("Batiment A", 1L, typeRepository.findById(3L)));
        batiments.add(new Batiment("Batiment B", 2L, typeRepository.findById(3L)));
        batimentRepository.save(batiments);
        LOG.info("FIN == Construction table BATIMENT");

        LOG.info("Construction table MATERIEL");
        List<Materiel> materiels = new ArrayList<>();
        materiels.add(new Materiel("Materiel 1", typeRepository.findById(1L)));
        materiels.add(new Materiel("Materiel 2", typeRepository.findById(2L)));
        materielRepository.save(materiels);
        LOG.info("FIN == Construction table MATERIEL");

        LOG.info("Construction table PLAN");
        List<Plan> plans = new ArrayList<>();
        plans.add(new Plan("Plan 1", 1));
        plans.add(new Plan("Plan 2", 1));
        planRepository.save(plans);
        LOG.info("FIN == Construction table PLAN");

        LOG.info("Construction table BUREAU");
        List<Bureau> bureaux = new ArrayList<>();
        List<Materiel> mockMateriels = new ArrayList<>();
        mockMateriels.add(materielRepository.findById(1L));
        bureaux.add(new Bureau(mockMateriels, 1, 1, 10, 20, true,
            collaborateurRepository.findById(1L),planRepository.findById(1L)));
        mockMateriels = new ArrayList<>();
        mockMateriels.add(materielRepository.findById(2L));
        bureaux.add(new Bureau(mockMateriels, 2, 2, 40, 25, false,
            collaborateurRepository.findById(2L),planRepository.findById(2L)));
        bureauRepository.save(bureaux);
        LOG.info("FIN == Construction table BUREAU");


    }
}