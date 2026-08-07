package Laboratorio1.reto3;

import java.util.Scanner;

public class CanalA {

    public static String amplificarMensaje(String mensaje) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(mensaje);
            if (i < 2) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mensaje interceptado: ");
        String mensajeInterceptado = scanner.nextLine();

        String resultado = amplificarMensaje(mensajeInterceptado);

        System.out.println("Canal A: " + resultado);

        scanner.close();
    }
}