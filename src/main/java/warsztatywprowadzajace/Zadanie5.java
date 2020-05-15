package warsztatywprowadzajace;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>Dziedziczenie a generyki.</h1>
 *
 * Zapoznaj się z kodem zgodnie z kolejnością zapisu.
 *
 * @author Wojciech Makiela
 */
public class Zadanie5 {

    static class Wokalista {
        private final String gatunekMuzyczny;

        Wokalista(String gatunekMuzyczny) {
            this.gatunekMuzyczny = gatunekMuzyczny;
        }

        @Override
        public String toString() {
            return "Wokalista{" +
                    "gatunekMuzyczny='" + gatunekMuzyczny + '\'' +
                    '}';
        }
    }

    static class ElvisPresley extends Wokalista {

        ElvisPresley() {
            super("Rock'n'Roll");
        }
    }

    private static void wyświetlWokalistów(List<Wokalista> wokaliści) {
        for (Wokalista wokalista : wokaliści) {
            System.out.println(wokalista);
        }
    }

    public static void main(String[] args) {
        List<Wokalista> jacyśWokaliści = Arrays.asList(
                new Wokalista("Rock"),
                new Wokalista("Blues"));
        wyświetlWokalistów(jacyśWokaliści);

        List<ElvisPresley> listaZPresleyem = Arrays.asList(new ElvisPresley());
//        wyświetlWokalistów(listaZPresleyem);

        /*
        Masz listę jakichś wokalistów. Wrzucasz ją do 'wyświetlWokalistów' i wszystko działa.
        Masz listę Elvisów i próbujemy wyświetlić ich poprzez odkomentowanie linijki:
        wyświetlWokalistów(listaZPresleyem);

        W obu przypadkach jest taka sama lista. Różnią się tylko typem parametru. Jeśli zmienimy typ listyZPresleyem
        na List<Wokalista>, to będzie działać. Tylko dlaczego List<ElvisPresley> nie jest podtypem List<Wokalista>?
        Odpowiedź w kodzie:

            List<Integer> ints = Arrays.asList(1, 2); // Robimy listę Integerów
            List<Number> nums = ints;                 // Tutaj jest błąd kompilacji, ale teraz go ignorujemy.
            nums.add(3.14);                           // Double rozszerza Number, więc da się dodać.
            ints.toString().equals("1, 2, 3.14");     // Double w liście Integerów

        Przypisanie listy Integerów do zmiennej typu List<Number> powoduje błąd kompilacji, ponieważ może to
        doprowadzić do zepsucia pierwszej listy (Double w liście Integerów).
        Patrząc na to z perspektywy hierarchi dziedziczenia: List<Number> i List<Integer> są rodzeństwem, o wspólnym
        rodzicu - klasie Object.


        Aby to osiągnąć większą elastyczność - możliwość przekazania do metody `wyświetlWokalistów` dowolnej
        listy - użyjemy symbolu nieoznaczonego (ang. "wildcard") reprezentowanego znakiem zapytania. Zacznij od zmany
        deklaracji metody `wyświetlWokalistów`.

        private static void wyświetlWokalistów(List<?> wokaliści)

        Wildcard reprezentuje nieznany/dowolny typ. Zostawiony sam sobie (bez żadnych ograniczeń) symbolizuje Object.
        Twoim zadaniem jest nanieść takie ograniczenie, że do `wyświetlWokalistów` przekazać będzie można tylko listy
        obiektów typu `Wokalista`, lub dowolnego podtypu tejże klasy.
         */
    }
}
