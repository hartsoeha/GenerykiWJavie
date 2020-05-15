package warsztatywprowadzajace;

/**
 * <h1>Generyki - wprowadzenie praktyczne.</h1>
 * <p>W tej części zajmiesz się rozszerzeniem klasy Zadanie2.</p>
 * Ma ona przechowywać 2 zmienne. Jedną typu `T`, a drugą typu `S`.
 * Aktualnie przyjmuje tylko jeden typ parametryzowany `T`.
 * <p>
 * Możesz zdefiniować dodatkowe typy, dopisując je po przecinku w nawiasach ostrokątnych ('<>').
 *
 * @author Wojciech Makiela
 */
public class Zadanie2<T> {

    // TODO - pole typu S
    final T poleTypuT;

    public static void main(String[] args) {
        Zadanie2<String> stringZadanie2 = new Zadanie2<String>("Hello");
    }

    // TODO - popraw konstruktor. Ma przyjmować 2 zmienne - 1 typu T i 1 typu S
    public Zadanie2(T zmiennaTypuT) {
        this.poleTypuT = zmiennaTypuT;
    }

    /*
    Jeśli skończyłeś, to odpal testy (klasa Zadanie2Test). Były zakomentowane, aby uniknąć błędów kompilacji.

    if (testy.przechodzą()) continue;
    else return;
    */
}


class Wór {

    /*
    Następne zadanie - klasa Wór - szybka powtórka z tworzenia klas generycznych.

    Nasz Wór powinien zawierać 3 zmienne.
    2 parametryzowane (generyczne) o nazwach 'Pierwszy' i 'Drugi', i jedną listę stringów.
    Nie musisz użyć dokładnie tych nazw, ale testy zakładają użycie getterów po takie właśnie
    zmienne, więc możesz użyć IDE do automatycznej generacji kodu.

    Testy znajdziesz w klasie WórTest.
    Jeśli testy przechodzą, zapoznaj się z kolejną sekcją.

    ...

    Wrócimy na moment do klasy Zadanie2. Dodaj w jej konstruktorze taką linijkę:

        T[] ts = new T[10];

    Otrzymasz błąd kompilacji. Lekcja na dziś - nie da się stworzyć tablicy typu generycznego.
    Dlaczego?

    Każdy obiekt w Javie zna swoją klasę, którą można podejrzeć w trakcie działania aplikacji (dalej zwanym Runtime)
    za pomocą metody '.getClass()'. Ta informacja jest dostarczana w momencie tworzenia obiektu.
    To samo tyczy się tablic (wszak tablice są obiektami). Co za tym idzie, podczas tworzenia tablicy należy
    dokładnie wyznaczyć jakie elementy będą w niej przechowywane.

    I tutaj pojawia się problem. Informacje o 'T' tracone są w trakcie kompilacji (o wymazywaniu typów w następnym zadaniu).
    Próbując w Runtimie stworzyć tablicę 'T[]' nie wiesz czym tak naprawdę jest 'T', a więc nie jesteś w stanie
    dostarczyć wymaganej informacji o klasie którą reprezentować ma nasza tablica.

    Ciekawostka:
    Generyki mają konwencję nazewnictwa!
        E - Element
        K - Key
        N - Number
        T - Type
        V - Value
        S,U,V etc. - drugi, trzeci itd element po 'T'.

    Dobra rada - nie stosujcie się do niej - przynajmniej nie podczas pisania.
    Kiedy pojawia się wiele generyków w wielu klasach, i wszędzie mają te same (jednoliterowe) nazwy reprezentujące
    różne rzeczy, łatwo się pogubić.
    Polecam (przynajmniej na czas pisania kodu - potem można zmienić) używać opisowych nazw.

     */

}

