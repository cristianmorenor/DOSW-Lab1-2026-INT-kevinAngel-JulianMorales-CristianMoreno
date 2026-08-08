package Laboratorio1.reto7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reto7 {

    public static List<Jugador> prueba1(List<Jugador> jugadores, long[] premio) {
        List<Jugador> eliminados = jugadores.stream()
                .filter(j -> j.getDeuda() > 170_000_000)
                .collect(Collectors.toList());

        eliminados.forEach(j -> {
            j.setEstado(Jugador.Estado.ELIMINADO);
            premio[0] += 50_000_000;
        });

        List<Jugador> pasan = jugadores.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ACTIVO)
                .collect(Collectors.toList());

        System.out.println("Luz Roja Luz Verde:");
        System.out.println("  " + pasan.stream().map(Jugador::getNombre).collect(Collectors.joining(", ")) + " PASAN");
        eliminados.forEach(j -> System.out.println("  Jugador " + j.getNumero() + " ELIMINADO"));

        return pasan;
    }

    public static List<Jugador> prueba2(List<Jugador> jugadores, long[] premio) {
        Random random = new Random();
        Map<Integer, Integer> dados = new HashMap<>();

        jugadores.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ACTIVO)
                .forEach(j -> dados.put(j.getNumero(), random.nextInt(6) + 1));

        List<Jugador> pasan = jugadores.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ACTIVO)
                .filter(j -> dados.get(j.getNumero()) % 2 == 0)
                .collect(Collectors.toList());

        jugadores.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ACTIVO)
                .filter(j -> !pasan.contains(j))
                .forEach(j -> {
                    j.setEstado(Jugador.Estado.ELIMINADO);
                    premio[0] += 50_000_000;
                });

        System.out.println("Los Dados:");
        System.out.println("  " + pasan.stream().map(j -> j.getNombre() + "(" + dados.get(j.getNumero()) + ")").collect(Collectors.joining(", ")) + " PASAN");
        jugadores.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ELIMINADO && !pasan.contains(j))
                .forEach(j -> System.out.println("  Jugador " + j.getNumero() + " ELIMINADO"));

        return pasan;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();

        System.out.println("Ingrese jugadores (numero nombre deuda), 'fin' para terminar:");
        while (true) {
            String linea = sc.nextLine().trim();
            if (linea.equalsIgnoreCase("fin")) break;
            String[] p = linea.split("\\s+");
            jugadores.add(new Jugador(Integer.parseInt(p[0]), p[1], Long.parseLong(p[2])));
        }

        long[] premio = {150_000_000_000L};
        prueba1(jugadores, premio);
        prueba2(jugadores, premio);

        System.out.println("Premio acumulado: " + premio[0] + " wones");
        sc.close();
    }
}