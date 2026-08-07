import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MensajeBienvenida {

    private Function<Estudiante, String> describir = e ->
            e.getNombre() + ", estudiante de " + e.getSemestre()
                    + "° semestre de " + e.getEdad() + " años";

    public String generar(List<Estudiante> pareja) {

        String descripciones = pareja.stream()
                .map(describir)
                .collect(Collectors.joining(", y "));

        String correos = pareja.stream()
                .map(Estudiante::getCorreo)
                .collect(Collectors.joining(" y "));

        return "¡Hola profe que mas, bienvenido! Somos El grupo conformado por " + descripciones
                + ". Nuestros correos son: " + correos + ".";
    }
}
