// package Laboratorio1.reto5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reto5 {

    
    public static Set<Integer> crearHashSetConScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" RETO 5 ");
        System.out.println("Ingresa los números separados por espacios:");
        String entrada = scanner.nextLine();

        return Arrays.stream(entrada.trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet())
                .stream()
                .filter(n -> n % 3 != 0)          
                .collect(Collectors.toSet());
    }

 
    public static TreeSet<Integer> filtrarMultiplosDe5(TreeSet<Integer> numeros) {
        return numeros.stream()
                .filter(n -> n % 5 != 0)         
                .collect(Collectors.toCollection(TreeSet::new));
    }


    public static TreeSet<Integer> unirConjuntos(Set<Integer> a, Set<Integer> b) {
        return Stream.concat(a.stream(), b.stream())
                .collect(Collectors.toCollection(TreeSet::new)); 

    public static void main(String[] args) {

        Set<Integer> resultadoA = crearHashSetConScanner();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese los números del TreeSet separados por espacio: ");
        String linea = scanner.nextLine();

        TreeSet<Integer> treeSet = Arrays.stream(linea.trim().split("\\s+"))
                .filter(parte -> !parte.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));

        TreeSet<Integer> resultadoB = filtrarMultiplosDe5(treeSet);


        TreeSet<Integer> unificado = unirConjuntos(resultadoA, resultadoB);


        unificado.stream()
                .forEach(n -> System.out.println("Número en arena: " + n));

        scanner.close();
    }
}
