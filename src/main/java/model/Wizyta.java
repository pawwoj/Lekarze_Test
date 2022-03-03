package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wizyta {
    private static List<Wizyta> ekstensja = new ArrayList<>();
    private Lekarz lekarz;
    private Pacjent pacjent;
    private LocalDate dataWizyty;

    public Wizyta(Lekarz lekarz, Pacjent pacjent, LocalDate dataWizyty) {
        if (lekarz == null) {
            throw new IllegalArgumentException("Lekarz is null");
        }
        if (pacjent == null) {
            throw new IllegalArgumentException("Pacjent is null");
        }
        this.lekarz = lekarz;
        this.pacjent = pacjent;
        this.dataWizyty = dataWizyty;

        lekarz.getWizyty().add(this);
        pacjent.getWizyty().add(this);
        ekstensja.add(this);

    }

    public static void readFromFile(String fileName) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splittedArray = line.split("\t");
                new Wizyta(
                        Lekarz.getById(splittedArray[0]),
                        Pacjent.getById(splittedArray[1]),
                        LocalDate.parse(splittedArray[2], dtf));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Wizyta> getEkstensja() {
        return ekstensja;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public LocalDate getDataWizyty() {
        return dataWizyty;
    }

    @Override
    public String toString() {
        return "Wizyta{" +
                "lekarz=" + lekarz.getId() +
                ", pacjent=" + pacjent.getId() +
                ", dataWizyty=" + dataWizyty +
                '}';
    }
}
