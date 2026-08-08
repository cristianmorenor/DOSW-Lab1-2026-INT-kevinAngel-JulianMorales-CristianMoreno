import java.util.Scanner;
import java.util.function.Function;

public class Reto3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar mensaje interceptado:");
        String message = scanner.nextLine();

        
        Function<String, String> reverseMessage = text ->
                new StringBuffer(text).reverse().toString();

        String result = reverseMessage.apply(message);
        System.out.println("Canal B: \"" + result + "\"");

        scanner.close();
    }
}