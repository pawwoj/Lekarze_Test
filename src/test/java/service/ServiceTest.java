package service;

import model.Lekarz;
import model.Osoba;
import model.Pacjent;
import model.Wizyta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;


class ServiceTest {

    @BeforeAll
    public static void setUp() {
        Lekarz.readFromFile("lekarzeTest.txt");
        Pacjent.readFromFile("pacjenciTest.txt");
        Wizyta.readFromFile("wizytyTest.txt");
    }

    @Test
    @DisplayName("Zwracany lekarz nie jest null")
    void lekarzKtoryMialNajwiecejWizytTest_NotNull() {
        Service service = new Service();

        assertThat(service.lekarzKtoryMialNajwiecejWizyt(Lekarz.getEkstensja()))
                .isNotNull();
    }

    @Test
    @DisplayName("Zwracany lekarz jest klasy dziedziczacej po Osoba")
    void lekarzKtoryMialNajwiecejWizytTest_KlasaOsoba() {
        Service service = new Service();

        assertThat(service.lekarzKtoryMialNajwiecejWizyt(Lekarz.getEkstensja()))
                .isInstanceOf(Osoba.class);
    }

    @Test
    @DisplayName("Zwracany lekarz jest klasy Lekarz")
    void lekarzKtoryMialNajwiecejWizytTest_KlasaLekarz() {
        Service service = new Service();

        assertThat(service.lekarzKtoryMialNajwiecejWizyt(Lekarz.getEkstensja()))
                .isExactlyInstanceOf(Lekarz.class);
    }

    @Test
    @DisplayName("Zwracany lekarz nie jest innym nieoczekiwanym lekarzem")
    void lekarzKtoryMialNajwiecejWizytTest_NieInnyLekarz() {
        Service service = new Service();
        Lekarz nieoczekiwany = Lekarz.getEkstensja().get(3);

        assertThat(service.lekarzKtoryMialNajwiecejWizyt(Lekarz.getEkstensja()))
                .isNotEqualTo(nieoczekiwany);
    }

    @Test
    @DisplayName("Zwracany lekarz jest zgodny z oczekiwanym")
    void lekarzKtoryMialNajwiecejWizytTest_OczekiwanyLekarz() {
        Service service = new Service();
        Lekarz oczekiwany = Lekarz.getEkstensja().get(1);

        assertThat(service.lekarzKtoryMialNajwiecejWizyt(Lekarz.getEkstensja()))
                .isEqualTo(oczekiwany);
    }

    @Test
    @DisplayName("Zwracany pacjent nie jest null")
    void pacjentKtoryMialNajwiecejWizytTest_NotNull() {
        Service service = new Service();

        assertThat(service.pacjentKtoryMialNajwiecejWizyt(Pacjent.getEkstensja()))
                .isNotNull();
    }

    @Test
    @DisplayName("Zwracany pacjent jest klasy dziedziczacej po Osoba")
    void pacjentKtoryMialNajwiecejWizytTest_KlasaOsoba() {
        Service service = new Service();

        assertThat(service.pacjentKtoryMialNajwiecejWizyt(Pacjent.getEkstensja()))
                .isInstanceOf(Osoba.class);
    }

    @Test
    @DisplayName("Zwracany pacjent jest klasy Pacjent")
    void pacjentKtoryMialNajwiecejWizytTest_KlasaPacjent() {
        Service service = new Service();

        assertThat(service.pacjentKtoryMialNajwiecejWizyt(Pacjent.getEkstensja()))
                .isExactlyInstanceOf(Pacjent.class);
    }

    @Test
    @DisplayName("Zwracany pacjent nie jest innym nieoczekiwanym pacjentem")
    void pacjentKtoryMialNajwiecejWizytTest_NieInnyPacjent() {
        Service service = new Service();
        Pacjent nieoczekiwany = Pacjent.getEkstensja().get(7);

        assertThat(service.pacjentKtoryMialNajwiecejWizyt(Pacjent.getEkstensja()))
                .isNotEqualTo(nieoczekiwany);
    }

    @Test
    @DisplayName("Zwracany pacjent jest zgodny z oczekiwanym")
    void pacjentKtoryMialNajwiecejWizytTest_OczekiwanyPacjent() {
        Service service = new Service();
        Pacjent oczekiwany = Pacjent.getEkstensja().get(1);

        assertThat(service.pacjentKtoryMialNajwiecejWizyt(Pacjent.getEkstensja()))
                .isEqualTo(oczekiwany);
    }

