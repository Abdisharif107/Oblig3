package com.example.oblig3;

public class Billett {
    private int id;
    private String film;
    private String antall;
    private String fornavn;
    private String etternavn;
    private String adresse;
    private String mobilnummer;
    private String epost;


    public Billett(String id,String film, String antall, String fornavn, String etternavn, String adresse,
                   String mobilnummer, String epost) {
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.mobilnummer = mobilnummer;
        this.epost = epost;
        this.film = film;

    }
    public Billett(){}

    public int getId() {return id;}
    public void setId(int id) {this.id=id;}

    public String getFilm() {return film;}
    public void setFilm(String film) {this.film = film;}

    public String getAntall() {return antall;}
    public void setAntall(String antall) {this.antall = antall;}

    public String getFornavn() {
        return fornavn;
    }
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {return etternavn;}
    public void setEtternavn(String etternavn) {this.etternavn = etternavn;}

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMobilnummer() {return mobilnummer;}
    public void setMobilnummer(String mobilnummer) {this.mobilnummer = mobilnummer;}

    public String getEpost() {
        return epost;
    }
    public void setEpost(String epost) {
        this.epost = epost;
    }


}

