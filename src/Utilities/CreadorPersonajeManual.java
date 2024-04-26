package Utilities;

import Models.Elfo;
import Models.Humano;
import Models.Orco;
import Models.Personaje;
import java.util.Scanner;

public class CreadorPersonajeManual {

    public static Personaje crearPersonajeManualmente() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n ~ Ingrese los datos del personaje: ");

        System.out.print("Nombre: ");
        String nombre = Validadores.validarString(input);

        System.out.print("Apodo: ");
        String apodo = Validadores.validarString(input);

        double salud = Validadores.validarDouble(input, "Salud (entre 25000 y 250000): ", 25000, 250000);

        Integer velocidad = Validadores.validarInteger(input, "Velocidad (entre 1 y 10): ", 1, 10);

        Integer destreza = Validadores.validarInteger(input, "Destreza (entre 1 y 5): ", 1, 5);

        Integer fuerza = Validadores.validarInteger(input, "Fuerza (entre 1 y 10): ", 1, 10);

        Integer nivel = Validadores.validarInteger(input, "Nivel (entre 1 y 10): ", 1, 10);

        double armadura = Validadores.validarDouble(input, "Armadura (entre 1 y 10): ", 1, 10);

        Integer opcionRaza;
            System.out.println(" Elija el tipo de raza:");
            System.out.println("  [1] Humano");
            System.out.println("  [2] Elfo");
            System.out.println("  [3] Orco");
            opcionRaza = Validadores.validarInteger(input, "Opción: ", 1, 3);

            // Crear un personaje basado en la elección del usuario
        switch (opcionRaza) {
            case 1:
                return new Humano(nombre, apodo, salud, velocidad, destreza, fuerza, nivel, armadura);
            case 2:
                return new Elfo(nombre, apodo, salud, velocidad, destreza, fuerza, nivel, armadura);
            case 3:
                return new Orco(nombre, apodo, salud, velocidad, destreza, fuerza, nivel, armadura);
            default:
                return null;
            }
    }

}
