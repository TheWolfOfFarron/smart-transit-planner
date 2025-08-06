package Database;


import jakarta.persistence.*;

import java.util.Objects;

@Entity

@Table(name="Utilizator")
@NamedNativeQueries(
        {
                @NamedNativeQuery(name="findB",query = "Select * from utilizator c where id = :id",resultClass = Utilizator.class),
                @NamedNativeQuery(name="findALLU",query = "Select * from utilizator c ",resultClass = Utilizator.class),
                @NamedNativeQuery(name = "findUserAndPass", query = "Select * from utilizator c where username = :username and parola = :parola",resultClass = Utilizator.class)
        })


public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;
    private String prenume;
    private String tip;
    private String mail;
    private String username;
    private String numarTelefon;
    private String parola;
    private String cnp;

    public Utilizator() {
    }

    public Utilizator(String nume, String prenume, String tip, String mail, String username, String numarTelefon, String parola, String cnp) {
        this.nume = nume;
        this.prenume = prenume;
        this.tip = tip;
        this.mail = mail;
        this.username = username;
        this.numarTelefon = numarTelefon;
        this.parola = parola;
        this.cnp = cnp;
    }

    public Utilizator(int id, String nume, String prenume, String tip, String mail, String username, String numarTelefon, String parola, String cnp) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.tip = tip;
        this.mail = mail;
        this.username = username;
        this.numarTelefon = numarTelefon;
        this.parola = parola;
        this.cnp = cnp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", tip='" + tip + '\'' +
                ", mail='" + mail + '\'' +
                ", username='" + username + '\'' +
                ", numarTelefon='" + numarTelefon + '\'' +
                ", parola='" + parola + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizator that = (Utilizator) o;
        return id == that.id && Objects.equals(nume, that.nume) && Objects.equals(prenume, that.prenume) && Objects.equals(tip, that.tip) && Objects.equals(mail, that.mail) && Objects.equals(username, that.username) && Objects.equals(numarTelefon, that.numarTelefon) && Objects.equals(parola, that.parola) && Objects.equals(cnp, that.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, prenume, tip, mail, username, numarTelefon, parola, cnp);
    }
}