    @Test
    @DisplayName("Zwracany string specjalizacji nie jest nullem")
    void specjalizacjaCieszacaSieNajwiekszymPowodzeniamTest_NotNull() {
        Service service = new Service();

        assertThat(service.specjalizacjaCieszacaSieNajwiekszymPowodzeniam(Wizyta.getEkstensja()))
                .isNotNull();
    }

    @Test
    @DisplayName("Zwracany string specjalizacji nie jest pusty")
    void specjalizacjaCieszacaSieNajwiekszymPowodzeniamTest_NotEmpty() {
        Service service = new Service();

        assertThat(service.specjalizacjaCieszacaSieNajwiekszymPowodzeniam(Wizyta.getEkstensja()))
                .isNotEmpty();
    }

    @Test
    @DisplayName("Zwracany string specjalizacji jest klasy String")
    void specjalizacjaCieszacaSieNajwiekszymPowodzeniamTest_String() {
        Service service = new Service();

        assertThat(service.specjalizacjaCieszacaSieNajwiekszymPowodzeniam(Wizyta.getEkstensja()))
                .isExactlyInstanceOf(String.class);
    }

    @Test
    @DisplayName("Zwracany string specjalizacji jest zgodny z oczekiwaniem")
    void specjalizacjaCieszacaSieNajwiekszymPowodzeniamTest_ZgodnyZOczekiwaniem() {
        Service service = new Service();
        String oczekiwany = "Maxspec";

        assertThat(service.specjalizacjaCieszacaSieNajwiekszymPowodzeniam(Wizyta.getEkstensja()))
                .isEqualTo(oczekiwany);
    }

    @Test
    @DisplayName("Zwracany int roku jest nie jest nullem")
    void rokWKtorymByloNajwiecejWizytTest_NotNull() {
        Service service = new Service();

        assertThat(service.rokWKtorymByloNajwiecejWizyt(Wizyta.getEkstensja()))
                .isNotNull();
    }

    @Test
    @DisplayName("Zwracany int roku jest jest dodatni")
    void rokWKtorymByloNajwiecejWizytTest_IsPositive() {
        Service service = new Service();

        assertThat(service.rokWKtorymByloNajwiecejWizyt(Wizyta.getEkstensja()))
                .isPositive();
    }

    @Test
    @DisplayName("Zwracany int roku nie jest rowny nieoczekiwanemu intowi")
    void rokWKtorymByloNajwiecejWizytTest_NieInnyInt() {
        Service service = new Service();
        int nieoczekiwany = 2001;

        assertThat(service.rokWKtorymByloNajwiecejWizyt(Wizyta.getEkstensja()))
                .isNotEqualTo(nieoczekiwany);
    }

    @Test
    @DisplayName("Zwracany int roku jest rowny oczekiwanemu intowi")
    void rokWKtorymByloNajwiecejWizytTest_TakiJakOczekiwany() {
        Service service = new Service();
        int oczekiwany = 2000;

        assertThat(service.rokWKtorymByloNajwiecejWizyt(Wizyta.getEkstensja()))
                .isEqualTo(oczekiwany);
    }

    @Test
    @DisplayName("Zwracana lista lekarzy nie jest nullem")
    void topNajstarszychLekarzyTest_NotNull() {
        Service service = new Service();
        int top = 2;

        assertThat(service.topNajstarszychLekarzy(Lekarz.getEkstensja(), top))
                .isNotNull();
    }

    @Test
    @DisplayName("Zwracana lista lekarzy nie jest pusta")
    void topNajstarszychLekarzyTest_NotEmpty() {
        Service service = new Service();
        int top = 2;

        assertThat(service.topNajstarszychLekarzy(Lekarz.getEkstensja(), top))
                .isNotEmpty();
    }

    @Test
    @DisplayName("Zwracana lista lekarzy jest oczekiwanej wielkosci")
    void topNajstarszychLekarzyTest_WielkosciTop() {
        Service service = new Service();
        int top = 2;

        assertThat(service.topNajstarszychLekarzy(Lekarz.getEkstensja(), top))
                .hasSize(top);
    }

