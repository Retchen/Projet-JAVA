package com.cesi.seatingplan.dao.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique = true)
    private String libelle;

    private int version;


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

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() { return version; }


    public Plan() {

    }

    public Plan(String libelle, int version) {
        this.libelle = libelle;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", version=" + version +
                '}';
    }
}
