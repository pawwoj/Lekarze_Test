package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Lekarz extends Osoba {
    private static List<Lekarz> ekstensja = new ArrayList<>();
    private String id;
    private String specjalnosc;
    private String nip;
    private List<Wizyta> wizyty = new ArrayList<>();

    public Lekarz(String id, String nazwisko, String imie, String specjalnosc,
                  LocalDate dataUrodzenia, String nip, String pesel) {
        super(imie, nazwisko, pesel, dataUrodzenia);
        this.id = id;
        this.specjalnosc = specjalnosc;
        this.nip = nip;
        ekstensja.add(this);
    }

    public static List<Lekarz> getEkstensja() {
        return ekstensja;
    }

    public static void readFromFile(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split("\t");
                new Lekarz(
                        splittedArray[0],
                        splittedArray[1],
                        splittedArray[2],
                        splittedArray[3],
                        LocalDate.parse(splittedArray[4]),
                        splittedArray[5],
                        splittedArray[6]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Lekarz getById(String id) {
        return ekstensja.stream().filter(lekarz
                -> lekarz.getId().equals(id)).findFirst().orElseThrow();
    }

    public String getId() {
        return id;
    }

    public String getSpecjalnosc() {
        return specjalnosc;
    }

    public String getNip() {
        return nip;
    }

    public List<Wizyta> getWizyty() {
        return wizyty;
    }

    public List<Integer> miesiaceWizytLekarzaZDanegoRoku(int rok){
        return this.getWizyty().stream().filter(wizyta -> wizyta.getDataWizyty().getYear() == rok)
                .map(wizyta -> wizyta.getDataWizyty().getMonthValue()).toList();
    }

    public List<Wizyta> wizytyLekarzaOdDatyDoDaty(LocalDate odDaty, LocalDate doDaty) {
        int wlacznieZDanymDniem = 1;
        return wizyty.stream()
                .filter(wizyta -> (wizyta.getDataWizyty().isAfter(odDaty.minusDays(wlacznieZDanymDniem))
                        && wizyta.getDataWizyty().isBefore(doDaty.plusDays(wlacznieZDanymDniem)))).toList();
    }

    public int iloscWizyt(){
        return wizyty.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lekarz lekarz = (Lekarz) o;
        return Objects.equals(specjalnosc, lekarz.specjalnosc)
                && Objects.equals(nip, lekarz.nip)
                && Objects.equals(getId(), lekarz.getId())
                && Objects.equals(getImie(), lekarz.getImie())
                && Objects.equals(getNazwisko(), lekarz.getNazwisko())
                && Objects.equals(getPesel(), lekarz.getPesel())
                && Objects.equals(getDataUrodzenia(), lekarz.getDataUrodzenia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(specjalnosc, nip, getId(),getImie(),getNazwisko(),getPesel(),getDataUrodzenia());
    }

    @Override
    public String toString() {
        return getId() + " " +  getImie() + " " + getNazwisko() + " " + specjalnosc;
    }

}
