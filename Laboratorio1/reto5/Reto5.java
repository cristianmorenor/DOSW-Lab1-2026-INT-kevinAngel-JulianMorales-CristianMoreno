package Laboratorio1.reto5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Reto5 {


    public static Set<Integer> crearHashSetConScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" RETO 5: ESTUDIANTE A  ");
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


    public static TreeSet<Integer> filtrarMultiplosDe5(TreeSet<Integer> numeros) {
        return numeros.stream()
                .filter(n -> n % 5 != 0)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static void main(String[] args) {

        Set<Integer> resultadoA = crearHashSetConScanner();
        System.out.println("\nHashSet resultante (sin múltiplos de 3): " + resultadoA);

 
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> treeSet = new TreeSet<>();

        System.out.print("\nIngrese los números del TreeSet separados por espacio: ");
        String linea = scanner.nextLine();

        TreeSet<Integer> treeSet = Arrays.stream(linea.trim().split("\\s+"))
                .filter(parte -> !parte.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));

        TreeSet<Integer> resultadoB = filtrarMultiplosDe5(treeSet);
        resultadoB.forEach(n -> System.out.println("Número en arena: " + n));

        scanner.close();
    }
}