    @Test
    @DisplayName("Zwracana lista lekarzy jest taka jak oczekiwana lista")
    void topNajstarszychLekarzyTest_ListaLekarzy() {
        Service service = new Service();
        List<Lekarz> oczekiwana = List.of(Lekarz.getEkstensja().get(2), Lekarz.getEkstensja().get(0));
        int top = 2;

        assertThat(service.topNajstarszychLekarzy(Lekarz.getEkstensja(), top))
                .isEqualTo(oczekiwana);
    }

    @Test
    @DisplayName("Zwracana lista lekarzy nie zawiera innego lekarza")
    void topNajstarszychLekarzyTest_BezInnych() {
        Service service = new Service();
        Lekarz inny = Lekarz.getEkstensja().get(1);
        int top = 2;

        assertThat(service.topNajstarszychLekarzy(Lekarz.getEkstensja(), top))
                .doesNotContain(inny);
    }

    @Test
    @DisplayName("Zwracana lista pacjentow nie jest nullem")
    void pacjenciKtorzyMieliWizytyOdDanegoRokuTest_NotNull() {
        Service service = new Service();
        int rok = 2001;

        assertThat(service.pacjenciKtorzyMieliWizytyOdDanegoRoku(Wizyta.getEkstensja(), rok))
                .isNotNull();
    }

    @Test
    @DisplayName("Zwracana lista pacjentow nie jest pusta")
    void pacjenciKtorzyMieliWizytyOdDanegoRokuTest_NotEmpty() {
        Service service = new Service();
        int rok = 2001;

        assertThat(service.pacjenciKtorzyMieliWizytyOdDanegoRoku(Wizyta.getEkstensja(), rok))
                .isNotEmpty();
    }

    @Test
    @DisplayName("Zwracana lista pacjentow jest oczekiwanej dlugosci")
    void pacjenciKtorzyMieliWizytyOdDanegoRokuTest_OczekiwanejDlugosci() {
        Service service = new Service();
        int rok = 2001;
        int dlugosc = 2;

        assertThat(service.pacjenciKtorzyMieliWizytyOdDanegoRoku(Wizyta.getEkstensja(), rok))
                .hasSize(dlugosc);
    }

    @Test
    @DisplayName("Zwracana lista pacjentow jest taka jak oczekiwana lista")
    void pacjenciKtorzyMieliWizytyOdDanegoRokuTest_JakOczekiwanaLista() {
        Service service = new Service();
        int rok = 2001;
        List<Pacjent> oczekiwana = List.of(Pacjent.getEkstensja().get(6), Pacjent.getEkstensja().get(7));

        assertThat(service.pacjenciKtorzyMieliWizytyOdDanegoRoku(Wizyta.getEkstensja(), rok))
                .isEqualTo(oczekiwana);
    }

    @Test
    @DisplayName("Zwracana lista pacjentow nie zawiera innego pacjenta")
    void pacjenciKtorzyMieliWizytyOdDanegoRokuTest_BezInnych() {
        Service service = new Service();
        int rok = 2001;
        Pacjent inny = Pacjent.getEkstensja().get(1);

        assertThat(service.pacjenciKtorzyMieliWizytyOdDanegoRoku(Wizyta.getEkstensja(), rok))
                .doesNotContain(inny);
    }

    @Test
    @DisplayName("Zwracana lista lekarzy nie jest nullem")
    void lekarzeZWizytamiWKazdymZDanychMiesiecyTest_NotNull() {
        Service service = new Service();
        List<Integer> miesiace = List.of(1, 2, 3);
        int rok = 2000;

        assertThat(service.lekarzeZWizytamiWKazdymZDanychMiesiecy(Lekarz.getEkstensja(), miesiace, rok))
                .isNotNull();
    }

    @Test
    @DisplayName("Zwracana lista lekarzy nie jest pusta")
    void lekarzeZWizytamiWKazdymZDanychMiesiecy_NotEmpty() {
        Service service = new Service();
        List<Integer> miesiace = List.of(1, 2, 3);
        int rok = 2000;

        assertThat(service.lekarzeZWizytamiWKazdymZDanychMiesiecy(Lekarz.getEkstensja(), miesiace, rok))
                .isNotEmpty();
    }

