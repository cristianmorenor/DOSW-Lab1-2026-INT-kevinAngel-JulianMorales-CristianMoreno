import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Reto5 {

    public static Set<Integer> crearHashSetConScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- RETO 5: ESTUDIANTE A (HashSet) ---");
        System.out.println("Ingresa los números separados por espacios:");
        String entrada = scanner.nextLine();

        Set<Integer> numeros = Arrays.stream(entrada.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
   
        Set<Integer> resultadoFiltrado = numeros.stream()
                .filter(n -> n % 3 != 0)
                .collect(Collectors.toSet());

        return resultadoFiltrado;
    }

    public static void main(String[] args) {
        Set<Integer> resultadoA = crearHashSetConScanner();
        System.out.println("\nHashSet resultante (sin múltiplos de 3): " + resultadoA);
    }
}