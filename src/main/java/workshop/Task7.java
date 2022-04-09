package workshop;

/**
 * Time for a Test!
 *
 */
public class Task7 {
    /*
        1. What Are Some Advantages of Using Generic Types?
        When you're unsure about what types might be added, but your code is flexible enough to handle different
        combinations.  In general to make code more flexible.

        2. What is Type Erasure?
        Compiler uses the types for a type check, then it converts them to bytecode where doesn't need the types.

        3. If a Generic Type is Omitted When Instantiating an Object, will the Code Still Compile?
        It will work, (how you can create a list without any type provided) but it's not well written -- but it compiles
        because of the backwards compatibility.

        4. What is a Bounded Type Parameter? How can be Type Parameter Bounded?
        It is when you specify that the generic type must be a child (extends), wildcard(?) or a parent (super) of a given
        class. (Upper and lower bounds)

        5. Is it Possible to Declare a Multiple Bounded Type Parameter?
        Yes, <T extends Singer & Cloneable>

        6. Will the following class compile? If not, why?

            public final class Algorithm {
                public static <T> T max(T x, T y) {
                    return x > y ? x : y;
                }
            }

            No, because T must be an object, and the return statement is using comparison operators, which can only be
            used on primitive data types.

        7. Will the following class compile? If not, why?
            public class Singleton<T> {

                public static T getInstance() {
                    if (instance == null)
                        instance = new Singleton<T>();

                    return instance;
                }

                private static T instance = null;
            }

            Because the method is static, it won't inherit the class's T, and since it doesn't have a <T> defined, this
            would not compile.

        8. Can You Pass List<String> To A Method Which Accepts List<Object>?

          It depends, but as a general rule, no.  In this situation, no, because then you would break the original list
          if you added anything that wasn't a String. In a case where you just have some legacy code (because older
          versions didn't need to specify types) you could add a List<String> to a List, since the compiler would have
          no way to check the types of the List.

     */
}
