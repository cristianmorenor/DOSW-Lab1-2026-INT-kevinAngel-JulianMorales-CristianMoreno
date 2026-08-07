import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Reto2 {

    static Function<List<Integer>, Integer> obtenerMinimo =
            lista -> lista.stream().min(Integer::compareTo).orElse(0);
    
    static Function<List<Integer>, Integer> obtenerCantidad = List::size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- CARRIL 2: ESTUDIANTE A ---");
        System.out.println("Ingresa los números separados por espacios");
    
        String entrada = scanner.nextLine();


        List<Integer> listaUsuario = Arrays.stream(entrada.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Mínimo: " + obtenerMinimo.apply(listaUsuario));
        System.out.println("Cantidad de datos: " + obtenerCantidad.apply(listaUsuario));
        
        scanner.close();
    }
}
