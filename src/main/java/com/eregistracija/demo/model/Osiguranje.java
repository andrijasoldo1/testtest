package com.eregistracija.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="osiguranja")
public class Osiguranje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite ime osiguravatelja.")
    String imeOsiguravatelja;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite prezime osiguravatelja.")
    String prezimeOsiguravatelja;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite pocetak osiguranja.")
    String pocetakO;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite kraj osiguranja.")
    String krajO;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite vrstu osiguranja.")
    String vrstaO;

    public Osiguranje() {
    }

    public Osiguranje(Long id, String imeOsiguravatelja, String prezimeOsiguravatelja, String pocetakO, String krajO, String vrstaO) {
        this.id = id;
        this.imeOsiguravatelja = imeOsiguravatelja;
        this.prezimeOsiguravatelja = prezimeOsiguravatelja;
        this.pocetakO = pocetakO;
        this.krajO = krajO;
        this.vrstaO = vrstaO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImeOsiguravatelja() {
        return imeOsiguravatelja;
    }

    public void setImeOsiguravatelja(String imeOsiguravatelja) {
        this.imeOsiguravatelja = imeOsiguravatelja;
    }

    public String getPrezimeOsiguravatelja() {
        return prezimeOsiguravatelja;
    }

    public void setPrezimeOsiguravatelja(String prezimeOsiguravatelja) {
        this.prezimeOsiguravatelja = prezimeOsiguravatelja;
    }

    public String getPocetakO() {
        return pocetakO;
    }

    public void setPocetakO(String pocetakO) {
        this.pocetakO = pocetakO;
    }

    public String getKrajO() {
        return krajO;
    }

    public void setKrajO(String krajO) {
        this.krajO = krajO;
    }

    public String getVrstaO() {
        return vrstaO;
    }

    public void setVrstaO(String vrstaO) {
        this.vrstaO = vrstaO;
    }
}