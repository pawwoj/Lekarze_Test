package model;

import java.time.LocalDate;

public abstract class Osoba {
    private String imie;
    private String nazwisko;
    private String pesel;
    private LocalDate dataUrodzenia;

    public Osoba(String imie, String nazwisko, String pesel, LocalDate dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }
}
