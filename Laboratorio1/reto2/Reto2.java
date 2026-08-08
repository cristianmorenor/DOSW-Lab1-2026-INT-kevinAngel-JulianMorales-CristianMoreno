import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Reto2 {

    static Function<List<Integer>, Integer> calculateMax = list ->
            list.stream().max(Integer::compareTo).orElseThrow();

    static Function<List<Integer>, Integer> calculateMin = list ->
            list.stream().min(Integer::compareTo).orElseThrow();

    static Function<List<Integer>, Integer> calculateCount = List::size;

    // Choque 1 Combinando máximo, mínimo y cantidad
    static Function<List<Integer>, String> combinarResults = list ->
            "max:" + calculateMax.apply(list) +
            " min:" + calculateMin.apply(list) +
            " cant:" + calculateCount.apply(list);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = readList(scanner, "Lista 1");

        System.out.println("Lista 1 => " + combinarResults.apply(list1));

        scanner.close();
    }

    private static List<Integer> readList(Scanner scanner, String listName) {
        System.out.println("Ingrese los números separados por espacio:");
        String line = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();
        for (String part : line.trim().split("\\s+")) {
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }
}