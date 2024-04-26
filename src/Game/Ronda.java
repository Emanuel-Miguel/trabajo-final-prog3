package Game;

import Log.Logger;
import Models.Jugador;
import Models.Personaje;
import Utilities.TiempoEspera;
import java.text.DecimalFormat;


public class Ronda {
    private Personaje personajeJugador1;
    private Personaje personajeJugador2;
    private Jugador jugador1;
    private Jugador jugador2;

    public Ronda(Personaje personajeJugador1, Personaje personajeJugador2, Jugador jugador1, Jugador jugador2) {
        this.personajeJugador1 = personajeJugador1;
        this.personajeJugador2 = personajeJugador2;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void jugarRonda(Integer rondaActual, Jugador jugadorInicio) {
        System.out.println(Logger.Log("\n [ Ronda " + rondaActual + " ] "));
        TiempoEspera.esperar2seg();

        if (rondaActual == 1 ) {
            System.out.println(Logger.Log("El sistema sorteó al " + jugadorInicio.getNombre() + " para iniciar la ronda."));
            TiempoEspera.esperar2seg();
        } else {
            System.out.println(Logger.Log("Empieza atacando el " + jugadorInicio.getNombre() + " por perder la ronda anterior."));
            TiempoEspera.esperar2seg();
        }

        System.out.println(Logger.Log("El sistema eligió al personaje ¡" + personajeJugador1.getNombre() + " " +personajeJugador1.getApodo() +
                "! del jugador 1 y al personaje ¡" + personajeJugador2.getNombre() + " " + personajeJugador2.getApodo() +
                "! del jugador 2 para que se enfrenten en esta ronda."));
        TiempoEspera.esperar3seg();

        System.out.println(Logger.Log("\n              ¡" + personajeJugador1.getNombre() + " " + personajeJugador1.getApodo() + "! vs ¡" + personajeJugador2.getNombre()
                + " " + personajeJugador2.getApodo() + "! "));
        TiempoEspera.esperar2seg();

        boolean murioAlgunPersonaje = false; // Variable para verificar si murió algún personaje
        for (int i = 0; i < 14; i++) {

            Personaje atacante;
            Personaje defensor;

            // Determinar quién ataca y quién defiende en este turno
            if (jugadorInicio == jugador1) {
                atacante = personajeJugador1;
                defensor = personajeJugador2;
                jugadorInicio = jugador2; // Cambiar al próximo jugador
            } else {
                atacante = personajeJugador2;
                defensor = personajeJugador1;
                jugadorInicio = jugador1; // Cambiar al próximo jugador
            }

            //Limitar los decimales a 2
            DecimalFormat df = new DecimalFormat("#.##");

            // Atacar y actualizar la salud del defensor
            double danio = atacante.calcularAtaque((double) defensor.getVelocidad(), defensor.getArmadura());
            if (danio < 0) {
                danio = 0;
            }
            double saludRestante = defensor.getSalud() - danio;

            // Verificar que la salud restante sea al menos 0 o positiva
            if (saludRestante < 0) {
                saludRestante = 0;
            }

            defensor.setSalud(saludRestante);
            System.out.println(Logger.Log(atacante.getNombre() + " ataca y hace " + df.format(danio) + " de daño. " +
                    defensor.getNombre() + " queda con " + df.format(saludRestante) + " de salud."));

            // Verificar si el defensor ha muerto
            if (saludRestante <= 0) {
                TiempoEspera.esperar2seg();
                System.out.println(Logger.Log(defensor.getNombre() + " muere."));
                atacante.mejorarHabilidades(); // Aumentar la salud en +25000 por ganar la Ronda
                TiempoEspera.esperar2seg();
                System.out.println(Logger.Log("El personaje " + atacante.getNombre() + " obtuvo una mejora en salud de +25000 por ganar la partida. Salud actual: " + df.format(atacante.getSalud())));
                TiempoEspera.esperar2seg();
                murioAlgunPersonaje = true;
                break;
            }
            // Demora de 2 segundos entre cada ataque
            TiempoEspera.esperar2seg();
        }
        // Verificar si ningún personaje murió en esta ronda
        if (!murioAlgunPersonaje) {
            System.out.println("       ¡No murió ningún personaje en este enfrentamiento!");
        }
    }
}


