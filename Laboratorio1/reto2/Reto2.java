import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Reto2 {

    static Function<List<Integer>, Resultados> allResults = list -> {
        int max = list.stream().max(Integer::compareTo).orElseThrow();
        int min = list.stream().min(Integer::compareTo).orElseThrow();
        int count = list.size();
        return new Resultados(max, min, count, max % 2 == 0, count % 2 == 0);
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = readList(scanner, "List 1");
        List<Integer> list2 = readList(scanner, "List 2");

        printResults("List 1", allResults.apply(list1));
        printResults("List 2", allResults.apply(list2));

        scanner.close();
    }

    private static void printResults(String label, Resultados r) {
        System.out.println(label + " => max:" + r.max + " min:" + r.min + " cant:" + r.count);
        System.out.println(" ¿" + r.max + " divisible de 2? " + (r.isMultiple ? "Sí" : "No"));
        System.out.println(" ¿Cantidad (" + r.count + ") es " + (r.isEvenCount ? "par" : "impar") + "? Sí");
    }

    private static List<Integer> readList(Scanner scanner, String listName) {
        System.out.println("Ingrese los números de " + listName + " separados por espacio:");
        String line = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();
        for (String part : line.trim().split("\\s+")) {
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }
}

class Resultados {
    int max, min, count;
    boolean isMultiple, isEvenCount;

    Resultados(int max, int min, int count, boolean isMultiple, boolean isEvenCount) {
        this.max = max;
        this.min = min;
        this.count = count;
        this.isMultiple = isMultiple;
        this.isEvenCount = isEvenCount;
    }
}