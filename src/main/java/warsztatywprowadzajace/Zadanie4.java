package warsztatywprowadzajace;


/**
 * <h1>Typy ograniczone.</h1>
 * <p>
 * Mamy takie klasy:
 * <ul>
 *     <li>Wokalista</li>
 *     <li>ElvisPresley</li>
 * </ul>
 * Niektórzy twierdzą, że Elvis nadal żyje, ponieważ został sklonowany.
 * <p>
 * Zatem sprawimy, że nasza klasa ElvisPresley również będzie Klonable.
 * <p><br/>
 * <b>Ważna notka:</b><br/>
 * Proszę nie modyfikuj żadnych klas ani interfejsów, chyba że dalsze polecenia stanowią inaczej.
 * <br/><br/>
 * <b>Ważna notka 2:</b>
 * Wiem, że niektórzy czują potrzebę zamiany nazwy 'Klonable' na 'Cloneable' i 'klonuj' na 'clone'.
 * Nie rób tego albo doprowadzisz do błędu kompilacji.
 * <p><br/>
 * Zapoznaj się z interfejsem Klonable, klasami Wokalista i ElvisPresley, oraz metodą 'main'.
 * W 'main' wywołana jest metoda 'klonujWokalistę' -> zaimplementuj ją zgodnie z instrukcjami.
 *
 * @author Wojciech Makiela
 */
public class Zadanie4 {

    interface Klonable<T> {
        T klonuj();
    }

    static class Wokalista {
        // Nie ruszać!
    }

    static class ElvisPresley extends Wokalista implements Klonable<ElvisPresley> {
        // Nie ruszać!
        @Override
        public ElvisPresley klonuj() {
            return new ElvisPresley();
        }

        @Override
        public String toString() {
            return "ElvisPresley{}";
        }
    }

    public static void main(String[] args) {
        // Cała logika tego zadania znajdzie się w metodzie 'klonujWokalistę'.
        // 'main' powstał tylko żeby ułatwić Ci testowanie twoich rozwiązań.
        System.out.println(klonujWokalistę(new ElvisPresley()));
    }

    private static Klonable klonujWokalistę(Klonable klonable) {
        return (Klonable) klonable.klonuj();
        /*
        Popatrz na to rzutowanie. Po kiego grzyba ono tu jest?
        Jak je usuniesz, to dostaniesz błąd. Zrób to, i przeczytaj opis błędu.

        Metoda 'klonuj' zwraca Object, a nie Klonable. No i w sumie to ma to sens.
        Jak zerkniesz na interfejs Klonable to zobaczysz typ zwrotny 'T', którym może być cokolwiek.
        W poprzednim zadaniu dowiedziałeś się, że w trakcie kompilacji typy generyczne zastępowane
        są obiektami (Object). I ma to sens. Wszak (prawie) wszystko w Javie jest obiektem, więc i nasz
        typ zwrotny 'T' jest traktowany jak obiekt.

        Ograniczenie typów generycznych:
        Jeżeli Elvisa dało się sklonować, to tego klona też powinno się dać.

        Tymczasem nasz Elvis może implementować interfejs Klonable<String> i dalej będzie to działało,
        choć nie będzie zbyt logiczne. Możesz to naprawić słówkiem kluczowym 'extends'.

        Jeśli zmienisz deklarację interfejsu Klonable<T> na 'Klonable<T extends Klonable>'
        sprawisz, że implementowanie Klonable<String> (String, lub czegokolwiek co nie implementuje Klonable) nie
        będzie możliwe.

        Ważna notka - przy generykach używamy tylko słówka 'extends', nigdy 'implements', niezależnie czy mówimy
        o klasach, czy interfejsach.

        Jeśli już poprawiłeś interfejs, to czytaj dalej.

        Na moment zostawisz metodę `klonujWokalistę`, aby poznać parametryzowane metody. Wiedza ta będzie Ci potrzebna
        do finalnego uprzątnięcia `klonujWokalistę`.
        Poniżej znajdziesz przykład parametryzowanej metody 'returnT(T t)'.
        Używałeś już typów generycznych klasy w której się znajdują (np getter do pola typu T z zadania 2).
        Istnieje jednak możliwość deklarowania generyków dla pojedynczej metody.
        Robimy to podobnie jak w przypadku klas -> w nawiasach ostrych podajemy nazwę naszego typu.
        Nasz zapis '<T>' musi pojawić się w deklaracji metody zaraz przed typem zwrotnym.
        Zerknij na 'returnT(T t)', a potem czytaj dalej.


        Co jeszcze nie działa w `klonujWokalistę`?

        Nasza metoda przyjmuje dowonle obiekty które są Klonable, nawet jeśli nie są wokalistami, i to jest problem.
        'klonujWokalistę' powinno przyjmować Wokalistów którzy są Klonable. Wykorzystaj wiedzę o parametryzowaniu metod
        i narzuć ograniczenie na typ generyczny. Aby ograniczyć się więcej niż jednym rodzicem musisz użyć symbolu '&'.
        Przykładowo: <T extends Person & Serializable>
        Ważna jest tutaj kolejność. Każda klasa może rozszerzać 1 klasę i dowolną ilość interfejsów. Tym tytułem
        ograniczenia generyków zaczynamy od klasy (T extends Person), a dopiero potem dopisujemy implementowane
        interfejsy (& Serializable).

        */
    }

    private static <T> T returnT(T t) {
        // T type is available only in this method
        System.out.println(t);
        return t;
    }
}