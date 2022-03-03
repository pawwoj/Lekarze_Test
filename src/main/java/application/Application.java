package application;

import model.Lekarz;
import model.Pacjent;
import model.Wizyta;
import service.Service;

import java.time.LocalDate;
import java.util.List;

public class Application {
    Service service = new Service();

    public void run() {
        Lekarz.readFromFile("lekarze.txt");
        Pacjent.readFromFile("pacjenci.txt");
        Wizyta.readFromFile("wizyty.txt");

        /*DEMO*/
        System.out.println("\nznajdź lekarza ktory miał najwięcej wizyt :");
        System.out.println(service.lekarzKtoryMialNajwiecejWizyt(Lekarz.getEkstensja()));

        System.out.println("\nznajdź pacjenta który miał najwięcej wizyt :");
        System.out.println(service.pacjentKtoryMialNajwiecejWizyt(Pacjent.getEkstensja()));

        System.out.println("\nktóra specalizacja cieszy się największym ppowodzeniem :");
        System.out.println(service.specjalizacjaCieszacaSieNajwiekszymPowodzeniam(Wizyta.getEkstensja()));

        System.out.println("\nktórego roku było najwięcej wizyt? :");
        System.out.println(service.rokWKtorymByloNajwiecejWizyt(Wizyta.getEkstensja()));

        System.out.println("\nwypisz top 5 najstarszych lekarzy :");
        System.out.println(service.topNajstarszychLekarzy(Lekarz.getEkstensja(), 5));

        System.out.println("\n + dodatek z dat");
        System.out.println("Wypisz wszystkich pacjentów którzy mieli wizyty od 2000 roku :");
        System.out.println(service.pacjenciKtorzyMieliWizytyOdDanegoRoku(Wizyta.getEkstensja(),
                2000));

        System.out.println("\nWypisz wszystkich lekarzy którzy mieli wizyty w marcu, czerwcu i grudniu 2007 :");
        System.out.println(service.lekarzeZWizytamiWKazdymZDanychMiesiecy(Lekarz.getEkstensja(),
                List.of(3, 6, 12), 2007));
        System.out.println("brak takich lekarzy to podaje aby szukalo dla miesiecy luty, marzec i kwiecien :");
        System.out.println(service.lekarzeZWizytamiWKazdymZDanychMiesiecy(Lekarz.getEkstensja(),
                List.of(2, 3, 4), 2007));

        System.out.println("\nWypisz lekarza ktory miał najwiecej wizyt w okresie podanym jako parametr :");
        System.out.println(service.lekarzKtoryMialNajwiecejWizytWDanymOkresie(Lekarz.getEkstensja(),
                LocalDate.of(2006, 8, 4),
                LocalDate.of(2006, 12, 21)));
    }
}
