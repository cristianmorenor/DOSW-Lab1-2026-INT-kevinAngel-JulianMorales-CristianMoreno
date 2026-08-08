package Laboratorio1.reto7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reto7 {

    public static final long LIMITE_DEUDA = 170_000_000L;
    public static final long PREMIO_ELIMINADO_PRUEBA1 = 50_000_000L;

    public static List<Jugador> prueba1LuzRojaLuzVerde(List<Jugador> jugadores, long[] premioTotal) {
        List<Jugador> pasan = jugadores.stream()
                .filter(j -> j.getDeuda() <= LIMITE_DEUDA)
                .collect(Collectors.toList());

        List<Jugador> eliminados = jugadores.stream()
                .filter(j -> j.getDeuda() > LIMITE_DEUDA)
                .collect(Collectors.toList());

        eliminados.forEach(j -> {
            j.setEstado(Jugador.Estado.ELIMINADO);
            premioTotal[0] += PREMIO_ELIMINADO_PRUEBA1;
        });

        System.out.println("Prueba 1 — Luz Roja Luz Verde:");
        String nombresPasan = pasan.stream()
                .map(Jugador::getNombre)
                .collect(Collectors.joining(", "));
        System.out.println("  " + nombresPasan + " PASAN");

        eliminados.forEach(j -> System.out.println("  Jugador " + j.getNumero() + " ELIMINADO"));

        return pasan;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();

        System.out.println("Ingrese jugadores (numero nombre deuda), escriba 'fin' para terminar:");
        while (true) {
            String linea = scanner.nextLine().trim();
            if (linea.equalsIgnoreCase("fin")) {
                break;
            }
            String[] partes = linea.split("\\s+");
            int numero = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            long deuda = Long.parseLong(partes[2]);
            jugadores.add(new Jugador(numero, nombre, deuda));
        }

        long[] premioTotal = {150_000_000_000L};
        List<Jugador> sobrevivientes = prueba1LuzRojaLuzVerde(jugadores, premioTotal);

        System.out.println("Premio acumulado: " + premioTotal[0] + " wones");

        scanner.close();
    }
}