package ch.collen.registryservice;

import org.springframework.classify.annotation.Classifier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by cyril on 13/09/17.
 */
@Entity
public class Caisse {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String nom;

    @Column
    private String numeroTelephone;

    protected Caisse() { /* Thx JPA */ }

    public Caisse(String nom, String numeroTelephone) {
        this.nom = nom;
        this.numeroTelephone = numeroTelephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    @Override
    public String toString() {
        return "Caisse{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                '}';
    }
}
