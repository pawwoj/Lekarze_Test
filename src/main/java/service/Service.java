package service;

import model.Lekarz;
import model.Pacjent;
import model.Wizyta;

import java.time.LocalDate;
import java.util.*;

public class Service {

    public Lekarz lekarzKtoryMialNajwiecejWizyt(List<Lekarz> lekarze) {
        return lekarze.stream()
                .max(Comparator.comparingInt(Lekarz::iloscWizyt))
                .orElseThrow();
    }

    public Pacjent pacjentKtoryMialNajwiecejWizyt(List<Pacjent> pacjenci) {
        return pacjenci.stream()
                .max(Comparator.comparingInt(Pacjent::iloscWizyt))
                .orElseThrow();
    }

    public String specjalizacjaCieszacaSieNajwiekszymPowodzeniam(List<Wizyta> wizyty) {
        int max = 0;
        String specjalizacja = "";
        List<String> specjalizacje = wizyty.stream()
                .map(wizyta -> wizyta.getLekarz().getSpecjalnosc()).toList();

        for (String temp : specjalizacje) {
            int wystapienia = Collections.frequency(specjalizacje, temp);
            if (max < wystapienia) {
                specjalizacja = temp;
                max = wystapienia;
            }
        }
        return specjalizacja;
    }

    public int rokWKtorymByloNajwiecejWizyt(List<Wizyta> wizyty) {
        int max = 0;
        int rok = 0;
        List<Integer> lata = wizyty.stream()
                .map(wizyta -> wizyta.getDataWizyty().getYear())
                .distinct().toList();

        for (int temp : lata) {
            int wystapienia = Collections.frequency(lata, temp);
            if (max < wystapienia) {
                rok = temp;
                max = wystapienia;
            }
        }
        return rok;
    }

    public List<Lekarz> topNajstarszychLekarzy(List<Lekarz> lekarze, int top) {
        return lekarze.stream()
                .sorted(Comparator.comparing(Lekarz::getDataUrodzenia))
                .limit(top).toList();
    }

    public List<Pacjent> pacjenciKtorzyMieliWizytyOdDanegoRoku(List<Wizyta> wizyty, int odRoku) {
        return wizyty.stream()
                .filter(wizyta -> wizyta.getDataWizyty().getYear() >= odRoku)
                .map(Wizyta::getPacjent).distinct().toList();
    }

    public List<Lekarz> lekarzeZWizytamiWKazdymZDanychMiesiecy(List<Lekarz> lekarze, List<Integer> miesiace, int rok) {
        List<Lekarz> lekarzeZWizytami = new ArrayList<>();
        for (Lekarz lekarz : lekarze) {
            if (lekarz.miesiaceWizytLekarzaZDanegoRoku(rok).containsAll(miesiace)) {
                lekarzeZWizytami.add(lekarz);
            }
        }
        return lekarzeZWizytami;
    }

    public Lekarz lekarzKtoryMialNajwiecejWizytWDanymOkresie(List<Lekarz> lekarze,LocalDate odDaty, LocalDate doDaty) {
        return lekarze.stream()
                .max(Comparator.comparingInt(lekarz -> lekarz.wizytyLekarzaOdDatyDoDaty(odDaty, doDaty).size()))
                .orElseThrow();
    }
}
