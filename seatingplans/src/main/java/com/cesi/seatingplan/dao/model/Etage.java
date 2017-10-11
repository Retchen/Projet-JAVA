package com.cesi.seatingplan.dao.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Etage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique = true)
    private String libelle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() { return libelle;    }



    public Etage() {

    }

    public Etage(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Etage{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
