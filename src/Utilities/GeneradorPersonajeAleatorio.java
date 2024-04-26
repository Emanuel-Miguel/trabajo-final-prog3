package Utilities;

import Models.Elfo;
import Models.Humano;
import Models.Orco;
import Models.Personaje;
import java.util.Random;

public class GeneradorPersonajeAleatorio {

    private static Random aleatorio = new Random();

    public static Integer generarNumAleatorio(Integer min, Integer max) {
        return aleatorio.nextInt(max - min + 1) + min;
    }

    public static Personaje generarPersonajeAleatoriamente() {
        String[] razas = {"Humano", "Elfo", "Orco"};
        String[] nombres = {"Rand", "Grom", "Arwen", "Legolas", "Elinor", "Aldric", "Rowena", "Cedric", "Lyria", "Thalara", "Morgar", "Drakka", "Gorak", "Thok", "Grish", "Erendil"};
        String[] apodos = {"Hunter", "Arrow", "Cyber", "Viper", "Fernet", "Sky", "Glide", "Phoenix", "Loki", "Witcher", "Savage", "Joker", "Shogun", "Raze", "Silent", "Reaper"};
        Integer razaIndex = generarNumAleatorio(0, 2);
        String nombre = nombres[generarNumAleatorio(0, nombres.length - 1)];
        String apodo = apodos[generarNumAleatorio(0, apodos.length - 1)];
        //Integer edad = generarNumAleatorio(0, 300);
        double salud = 250000.0;
        Integer velocidad = generarNumAleatorio(1, 10);
        Integer destreza = generarNumAleatorio(1, 5);
        Integer fuerza = generarNumAleatorio(1, 10);
        Integer nivel = generarNumAleatorio(1, 10);
        double armadura = generarNumAleatorio(1, 10);
        switch (razas[razaIndex]) {
            case "Humano":
                return new Humano(nombre, apodo, /*"", edad,*/ salud, velocidad, destreza, fuerza, nivel, armadura);
            case "Elfo":
                return new Elfo(nombre, apodo, /*"", edad,*/ salud, velocidad, destreza, fuerza, nivel, armadura);
            case "Orco":
                return new Orco(nombre, apodo, /*"", edad,*/ salud, velocidad, destreza, fuerza, nivel, armadura);
            default:
                return null;
        }
    }

}
