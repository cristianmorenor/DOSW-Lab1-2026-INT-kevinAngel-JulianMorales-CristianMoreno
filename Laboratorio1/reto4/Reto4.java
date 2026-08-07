import java.util.HashMap;
import java.util.Map;

public class Reto4 {
    public static Map<String, Integer> crearHashMap() {
        Map<String, Integer> mapa = new HashMap<>();
        
        mapa.putIfAbsent("oro", 5);
        mapa.putIfAbsent("plata", 3);
        mapa.putIfAbsent("oro", 7); 
        mapa.putIfAbsent("diamante", 10);
        
        return mapa;
    }

    public static void main(String[] args) {
        Map<String, Integer> resultadoA = crearHashMap();
        System.out.println("HashMap Estudiante A: " + resultadoA);
    }
}