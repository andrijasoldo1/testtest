package com.eregistracija.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="lokacije")
public class Lokacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite ime lokacije.")
    String loki;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite adresu lokacije.")
    String adresa;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite termin registracije.")
    String termin;

    public Lokacija() {
    }

    public Lokacija(Long id, String loki, String adresa, String termin) {
        this.id = id;
        this.loki = loki;
        this.adresa = adresa;
        this.termin = termin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoki() {
        return loki;
    }

    public void setLoki(String loki) {
        this.loki = loki;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }
}

