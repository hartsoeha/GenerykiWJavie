package warsztatywprowadzajace;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <h1>Typy ograniczone - część 2.</h1>
 * <p>
 * Zapoznaj się z kodem zgodnie z kolejnością zapisu.
 *
 * @author Wojciech Makiela
 */
public class Zadanie6 {

    static class Wokalista {
        private String gatunekMuzyczny;

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

    private static void róbCośZWokalistami(List<? extends Wokalista> wokaliści, Consumer<Wokalista> consumer) {
        for (Wokalista wokalista : wokaliści) {
            consumer.accept(wokalista);
        }
    }

    public static void main(String[] args) {
        Consumer<Wokalista> zamieńNaGwiazdęKPopu = wokalista -> wokalista.gatunekMuzyczny = "KPop";
        List<Wokalista> wokaliści = Arrays.asList(new ElvisPresley());
        róbCośZWokalistami(wokaliści, zamieńNaGwiazdęKPopu);
        System.out.println(wokaliści.get(0).gatunekMuzyczny); // Elvis jest teraz gwazdą KPop.

        // No ale jest problem. Oczywiście, że jest jakiś problem...
        Consumer<Object> print = System.out::println;
        //        róbCośZWokalistami(wokaliści, print); // Błąd kompilacji.

        /*
        Metoda `róbCośZWokalistami` przyjmuje konsumenta wokalistów, a nie konsumenta obiektów.

        Proste zdefiniowanie konsumenta jako Consumer<Wokalista> mówi kompilatorowi, że interesują nas tylko i
        wyłącznie instancje klasy `Wokalista` => 1 konkretna klasa z drzewa dziedziczenia.

        Zdefiniowanie konsumenta jako Consumer<? extends Wokalista> informuje kompilator, że konsument obsłuży
        instancję dowolnej podklasy klasy `Wokalista` jak i instancje samej klasy `Wokalista` (ograniczamy typ od
        góry) => Wszystko co JEST `Wokalistą`, jest ok.

        Istnieje również opcja ograniczenia typu od dołu. By to zrobić używamy słowa kluczowego 'super'.
        Przykład:

            private static void printAList(List<? super Integer> list) {
                for (Object o : list) {
                    System.out.print(o);
                    System.out.print(", ");
                }
                System.out.println();
            }

        Analiza zapisu:
            List        - Metoda przyjmuje jakąś listę.
            <?          - Lista ta będzie przechowywać dowolne obiekty...
            super       - ... będące nadklasą...
            Integer>    - klasy Integer.

        Wzorując się na metodzie `printAList` popraw deklarację metody `róbCośZWokalistami` tak, by przekazanie
        konsumenta obiektów nie skutkowało błędem kompilacji.
         */
    }
}
