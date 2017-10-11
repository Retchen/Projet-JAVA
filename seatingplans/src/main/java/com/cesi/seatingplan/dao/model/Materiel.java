package com.cesi.seatingplan.dao.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique = true)
    private String libelle;

    private long id_type;
    private Type type_materiel;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public long getId_type() {
        return id_type;
    }

    public void setId_type(long id_type) {
        this.id_type = id_type;
    }

    public Type getType_materiel() {
        return type_materiel;
    }

    public void setType_materiel(Type type_materiel) {
        this.type_materiel = type_materiel;
    }


    public Materiel() {

    }

    public Materiel(String libelle) {
        this.libelle = libelle;
    }
}
