package Game;

import Log.Logger;
import Models.Jugador;
import Models.Personaje;
import Utilities.GeneradorPersonajeAleatorio;
import Utilities.TiempoEspera;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Integer rondaActual;
    private Jugador jugadorInicio;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.rondaActual = 0;
        this.jugadorInicio = null;
    }

    public void jugarPartida() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String fechaHoraInicio = dateFormat.format(new Date());
        // Registrar inicio de partida en el log
        Logger.Log("\n ~ Inicio de la partida [fecha y hora: " + fechaHoraInicio + "] ~ ");

        while (!jugador1.getPersonajes().isEmpty() && !jugador2.getPersonajes().isEmpty()) {
            rondaActual++;
            Scanner scanner = new Scanner(System.in);

            // Determinar quién inicia la primer ronda
            if (rondaActual == 1) {
                jugadorInicio = (GeneradorPersonajeAleatorio.generarNumAleatorio(0, 1) == 0) ? jugador1 : jugador2;
                System.out.println("\nPRESIONA ENTER PARA INICIAR LA PARTIDA");
                scanner.nextLine();
            }

            //Limitar los decimales a 2
            DecimalFormat df = new DecimalFormat("#.##");

            // Mostrar datos de los personajes para cada jugador
            System.out.println("|========================================================= Personajes " + jugador1.getNombre() + " =========================================================|");
            for (Personaje personaje : jugador1.getPersonajes()) {
                System.out.println(" ~ Nombre: " + personaje.getNombre() + " | Apodo: " + personaje.getApodo() + " | Raza: " + personaje.getClass().getSimpleName() +
                        " | Salud: " + df.format(personaje.getSalud()) + " | Velocidad: " + personaje.getVelocidad() + " | Destreza: " + personaje.getDestreza() +
                        " | Fuerza: " + personaje.getFuerza() + " | Armadura: " + personaje.getArmadura() + " | Nivel: " + personaje.getNivel());
            }
            System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------|");
            TiempoEspera.esperar3seg();

            System.out.println("|========================================================= Personajes " + jugador2.getNombre() + " =========================================================|");
            for (Personaje personaje : jugador2.getPersonajes()) {
                System.out.println(" ~ Nombre: " + personaje.getNombre() + " | Apodo: " + personaje.getApodo() + " | Raza: " + personaje.getClass().getSimpleName() +
                        " | Salud: " + df.format(personaje.getSalud()) + " | Velocidad: " + personaje.getVelocidad() + " | Destreza: " + personaje.getDestreza() +
                        " | Fuerza: " + personaje.getFuerza() + " | Armadura: " + personaje.getArmadura() + " | Nivel: " + personaje.getNivel());
            }
            System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------|");
            TiempoEspera.esperar3seg();

            // Log de datos de los personajes para cada jugador, solo se imprime en la ronda 1 en el log para mejor visualización
            if (rondaActual == 1) {
                Logger.Log("\n|========================================================= Personajes " + jugador1.getNombre() + " =========================================================|");
                for (Personaje personaje : jugador1.getPersonajes()) {
                    Logger.Log(" ~ Nombre: " + personaje.getNombre() + " | Apodo: " + personaje.getApodo() + " | Raza: " + personaje.getClass().getSimpleName() +
                            " | Salud: " + df.format(personaje.getSalud()) + " | Velocidad: " + personaje.getVelocidad() + " | Destreza: " + personaje.getDestreza() +
                            " | Fuerza: " + personaje.getFuerza() + " | Armadura: " + personaje.getArmadura() + " | Nivel: " + personaje.getNivel());
                }
                Logger.Log("|----------------------------------------------------------------------------------------------------------------------------------------|");

                Logger.Log("|========================================================= Personajes " + jugador2.getNombre() + " =========================================================|");
                for (Personaje personaje : jugador2.getPersonajes()) {
                    Logger.Log(" ~ Nombre: " + personaje.getNombre() + " | Apodo: " + personaje.getApodo() + " | Raza: " + personaje.getClass().getSimpleName() +
                            " | Salud: " + df.format(personaje.getSalud()) + " | Velocidad: " + personaje.getVelocidad() + " | Destreza: " + personaje.getDestreza() +
                            " | Fuerza: " + personaje.getFuerza() + " | Armadura: " + personaje.getArmadura() + " | Nivel: " + personaje.getNivel());
                }
                Logger.Log("|----------------------------------------------------------------------------------------------------------------------------------------|");
            }

            // Seleccionar personajes aleatorios para la ronda
            Personaje personajeJugador1 = jugador1.getPersonajes().get(GeneradorPersonajeAleatorio.generarNumAleatorio(0, jugador1.getPersonajes().size() - 1));
            Personaje personajeJugador2 = jugador2.getPersonajes().get(GeneradorPersonajeAleatorio.generarNumAleatorio(0, jugador2.getPersonajes().size() - 1));

            // Jugar la ronda y pasar el jugador que inicia la ronda como parámetro
            Ronda ronda = new Ronda(personajeJugador1, personajeJugador2, jugador1, jugador2);
            ronda.jugarRonda(rondaActual, jugadorInicio);

            // Actualizar lista de personajes
            actualizarListaDePersonajes(jugador1.getPersonajes());
            actualizarListaDePersonajes(jugador2.getPersonajes());

            //Pausa entre Rondas y determinar ganador al finalizar la partida
            if (!jugador1.getPersonajes().isEmpty() && !jugador2.getPersonajes().isEmpty()) {
                System.out.println("\nPresiona ENTER para continuar con la siguiente Ronda...");
                scanner.nextLine();
            } else if (jugador1.getPersonajes().isEmpty()) {
                TiempoEspera.esperar2seg();
                System.out.println(Logger.Log("\n¡Felicitaciones " + jugador2.getNombre() + ", eres merecedor del Trono de Hierro!\n"));
            } else {
                TiempoEspera.esperar2seg();
                System.out.println(Logger.Log("\n¡Felicitaciones " + jugador1.getNombre() + ", eres merecedor del Trono de Hierro!\n"));
            }
        }

    }

    private void actualizarListaDePersonajes(List<Personaje> personajes) {
        Iterator<Personaje> iterator = personajes.iterator();
        boolean jugador1Perdio = false;
        boolean jugador2Perdio = false;
        while (iterator.hasNext()) {
            Personaje personaje = iterator.next();
            if (personaje.getSalud() <= 0) {
                iterator.remove();
                if (personajes == jugador1.getPersonajes()) {
                    jugador1Perdio = true;
                } else if (personajes == jugador2.getPersonajes()) {
                    jugador2Perdio = true;
                }
            }
        }

        // Verificar qué jugador perdió y actualizar jugadorInicio para la siguiente ronda
        if (jugador1Perdio && !jugador2Perdio) {
            jugadorInicio = jugador1;
        } else if (!jugador1Perdio && jugador2Perdio) {
            jugadorInicio = jugador2;
        }

    }
}
