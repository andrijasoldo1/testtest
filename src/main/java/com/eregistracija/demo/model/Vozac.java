package com.eregistracija.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="vozaci")
public class Vozac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite Vase ime.")
    String ime;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite Vase prezime.")
    String prezime;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite Vasu adresu.")
    String adresa;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite Vas grad.")
    String grad;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite Vas JMBG.")
    String JMBG;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite Vas status.")
    String status;

    public Vozac() {
    }

    public Vozac(Long id, String ime, String prezime, String adresa, String grad, String JMBG, String status) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.JMBG = JMBG;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
