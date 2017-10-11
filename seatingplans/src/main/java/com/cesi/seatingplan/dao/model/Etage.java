package com.cesi.seatingplan.dao.model;


public class Etage {
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
