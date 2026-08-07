import java.util.Arrays;
import java.util.List;

public class Reto1 {
    public static void main(String[] args) {
        Estudiante a = new Estudiante("Kevin Angel", 22, "kevin.angel-a@mail.escuelaing.edu.co", 7);
        Estudiante b = new Estudiante("juan morales", 23, "juan.felipe.-m@mail.escuelaing.edu.co", 7);
        Estudiante c = new Estudiante("cristian moreno", 22, "cristian.santiago-m@mail.escuelaing.edu.co", 7);


        List<Estudiante> pareja = Arrays.asList(a, b, c);

        MensajeBienvenida mensaje = new MensajeBienvenida();
        System.out.println(mensaje.generar(pareja));
    }
}
