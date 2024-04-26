import Game.Partida;
import Models.*;
import Utilities.GeneradorPersonajeAleatorio;
import java.util.Scanner;
import static Log.Logger.leerLogs;
import static Log.Logger.borrarLogs;
import static Utilities.CreadorPersonajeManual.crearPersonajeManualmente;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        String opcion;

        while (!salir) {
            menu();
            opcion = input.nextLine();
            switch (opcion) {
                case "1":
                    partidaAleatoria();
                    break;
                case "2":
                    partidaManual();
                    break;
                case "3":
                    leerLogs();
                    break;
                case "4":
                    borrarLogs();
                    break;
                case "0":
                    salir = true;
                    break;
                default:
                    System.out.println(" Opcion inválida, por favor ingrese una opción válida.\n");
            }
        }
    }

    public static void partidaAleatoria() {
        // Generar jugadores con personajes aleatorios
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        for (int i = 0; i < 3; i++) {
            jugador1.agregarPersonaje(GeneradorPersonajeAleatorio.generarPersonajeAleatoriamente());
            jugador2.agregarPersonaje(GeneradorPersonajeAleatorio.generarPersonajeAleatoriamente());
        }

        // Crear y ejecutar la partida
        Partida partida = new Partida(jugador1, jugador2);
        partida.jugarPartida();
    }

    public static void partidaManual() {
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n |=== Creación de personajes para el Jugador 1 ===| ");
        for (int i = 0; i < 3; i++) {
            Personaje personaje = crearPersonajeManualmente();
            jugador1.agregarPersonaje(personaje);

            if (i < 2) {
                System.out.print("\nPresiona ENTER para crear el siguiente personaje del jugador 1");
            scanner.nextLine();
            }
        }

        System.out.println("\n |=== Creación de personajes para el Jugador 2 ===| ");
        for (int i = 0; i < 3; i++) {
            Personaje personaje = crearPersonajeManualmente();
            jugador2.agregarPersonaje(personaje);

            if (i < 2) {
                System.out.print("\nPresiona ENTER para crear el siguiente personaje del jugador 2");
            scanner.nextLine();
             }
        }
        System.out.println("¡Se crearon los personajes con exito!");
        // Crear y ejecutar la partida
        Partida partida = new Partida(jugador1, jugador2);
        partida.jugarPartida();
    }

    private static void menu() {
        System.out.println("\n|============= MENU =============|");
        System.out.println("| [1] Iniciar partida aleatoria  |");
        System.out.println("| [2] Iniciar partida manual     |");
        System.out.println("| [3] Leer logs de partidas      |");
        System.out.println("| [4] Borrar archivo de logs     |");
        System.out.println("| [0] Salir                      |");
        System.out.println("|================================|");
        System.out.print(" Ingrese una opción: ");
    }

}
