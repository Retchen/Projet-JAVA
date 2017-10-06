package com.cesi.seatingplan.dao.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Type {

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Type() {

    }

    public Type(String libelle) {
        this.libelle = libelle;
    }
}
