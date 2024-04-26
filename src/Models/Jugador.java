package Models;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;
    private List<Personaje> personajes;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.personajes = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public String getNombre() {
        return nombre;
    }

}
