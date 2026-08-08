package Laboratorio1.reto4;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Reto4 {

    public static Map<String, Integer> ejecutarParteA(Scanner scanner) {
        Map<String, Integer> mapa = new HashMap<>();

        System.out.println("--- RETO 4: ESTUDIANTE A (HashMap) ---");
        System.out.println("¿Cuántos pares clave-valor deseas ingresar?");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Ingresa la clave:");
            String clave = scanner.nextLine().trim();

            System.out.println("Ingresa el valor numérico:");
            int valor = Integer.parseInt(scanner.nextLine());

            mapa.putIfAbsent(clave, valor);
        }

        return mapa;
    }

    public static void ejecutarParteB(Scanner scanner) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        System.out.println("\n--- RETO 4: ESTUDIANTE B (Hashtable) ---");
        System.out.println("Ingresa cantidad de pares:");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese key/clave:");
            String key = scanner.nextLine();
            System.out.println("Ingrese valor/value:");
            int value = Integer.parseInt(scanner.nextLine());
            hashtable.put(key, value);
        }

        System.out.println("Hashtable resultante:");
        hashtable.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> resultadoA = ejecutarParteA(scanner);
        System.out.println("\nHashMap resultante (sin duplicados): " + resultadoA);

        ejecutarParteB(scanner);

        scanner.close();
    }
}