package Laboratorio1.reto6;

import java.util.Scanner;

public class Reto6 {

    public static void ejecutarComandoFragmento2(String comando) {
        switch (comando) {
            case "BROMEAR":
                System.out.println("¿Por qué la RAM rompió con la CPU?\n  Porque necesitaba espacio...");
                break;
            case "GRITAR":
                System.out.println("¡AAAAAH! Modo alerta activado.");
                break;
            case "SUSURRAR":
                System.out.println("(susurro) ... aquí nadie puede oírme ...");
                break;
            case "ANALIZAR":
                System.out.println("Analizando datos... ¡Eres increíble!");
                break;
            default:
                System.out.println("Comando no reconocido: " + comando);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese comando (BROMEAR, GRITAR, SUSURRAR, ANALIZAR): ");
        String comando = scanner.nextLine().trim().toUpperCase();

        ejecutarComandoFragmento2(comando);

        scanner.close();
    }
}