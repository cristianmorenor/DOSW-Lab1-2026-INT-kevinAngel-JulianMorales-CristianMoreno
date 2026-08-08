package Laboratorio1.reto6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reto6 {

    public static void ParteA(String comando) {
        switch (comando.toUpperCase()) {
            case "SALUDAR" -> System.out.println("¡Saludos, viajero del Tiempo y del código!");
            case "DESPEDIR" -> System.out.println("Hasta la próxima compilación, viajero.");
            case "CANTAR" -> System.out.println("La la la... compilando melodías en tiempo real.");
            case "DANZAR" -> System.out.println("Girando en modo fiesta.");
            default -> System.out.println("Comando no reconocido en el Fragmento 1.");
        }
    }

    public static void ParteB(String comando) {
        switch (comando.toUpperCase()) {
            case "BROMEAR" -> System.out.println("¿Por qué la RAM rompió con la CPU?\n  Porque necesitaba espacio...");
            case "GRITAR" -> System.out.println("¡AAAAAH! Modo alerta activado.");
            case "SUSURRAR" -> System.out.println("(susurro) ... aquí nadie puede oírme ...");
            case "ANALIZAR" -> System.out.println("Analizando datos... ¡Eres increíble!");
            default -> System.out.println("Comando no reconocido en el Fragmento 2.");
        }
    }

    public static void main(String[] args) {
        Map<String, Runnable> comandos = new HashMap<>();

        comandos.put("SALUDAR", () -> ParteA("SALUDAR"));
        comandos.put("DESPEDIR", () -> ParteA("DESPEDIR"));
        comandos.put("CANTAR", () -> ParteA("CANTAR"));
        comandos.put("DANZAR", () -> ParteA("DANZAR"));
        comandos.put("BROMEAR", () -> ParteB("BROMEAR"));
        comandos.put("GRITAR", () -> ParteB("GRITAR"));
        comandos.put("SUSURRAR", () -> ParteB("SUSURRAR"));
        comandos.put("ANALIZAR", () -> ParteB("ANALIZAR"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- RETO 6: UNIFICADO ---");
        System.out.println("Ingresa un comando (SALUDAR, DESPEDIR, CANTAR, DANZAR, BROMEAR, GRITAR, SUSURRAR, ANALIZAR):");
        String entrada = scanner.nextLine().trim().toUpperCase();

        comandos.getOrDefault(entrada, () -> System.out.println("Comando no reconocido: " + entrada)).run();

        scanner.close();
    }
}