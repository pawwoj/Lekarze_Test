package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Pacjent extends Osoba {
    private static List<Pacjent> ekstensja = new ArrayList<>();
    private List<Wizyta> wizyty = new ArrayList<>();
    private String id;

    public Pacjent(String id, String imie, String nazwisko, String pesel, LocalDate dataUrodzenia) {
        super(imie, nazwisko, pesel, dataUrodzenia);
        this.id = id;
        ekstensja.add(this);
    }

    public static List<Pacjent> getEkstensja() {
        return ekstensja;
    }

    public List<Wizyta> getWizyty() {
        return wizyty;
    }

    public String getId() {
        return id;
    }

    public static void readFromFile(String fileName) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split("\t");
                new Pacjent(
                        splittedArray[0],
                        splittedArray[2],
                        splittedArray[1],
                        splittedArray[3],
                        LocalDate.parse(splittedArray[4],dtf));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int iloscWizyt(){
        return wizyty.size();
    }

    public static Pacjent getById(String id) {
        return ekstensja.stream().filter(pacjent
                -> pacjent.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacjent pacjent = (Pacjent) o;
        return Objects.equals(getId(), pacjent.getId())
                && Objects.equals(getImie(), pacjent.getImie())
                && Objects.equals(getNazwisko(), pacjent.getNazwisko())
                && Objects.equals(getPesel(), pacjent.getPesel())
                && Objects.equals(getDataUrodzenia(), pacjent.getDataUrodzenia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getImie(),getNazwisko(),getPesel(),getDataUrodzenia());
    }

    @Override
    public String toString() {
        return getId() + " " + getImie() + " " + getNazwisko();
    }
}
