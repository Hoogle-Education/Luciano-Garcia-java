import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class App {

    // public static boolean ehPar(int numero) {
    //     return numero % 2 == 0;
    // }

    public static <T> boolean valida(T value, Predicate<T> condition) {
        return condition.test(value);
    }

    public static void main(String[] args) throws Exception {
        
        // lambda - expressao lambda
        // () -> ()
        // () -> {...}

        // (T) -> boolean
        // Predicate<Integer> verificaPar = App::ehPar;
        // System.out.println(valida(2, App::ehPar));
        boolean validaTest = valida(2, n -> {
            for(int i = 2; i < n; i++){
                if(n%i == 0) return false;
            }

            return true;
        });

        System.out.println(validaTest);

        // Predicate<Integer> verificaImpar = App::ehImpar;
        // Predicate<Integer> ehImpar = (n) -> (n%2!=0);
        // Predicate<Integer> ehPar = ehImpar.negate();

        // System.out.println(valida(2, App::ehPar));

        // (T) -> void
        Consumer<String> console = msg -> System.out.println(msg);
        console.accept("hello world");
        
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        integers.forEach(System.out::println);

        // Function<Integer, String> 
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        
        integers
            .stream()            
            .reduce(0, (element, acc) -> (element + acc));
    }

}
