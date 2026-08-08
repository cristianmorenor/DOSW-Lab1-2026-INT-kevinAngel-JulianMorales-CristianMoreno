package Laboratorio1.reto4;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reto4 {

    public static Map<String, Integer> ejecutarParteA(Scanner scanner) {
        System.out.println(" RETO 4: ESTUDIANTE A ");
        System.out.println("¿Cuántos pares clave-valor deseas ingresar?");
        int n = Integer.parseInt(scanner.nextLine());
        return IntStream.range(0, n)
                .mapToObj(i -> {
                    System.out.println("Ingresa la clave:");
                    String clave = scanner.nextLine().trim();
                    System.out.println("Ingresa el valor numérico:");
                    int valor = Integer.parseInt(scanner.nextLine());
                    return Map.entry(clave, valor);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,   
                        HashMap::new
                ));
    }

    public static Hashtable<String, Integer> ejecutarParteB(Scanner scanner) {
        System.out.println("\nRETO 4: ESTUDIANTE B ");
        System.out.println("Ingresa cantidad de pares:");
        int count = Integer.parseInt(scanner.nextLine());
        Hashtable<String, Integer> hashtable = IntStream.range(0, count)
                .mapToObj(i -> {
                    System.out.println("Ingrese key/clave:");
                    String key = scanner.nextLine().trim();
                    System.out.println("Ingrese valor/value:");
                    int value = Integer.parseInt(scanner.nextLine());
                    return Map.entry(key, value);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v2,   
                        Hashtable::new
                ));
        return hashtable;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resultadoA = ejecutarParteA(scanner);
        System.out.println("\nHashMap resultante (sin duplicados): " + resultadoA);

        Hashtable<String, Integer> resultadoB = ejecutarParteB(scanner);
        System.out.println("Hashtable resultante: " + resultadoB);


        Map<String, Integer> combinado = Stream.concat(
                        resultadoA.entrySet().stream(),
                        resultadoB.entrySet().stream())
                .collect(Collectors.toMap(
                        e -> e.getKey().toUpperCase(), 
                        Map.Entry::getValue,
                        (v1, v2) -> v2                
                ));

        System.out.println("\nRESULTADO FINAL:");
        combinado.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())   
                .forEach(e -> System.out.printf("Clave: %-10s | Valor: %d%n",
                        e.getKey(), e.getValue()));

        scanner.close();
    }
}
