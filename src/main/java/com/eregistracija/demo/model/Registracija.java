package com.eregistracija.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="registracije")
public class Registracija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite ID vaseg vozila.")
    String voziloid;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite ID vozaca.")
    String vozacid;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite imate li zeleni karton.")
    String zeleniKarton;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite ID Vaseg osiguranja.")
    String osiguranjeid;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite Vasu registracijsku oznaku.")
    String registracijskaO;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite ID vase lokacije.")
    String lokid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoziloid() {
        return voziloid;
    }

    public void setVoziloid(String voziloid) {
        this.voziloid = voziloid;
    }

    public String getVozacid() {
        return vozacid;
    }

    public void setVozacid(String vozacid) {
        this.vozacid = vozacid;
    }

    public String getZeleniKarton() {
        return zeleniKarton;
    }

    public void setZeleniKarton(String zeleniKarton) {
        this.zeleniKarton = zeleniKarton;
    }

    public String getOsiguranjeid() {
        return osiguranjeid;
    }

    public void setOsiguranjeid(String osiguranjeid) {
        this.osiguranjeid = osiguranjeid;
    }

    public String getRegistracijskaO() {
        return registracijskaO;
    }

    public void setRegistracijskaO(String registracijskaO) {
        this.registracijskaO = registracijskaO;
    }

    public String getLokid() {
        return lokid;
    }

    public void setLokid(String lokid) {
        this.lokid = lokid;
    }

    public Registracija() {
    }

    public Registracija(Long id, String voziloid, String vozacid, String zeleniKarton, String osiguranjeid, String registracijskaO, String lokid) {
        this.id = id;
        this.voziloid = voziloid;
        this.vozacid = vozacid;
        this.zeleniKarton = zeleniKarton;
        this.osiguranjeid = osiguranjeid;
        this.registracijskaO = registracijskaO;
        this.lokid = lokid;
    }
}