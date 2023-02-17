package com.eregistracija.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.lang.*;

@Entity
@Table(name="vozila")
public class Vozilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite Vasu registarsku oznaku.")
    String registracijskaO;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite grad registracije.")
    String gradR;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite godinu registracije.")
    String godinaR;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite marku vozila.")
    String markaV;

    @Column(length = 200 , nullable = false)
    @NotBlank(message = "Molimo unesite godinu proizvodnje vozila.")
    String godinaP;


    @Column(length = 200 , nullable = false)
    @NotBlank(message = "Molimo unesite model vozila.")
    String modelV;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite vrstu vozila.")
    String vrstaV;

    @Column(length = 200,nullable = false)
    @NotBlank(message = "Molimo unesite broj sasije.")
    String brojS;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite masu vozila.")
    String masa;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite dopustenu nosivost vozila.")
    String dopustenaN;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite broj mjesta vozila.")
    String brojMjesta;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite obujam motora vozila.")
    String obujamM;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite snagu motora vozila.")
    String snagaM;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite vrstu goriva vozila.")
    String gorivo;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite broj motora vozila.")
    String brojM;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite status katalizatora vozila.")
    String katalizator;

    @Column(length = 200, nullable = false)
    @NotBlank(message = "Molimo unesite boju vozila.")
    String boja;


    public Vozilo() {
    }

    public Vozilo(Long id, String registracijskaO, String gradR, String godinaR, String markaV, String godinaP, String modelV, String vrstaV, String brojS, String masa, String dopustenaN, String brojMjesta, String obujamM, String snagaM, String gorivo, String brojM, String katalizator, String boja) {
        this.id = id;
        this.registracijskaO = registracijskaO;
        this.gradR = gradR;
        this.godinaR = godinaR;
        this.markaV = markaV;
        this.godinaP = godinaP;
        this.modelV = modelV;
        this.vrstaV = vrstaV;
        this.brojS = brojS;
        this.masa = masa;
        this.dopustenaN = dopustenaN;
        this.brojMjesta = brojMjesta;
        this.obujamM = obujamM;
        this.snagaM = snagaM;
        this.gorivo = gorivo;
        this.brojM = brojM;
        this.katalizator = katalizator;
        this.boja = boja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistracijskaO() {
        return registracijskaO;
    }

    public void setRegistracijskaO(String registracijskaO) {
        this.registracijskaO = registracijskaO;
    }

    public String getGradR() {
        return gradR;
    }

    public void setGradR(String gradR) {
        this.gradR = gradR;
    }

    public String getGodinaR() {
        return godinaR;
    }

    public void setGodinaR(String godinaR) {
        this.godinaR = godinaR;
    }

    public String getMarkaV() {
        return markaV;
    }

    public void setMarkaV(String markaV) {
        this.markaV = markaV;
    }

    public String getGodinaP() {
        return godinaP;
    }

    public void setGodinaP(String godinaP) {
        this.godinaP = godinaP;
    }

    public String getModelV() {
        return modelV;
    }

    public void setModelV(String modelV) {
        this.modelV = modelV;
    }

    public String getVrstaV() {
        return vrstaV;
    }

    public void setVrstaV(String vrstaV) {
        this.vrstaV = vrstaV;
    }

    public String getBrojS() {
        return brojS;
    }

    public void setBrojS(String brojS) {
        this.brojS = brojS;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getDopustenaN() {
        return dopustenaN;
    }

    public void setDopustenaN(String dopustenaN) {
        this.dopustenaN = dopustenaN;
    }

    public String getBrojMjesta() {
        return brojMjesta;
    }

    public void setBrojMjesta(String brojMjesta) {
        this.brojMjesta = brojMjesta;
    }

    public String getObujamM() {
        return obujamM;
    }

    public void setObujamM(String obujamM) {
        this.obujamM = obujamM;
    }

    public String getSnagaM() {
        return snagaM;
    }

    public void setSnagaM(String snagaM) {
        this.snagaM = snagaM;
    }

    public String getGorivo() {
        return gorivo;
    }

    public void setGorivo(String gorivo) {
        this.gorivo = gorivo;
    }

    public String getBrojM() {
        return brojM;
    }

    public void setBrojM(String brojM) {
        this.brojM = brojM;
    }

    public String getKatalizator() {
        return katalizator;
    }

    public void setKatalizator(String katalizator) {
        this.katalizator = katalizator;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }
}
