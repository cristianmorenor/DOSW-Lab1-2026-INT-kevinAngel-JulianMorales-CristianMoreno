import java.util.Hashtable;
import java.util.Scanner;

public class Reto4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        System.out.println("Ingresar cantidad de pares");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese key/clave");
            String key = scanner.nextLine();
            System.out.println("Ingrese valor/value");
            int value = Integer.parseInt(scanner.nextLine());
            hashtable.put(key, value);
        }

        System.out.println("Hashtable");
        hashtable.forEach((key, value) -> System.out.println(key + ": " + value));

        scanner.close();
    }
}