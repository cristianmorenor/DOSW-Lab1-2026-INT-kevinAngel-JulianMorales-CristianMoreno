package reto1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MensajeBienvenida {

    public static String generarSaludo(List<Estudiante> estudiantes) {

        List<String> descripciones = IntStream.range(0, estudiantes.size())
                .mapToObj(i -> {
                    Estudiante e = estudiantes.get(i);
                    String prefijo;
                    if (i == 0) {
                        prefijo = "estudiante de ";
                    } else {
                        prefijo = "de ";
                    }
                    return e.getNombre() + ", " + prefijo + e.getSemestre()
                            + "° semestre de " + e.getEdad() + " años";
                })
                .collect(Collectors.toList());

        String descripcionCompleta;
        if (descripciones.size() == 1) {
            descripcionCompleta = descripciones.get(0);
        } else {
            String todosMenosUltimo = String.join(", ",
                    descripciones.subList(0, descripciones.size() - 1));
            String ultimo = descripciones.get(descripciones.size() - 1);
            descripcionCompleta = todosMenosUltimo + ", y " + ultimo;
        }

        List<String> listaCorreos = estudiantes.stream()
                .map(Estudiante::getCorreo)
                .collect(Collectors.toList());

        String correos;
        if (listaCorreos.size() == 1) {
            correos = listaCorreos.get(0);
        } else {
            String todosMenosUltimo = String.join(", ",
                    listaCorreos.subList(0, listaCorreos.size() - 1));
            String ultimo = listaCorreos.get(listaCorreos.size() - 1);
            correos = todosMenosUltimo + " y " + ultimo;
        }

        String tipoGrupo;
        if (estudiantes.size() == 2) {
            tipoGrupo = "la pareja";
        } else {
            tipoGrupo = "el equipo";
        }

        String generoConformado;
        if (estudiantes.size() == 2) {
            generoConformado = "a";
        } else {
            generoConformado = "o";
        }

        return "¡Hola, bienvenidos! Somos " + tipoGrupo + " conformad"
                + generoConformado + " por "
                + descripcionCompleta + ". Nuestros correos son: "
                + correos + ".";
    }
}
