package com.cesi.seatingplan.dao.model;

public class Partie {
    private long id;

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

    public String getLibelle() { return libelle; }



    public Partie() {

    }

    public Partie(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}