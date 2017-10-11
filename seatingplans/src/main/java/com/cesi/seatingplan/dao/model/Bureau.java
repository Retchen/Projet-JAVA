package com.cesi.seatingplan.dao.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bureau {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<Materiel> listMateriel;

    private int num_interne;

    private int num_externe;

    private int abs;

    private int ord;

    private boolean sens;

    @OneToOne
    private Collaborateur collaborateur;

    @OneToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Materiel> getListMateriel() {
        return listMateriel;
    }

    public void setListMateriel(List<Materiel> listMateriel) {
        this.listMateriel = listMateriel;
    }

    public int getNum_interne() {
        return num_interne;
    }

    public void setNum_interne(int num_interne) {
        this.num_interne = num_interne;
    }

    public int getNum_externe() {
        return num_externe;
    }

    public void setNum_externe(int num_externe) {
        this.num_externe = num_externe;
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public boolean isSens() {
        return sens;
    }

    public void setSens(boolean sens) {
        this.sens = sens;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }


    public Bureau() {
    }

    public Bureau(List<Materiel> listMateriel, int num_interne, int num_externe, int abs, int ord, boolean sens,
        Collaborateur collaborateur, Plan plan) {
        this.listMateriel = listMateriel;
        this.num_interne = num_interne;
        this.num_externe = num_externe;
        this.abs = abs;
        this.ord = ord;
        this.sens = sens;
        this.collaborateur = collaborateur;
        this.plan = plan;
    }
}