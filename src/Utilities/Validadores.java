package Utilities;

import java.util.Scanner;

public class Validadores {

    // Método para leer un string y validar que solo contenga letras
    protected static String validarString(Scanner input) {
        String entrada;
        do {
            entrada = input.nextLine().trim();
            if (!entrada.matches("[a-zA-Z]+")) {
                System.out.println("Ingrese solo letras.");
            }
        } while (!entrada.matches("[a-zA-Z]+"));
        return entrada;
    }

    // Método para leer un double y validarlo
    protected static double validarDouble(Scanner input, String mensaje, double min, double max) {
        double entrada;
        do {
            System.out.print(mensaje);
            while (!input.hasNextDouble()) {
                System.out.println("Ingrese un número válido.");
                input.next();
            }
            entrada = input.nextDouble();
            if (entrada < min || entrada > max) {
                System.out.println("El valor debe estar entre " + min + " y " + max + ".");
            }
        } while (entrada < min || entrada > max);
        return entrada;
    }

    // Método para leer un entero y validarlo
    protected static Integer validarInteger(Scanner input, String mensaje, Integer min, Integer max) {
        int entrada;
        do {
            System.out.print(mensaje);
            while (!input.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                input.next();
            }
            entrada = input.nextInt();
            if (entrada < min || entrada > max) {
                System.out.println("El valor debe estar entre " + min + " y " + max + ".");
            }
        } while (entrada < min || entrada > max);
        return entrada;
    }
}
