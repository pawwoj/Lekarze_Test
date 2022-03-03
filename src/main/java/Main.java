import application.Application;

public class Main {
    /*
     * Dane są trzy pliki tekstowe o nazwach: lekarze.txt, pacjenci.txt, wizyty.txt.
     * Wykorzystując informacje zawarte w plikach wykonaj następujące polecenia:
     *
     * - znajdź lekarza ktory miał najwięcej wizyt
     * - znajdź pacjenta który miał najwięcej wizyt
     * - która specalizacja cieszy się największym ppowodzeniem
     * - którego roku było najwięcej wizyt?
     * - wypisz top 5 najstarszych lekarzy
     * + dodatek z dat
     *  Wypisz wszystkich pacjentów którzy mieli wizyty od 2000 roku
     *  Wypisz wszystkich lekarzy którzy mieli wizyty w marcu, czerwcu i grudniu 2007
     *  Wypisz lekarza ktory miał najwiecej wizyt w okresie podanym jako parametr
     */

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
