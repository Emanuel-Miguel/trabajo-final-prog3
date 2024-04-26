package Models;

import Utilities.GeneradorPersonajeAleatorio;

public class Humano extends Personaje {
    public Humano(String nombre, String apodo, /*String fechaNacimiento, Integer edad,*/ Double salud, Integer velocidad, Integer destreza, Integer fuerza, Integer nivel, Double armadura) {
        super(nombre, apodo, /*fechaNacimiento, edad,*/ salud, velocidad, destreza, fuerza, nivel, armadura);
    }

    @Override
    public Double calcularAtaque(Double velocidadDefensor, Double armaduraDefensor) {
        Integer poderDisparo = this.getDestreza() * this.getFuerza() * this.getNivel();
        Integer efectividadDisparo = GeneradorPersonajeAleatorio.generarNumAleatorio(1, 100);
        Integer valorAtaque = poderDisparo * efectividadDisparo;
        Double poderDefensa = velocidadDefensor * armaduraDefensor;
        return (((valorAtaque*efectividadDisparo)-poderDefensa)/500)*100;
    }

}