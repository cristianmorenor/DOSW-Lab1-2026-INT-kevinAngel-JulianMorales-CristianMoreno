package Laboratorio1.reto7;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class Reto7 {

    // Estudiante B 
    public static List<Jugador> pruebaDados(List<Jugador> jugadores, Map<Integer, Integer> dados) {
        Random random = new Random();

        // Asignar aleatoriamente entre 1-6 al jugador
        jugadores.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ACTIVO)
                .forEach(j -> dados.put(j.getNumero(), random.nextInt(6) + 1));

        List<Jugador> pass = jugadores.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ACTIVO)
                .filter(j -> dados.get(j.getNumero()) % 2 == 0)
                .collect(Collectors.toList());

        jugadores.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ACTIVO)
                .filter(j -> !pass.contains(j))
                .forEach(j -> j.setEstado(Jugador.Estado.ELIMINADO));

        return pass;
    }

    public static void main(String[] args) {
        
        List<Jugador> players = List.of(
                new Jugador(456, "Seong Gi-hun", 160_000_000),
                new Jugador(67, "Kang Sae-byeok", 80_000_000),
                new Jugador(218, "Cho Sang-woo", 250_000_000),
                new Jugador(199, "Ali Abdul", 70_000_000)
        );

        Map<Integer, Integer> dados = new HashMap<>();
        System.out.println("Prueba Dados:");
        List<Jugador> pass = pruebaDados(players, dados);

        String namesPass= pass.stream()
                .map(j -> j.getNombre() + "(" + dados.get(j.getNumero()) + ")")
                .collect(Collectors.joining(", "));
        System.out.println(" " + namesPass + " PASAN");

        players.stream()
                .filter(j -> j.getEstado() == Jugador.Estado.ELIMINADO)
                .forEach(j -> System.out.println(" Jugador " + j.getNumero() + " ELIMINADO"));
    }
}