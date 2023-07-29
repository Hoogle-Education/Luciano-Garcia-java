import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStreams {
  
  public static void main(String[] args) {
    
    List<Integer> integers = new ArrayList<>( List.of(3, 2, 4, 1, 5) );

    Stream<Integer> integerStream = integers.stream().filter(n -> n%2 == 0);

    integers.stream() // inicia a stream
        .dropWhile(n -> n <= 3) // operacao intermediaria
        .forEach(n -> System.out.println(n)); // operacao terminal

    System.out.println("-------");
    integers.sort(Integer::compare);
    integers.forEach(System.out::println);

    integers.stream()
        .filter(n -> n%2!=0)
        .collect(Collectors.toList());

    var words = new ArrayList<>(List.of("apple", "banana", "avoCado", "cheRRy", "apricot"));
    var captalizeWords = words.stream()
        .map(w -> w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase())
        .collect(Collectors.joining(", "));

    //Predicate<> func = (x, y) -> x > y;

    var totalChars = words.stream()
        .map(w -> w.length())
        .reduce(0, (value, acc) -> value + acc);

    System.out.println(totalChars);

  }

}
