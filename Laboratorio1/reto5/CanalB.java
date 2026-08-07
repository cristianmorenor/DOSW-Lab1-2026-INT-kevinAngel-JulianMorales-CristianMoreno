package Laboratorio1.reto5;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CanalB {

    public static TreeSet<Integer> filtrarMultiplosDe5(TreeSet<Integer> numeros) {
        return numeros.stream()
                .filter(n -> n % 5 != 0)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> treeSet = new TreeSet<>();

        System.out.print("Ingrese los números del TreeSet separados por espacio: ");
        String linea = scanner.nextLine();

        for (String parte : linea.trim().split("\\s+")) {
            treeSet.add(Integer.parseInt(parte));
        }

        TreeSet<Integer> resultado = filtrarMultiplosDe5(treeSet);

        resultado.forEach(n -> System.out.println("Número en arena: " + n));

        scanner.close();
    }
}