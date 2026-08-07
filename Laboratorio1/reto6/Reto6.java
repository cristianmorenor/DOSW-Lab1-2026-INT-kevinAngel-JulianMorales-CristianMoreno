import java.util.Scanner;

public class Reto6 {

    public static void ejecutarComandoFragmento1(String comando) {
        switch (comando.toUpperCase()) {
            case "SALUDAR":
                System.out.println("¡Saludos, viajero del Tiempo y del código!");
                break;
            case "DESPEDIR":
                System.out.println("Hasta la próxima compilación, viajero.");
                break;
            case "CANTAR":
                System.out.println("La la la... compilando melodías en tiempo real.");
                break;
            case "DANZAR":
                System.out.println("Girando en modo fiesta.");
                break;
            default:
                System.out.println("Comando no reconocido en el Fragmento 1.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- RETO 6: ESTUDIANTE A (Fragmento 1) ---");
        System.out.println("Ingresa un comando (SALUDAR, DESPEDIR, CANTAR, DANZAR):");
        String entrada = scanner.nextLine();

        ejecutarComandoFragmento1(entrada);
        scanner.close();
    }
}