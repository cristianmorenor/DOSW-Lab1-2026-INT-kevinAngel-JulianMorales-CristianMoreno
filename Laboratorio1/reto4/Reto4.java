import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reto4 {

    public static Map<String, Integer> crearHashMapConScanner() {
        Map<String, Integer> mapa = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- RETO 4: ESTUDIANTE A (HashMap) ---");
        System.out.println("¿Cuántos pares clave-valor deseas ingresar?");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Ingresa la clave :");
            String clave = scanner.nextLine().trim();

            System.out.println("Ingresa el valor numérico:");
            int valor = Integer.parseInt(scanner.nextLine());


            mapa.putIfAbsent(clave, valor);
        }

        return mapa;
    }

    public static void main(String[] args) {
        Map<String, Integer> resultadoA = crearHashMapConScanner();
        System.out.println("\nHashMap resultante (sin duplicados): " + resultadoA);
    }
}