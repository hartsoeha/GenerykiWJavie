package warsztatywprowadzajace;

/**
 * <h1>Test!</h1>
 * <p>
 * Poniżej znajdziesz zestaw 8 pytań rekrutacyjnych o generyki w Javie.
 * Większość trudności tych pytań kryje się w anglojęzycznym słownictwie i trudności
 * przewidzenia jak zadziała wymazywanie typów.
 * Celem tego testu jest pokazanie Ci nad czym pracować.
 * <p>
 * Udziel odpowiedzi, a potem je sprawdź. Rozwiązań szukaj w poprzednich zadaniach lub internecie.
 * Im więcej pracy włożysz w znalezienie odpowiedzi, tym większa szansa, że ją zapamiętasz :)
 */
public class Zadanie7 {
    /*
        1. What Are Some Advantages of Using Generic Types?
        2. What is Type Erasure?
        3. If a Generic Type is Omitted When Instantiating an Object, will the Code Still Compile?
        4. What is a Bounded Type Parameter? How can be Type Parameter Bounded?
        5. Is it Possible to Declared a Multiple Bounded Type Parameter?
        6. Will the following class compile? If not, why?

            public final class Algorithm {
                public static <T> T max(T x, T y) {
                    return x > y ? x : y;
                }
            }

        7. Will the following class compile? If not, why?
            public class Singleton<T> {

                public static T getInstance() {
                    if (instance == null)
                        instance = new Singleton<T>();

                    return instance;
                }

                private static T instance = null;
            }
        8. Can You Pass List<String> To A Method Which Accepts List<Object>?
     */
}
