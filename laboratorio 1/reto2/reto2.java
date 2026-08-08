import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Reto2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = readList(scanner, "Lista 1");

        Function<List<Integer>, Integer> calculateMax = list -> list.stream()
                    .max(Integer::compareTo)
                    .orElseThrow();

        int max = calculateMax.apply(list1);
        System.out.println("Máximo: " + max);

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