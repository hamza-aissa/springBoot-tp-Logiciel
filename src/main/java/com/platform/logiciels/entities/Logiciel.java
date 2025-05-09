package com.platform.logiciels.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Logiciel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogiciel;
    @NotNull
    @Size (min = 4,max = 15)
    private String nomLogiciel;
    private String versionLogiciel;
    @Min(value = 10)
    @Max(value = 10000)
    private Float prixLogiciel;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "La date de publication doit être dans le passé ou aujourd'hui")
    private Date datePublicationLogiciel;

    @ManyToOne
    private Devloppeur devloppeur;
    public Logiciel() {
        super();
    }
    public Logiciel(String nomLogiciel, String versionLogiciel, Float prixLogiciel, Date datePublicationLogiciel) {
        super();
        this.nomLogiciel = nomLogiciel;
        this.versionLogiciel = versionLogiciel;
        this.prixLogiciel = prixLogiciel;
        this.datePublicationLogiciel = datePublicationLogiciel;
    }

    public Long getIdLogiciel() {
        return idLogiciel;
    }

    public String getNomLogiciel() {
        return nomLogiciel;
    }

    public String getVersionLogiciel() {
        return versionLogiciel;
    }

    public Float getPrixLogiciel() {
        return prixLogiciel;
    }

    public void setIdLogiciel(Long idLogiciel) {
        this.idLogiciel = idLogiciel;
    }

    public void setNomLogiciel(String nomLogiciel) {
        this.nomLogiciel = nomLogiciel;
    }

    public void setVersionLogiciel(String versionLogiciel) {
        this.versionLogiciel = versionLogiciel;
    }

    public void setPrixLogiciel(Float prixLogiciel) {
        this.prixLogiciel = prixLogiciel;
    }

    public void setDatePublicationLogiciel(Date datePublicationLogiciel) {
        this.datePublicationLogiciel = datePublicationLogiciel;
    }

    public void setDevloppeur(Devloppeur devloppeur) {
        this.devloppeur = devloppeur;
    }

    public Date getDatePublicationLogiciel() {
        return datePublicationLogiciel;
    }

    public Devloppeur getDevloppeur() {
        return devloppeur;
    }
    @Override
    public String toString() {
        return "Logiciel{" +
                "idLogiciel=" + idLogiciel +
                ", nomLogiciel='" + nomLogiciel + '\'' +
                ", versionLogiciel='" + versionLogiciel + '\'' +
                ", prixLogiciel=" + prixLogiciel +
                ", datePublicationLogiciel=" + datePublicationLogiciel +
                ", devloppeur=" + devloppeur +
                '}';
    }

}
