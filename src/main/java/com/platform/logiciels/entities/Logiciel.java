package com.platform.logiciels.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Logiciel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idLogiciel;
    private String nomLogiciel;
    private String versionLogiciel;
    private Float prixLogiciel;
    private Date datePublicationLogiciel;
    private String devloppeurLogiciel;
    public Logiciel() {
        super();
    }

    public Logiciel(String nomLogiciel, String versionLogiciel, Float prixLogiciel, Date datePublicationLogiciel, String devloppeurLogiciel) {
        super();
        this.nomLogiciel = nomLogiciel;
        this.versionLogiciel = versionLogiciel;
        this.prixLogiciel = prixLogiciel;
        this.datePublicationLogiciel = datePublicationLogiciel;
        this.devloppeurLogiciel = devloppeurLogiciel;
    }





    public Long getIdLogiciel() {
        return idLogiciel;
    }

    public void setIdLogiciel(Long idLogiciel) {
        this.idLogiciel = idLogiciel;
    }

    public String getNomLogiciel() {
        return nomLogiciel;
    }

    public void setNomLogiciel(String nomLogiciel) {
        this.nomLogiciel = nomLogiciel;
    }

    public String getVersionLogiciel() {
        return versionLogiciel;
    }

    public void setVersionLogiciel(String versionLogiciel) {
        this.versionLogiciel = versionLogiciel;
    }

    public Float getPrixLogiciel() {
        return prixLogiciel;
    }

    public void setPrixLogiciel(Float prixLogiciel) {
        this.prixLogiciel = prixLogiciel;
    }

    public Date getDatePublicationLogiciel() {
        return datePublicationLogiciel;
    }

    public void setDatePublicationLogiciel(Date datePublicationLogiciel) {
        this.datePublicationLogiciel = datePublicationLogiciel;
    }

    public String getDevloppeurLogiciel() {
        return devloppeurLogiciel;
    }

    public void setDevloppeurLogiciel(String devloppeurLogiciel) {
        this.devloppeurLogiciel = devloppeurLogiciel;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
