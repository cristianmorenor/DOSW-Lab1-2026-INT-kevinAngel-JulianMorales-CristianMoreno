package Laboratorio1.reto3;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Reto3 {

    // Canal A con SBuilder
    static Function<String, String> amplifyingMessage = message -> {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, 3).forEach(i -> sb.append(message).append(i < 2 ? " " : ""));
        return sb.toString();
    };

    // Canal B con SBuffer 
    static Function<String, String> reversingMessage = text -> new StringBuffer(text).reverse().toString();

    // Descifrado final 
    static Function<String, String> decodingMessage = amplifyingMessage.andThen(reversingMessage);

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mensaje interceptado = ");
        String message = scanner.nextLine();

        System.out.println("Canal A: \"" + amplifyingMessage.apply(message) + "\"");
        System.out.println("Descifrado final: \"" + decodingMessage.apply(message) + "\"");

        scanner.close();
    }
}