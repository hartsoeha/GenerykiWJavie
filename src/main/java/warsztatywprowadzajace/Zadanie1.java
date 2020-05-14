package warsztatywprowadzajace;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Czasy przed generykami</h1>
 *
 * Uwaga - IntelliJ bardzo nie lubi nieużywania generyków, ani języka polskiego. Aby ograniczyć ilość
 * podkreśleń/zakolorowań, będziesz musiał ograniczyć inspekcje. Aby to zrobić kliknij w dolnym prawym rogu
 * (praktycznie na samym rogu okna IntelliJa) w ikonkę inspektora (taka buźka) lub użyj kombinacji klawiszy
 * Ctrl + Shift + Alt + 'H', a następnie ogranicz inspekcje do poziomu 'syntax'.
 *
 * <ol>
 *     <li>Przeczytaj uważnie implementację metody `retroJavaStyle`.</li>
 *     <li>Wykonaj kroki wypisane w metodzie `modernJavaStyle`</li>
 *     <li>Porównaj implementacje obu metod, a następnie przeczytaj podsumowanie na dole.</li>
 * </ol>
 *
 * @author Wojciech Makiela
 */
public class Zadanie1 {

    public static void main(String[] args) {
        retroJavaStyle();
        modernJavaStyle();
        howDoesItWork();
    }

    static void retroJavaStyle() {
        // Stworzenie nowej listy
        List strings = new ArrayList();
        // Dodanie elementów: 'pierwszy' i 'drugi'
        strings.add("pierwszy");
        strings.add("drugi");

        // Dodanie elementów: 3
        // Autoboxing pojawił się w Javie 5, więc trzeba ręcznie zapakować '3' w 'new Integer'
        strings.add(new Integer(3));

        // Wyciągnięcie pierwszego elementu z listy
        // Przed wprowadzeniem generyków wszystkie kolekcje były kolekcjami obiektów.
        // Co za tym idzie - by przypisać pierwszy element do zmiennej typu 'String' trzeba
        // użyć rzutowania.
        String string = (String) strings.get(0);

        // Wyciągnięcie trzeciego elementu z listy
        // Z racji tego, że nie mamy ograniczenia co może trafić do listy, możemy omyłkowo doprowadzić do
        // nielegalnego rzutowania.
        try {
            String anInteger = (String) strings.get(2);
        } catch (ClassCastException e) {
            System.out.println("Wyjątek czasu wykonania - nielegalne rzutowanie.");
        }
    }

    static void modernJavaStyle() {
        // Stwórz listę parametryzowaną typem 'String' i nazwij ją 'strings'


        // Dodaj elementy: 'pierwszy' i 'drugi'


        // Dodaj elementy: 3
        // Podjęcie się takiej próby poskutkuje błędem kompilacji. Przeczytaj treść i zakomentuj problematyczną linijkę.


        // Wyciągnij pierwszy element z listy, i przypisz go do zmiennej typu 'String'


    }

    /**
     * <h1>Podsumowanie:</h1>
     * <p>
     * Powinieneś teraz mieć 2 podobne implementacje - bez oraz z wykorzystaniem generyków.
     * <p>
     * Jak już wiesz, przed Javą 1.5 wszystkie kolekcje zawierały obiekty (Object).
     * Jako że wszystko w Javie da się przedstawić jako obiekt, to kolekcje były reużywalne.
     * Problemem był jednak brak ograniczeń tego, co trafia do kolekcji. Mogło być to źródłem wyjątków podczas
     * pobierania jej elementów.
     * </p>
     * Generyki powstały jako rozwiązanie tego problemu. Pozwalają nam ograniczać typ elementów dodawanych do
     * kolekcji oraz dają znać kompilatorowi jakie dodać rzutowanie.
     */
    private static void howDoesItWork() {
        // Sygnatura `<String>` dostarcza kompilatorowi informacji, że w naszej liście będą tylko instancje klasy
        // 'String'
        List<String> strings = new ArrayList<>();

        // Kompilator uwzględnia tę informację i dokonuje sprawdzenia, czy elementy wkładane do kolekcji są
        // odpowiedniego typu.
        strings.add("pierwszy");
        // strings.add(new Integer(3)); // Błąd kompilacji

        // Wyciąganie elemetów przed Javą 1.5 wymagało ręcznego rzutowania. Po wprowadzeniu generyków rzutowanie to
        // dodawane jest przez sam kompilator. Innymi słowy - rzutowanie dalej istnieje na poziomie kodu bajtowego,
        // ale w samym kodzie javovym nie jest ono potrzebne.
        String string = strings.get(0);
    }
}