    @Test
    @DisplayName("Zwracana lista lekarzy jest oczekiwanej dlugosci")
    void lekarzeZWizytamiWKazdymZDanychMiesiecy_OczekiwanejDlugosci() {
        Service service = new Service();
        List<Integer> miesiace = List.of(1, 2, 3);
        int rok = 2000;
        int dlugosc = 2;

        assertThat(service.lekarzeZWizytamiWKazdymZDanychMiesiecy(Lekarz.getEkstensja(), miesiace, rok))
                .hasSize(dlugosc);
    }

    @Test
    @DisplayName("Zwracana lista lekarzy jest taka jak oczekiwana lista")
    void lekarzeZWizytamiWKazdymZDanychMiesiecy_JakOczekiwanaLista() {
        Service service = new Service();
        List<Integer> miesiace = List.of(1, 2, 3);
        int rok = 2000;
        List<Lekarz> oczekiwana = List.of(Lekarz.getEkstensja().get(1), Lekarz.getEkstensja().get(2));

        assertThat(service.lekarzeZWizytamiWKazdymZDanychMiesiecy(Lekarz.getEkstensja(), miesiace, rok))
                .isEqualTo(oczekiwana);
    }

    @Test
    @DisplayName("Zwracana lista lekarzy nie zawiera innego lekarza")
    void lekarzeZWizytamiWKazdymZDanychMiesiecy_bezInnego() {
        Service service = new Service();
        List<Integer> miesiace = List.of(1, 2, 3);
        int rok = 2000;
        Lekarz inny = Lekarz.getEkstensja().get(0);

        assertThat(service.lekarzeZWizytamiWKazdymZDanychMiesiecy(Lekarz.getEkstensja(), miesiace, rok))
                .doesNotContain(inny);
    }

    @Test
    @DisplayName("Zwracany lekarz z wizytami w danym czasie, nie jest nullem")
    void lekarzKtoryMialNajwiecejWizytWDanymOkresieTest_NotNull() {
        Service service = new Service();
        LocalDate odDaty = LocalDate.of(2001, 12, 15);
        LocalDate doDaty = LocalDate.of(2001, 12, 15);

        assertThat(service.lekarzKtoryMialNajwiecejWizytWDanymOkresie(Lekarz.getEkstensja(), odDaty, doDaty))
                .isNotNull();
    }

    @Test
    @DisplayName("Zwracany lekarz z wizytami w danym czasie, jest klasy Lekarz")
    void lekarzKtoryMialNajwiecejWizytWDanymOkresieTest_KlasyLekarz() {
        Service service = new Service();
        LocalDate odDaty = LocalDate.of(2001, 12, 15);
        LocalDate doDaty = LocalDate.of(2001, 12, 15);

        assertThat(service.lekarzKtoryMialNajwiecejWizytWDanymOkresie(Lekarz.getEkstensja(), odDaty, doDaty))
                .isExactlyInstanceOf(Lekarz.class);
    }

    @Test
    @DisplayName("Zwracany lekarz z wizytami w danym czasie nie jest innym lekarzem")
    void lekarzKtoryMialNajwiecejWizytWDanymOkresieTest_NotEqual() {
        Service service = new Service();
        LocalDate odDaty = LocalDate.of(2001, 12, 15);
        LocalDate doDaty = LocalDate.of(2001, 12, 15);

        Lekarz inny = Lekarz.getEkstensja().get(0);

        assertThat(service.lekarzKtoryMialNajwiecejWizytWDanymOkresie(Lekarz.getEkstensja(), odDaty, doDaty))
                .isNotEqualTo(inny);
    }

    @Test
    @DisplayName("Zwracany lekarz z wizytami w danym czasie jest taki jak oczekiwany")
    void lekarzKtoryMialNajwiecejWizytWDanymOkresieTest_IsEqual() {
        Service service = new Service();
        LocalDate odDaty = LocalDate.of(2000, 11, 15);
        LocalDate doDaty = LocalDate.of(2001, 12, 15);
        Lekarz oczekiwany = Lekarz.getEkstensja().get(3);

        assertThat(service.lekarzKtoryMialNajwiecejWizytWDanymOkresie(Lekarz.getEkstensja(), odDaty, doDaty))
                .isEqualTo(oczekiwany);
    }
}