package reto1;

import java.util.List;

public class Reto1 {

    public static void main(String[] args) {

        Estudiante kevin = new Estudiante("Kevin Angel", 22,
                "kevin.angel-a@mail.escuelaing.edu.co", 7);

        Estudiante cristian = new Estudiante("Cristian Moreno", 22,
                "cristian.moreno-r@mail.escuelaing.edu.co", 7);

        Estudiante julian = new Estudiante("Julian Morales", 22,
                "julian.morales-z@mail.escuelaing.edu.co", 7);

        List<Estudiante> estudiantes = List.of(kevin, cristian, julian);

        String saludo = MensajeBienvenida.generarSaludo(estudiantes);

        System.out.println(saludo);
    }
}
