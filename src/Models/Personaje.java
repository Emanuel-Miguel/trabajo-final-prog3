package Models;

public abstract class Personaje {
    // Atributos
    private String nombre;
    private String apodo;
    //private String fechaNacimiento;
    //private Integer edad;
    private Double salud;
    private Integer velocidad;
    private Integer destreza;
    private Integer fuerza;
    private Integer nivel;
    private Double armadura;

    // Constructor
    public Personaje(String nombre, String apodo, /*String fechaNacimiento, Integer edad,*/ Double salud, Integer velocidad, Integer destreza, Integer fuerza, Integer nivel, Double armadura) {
        this.nombre = nombre;
        this.apodo = apodo;
        //this.fechaNacimiento = fechaNacimiento;
        //this.edad = edad;
        this.salud = salud;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.armadura = armadura;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
/*
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
*/
    public Double getSalud() {
        return salud;
    }

    public void setSalud(Double salud) {
        this.salud = salud;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getDestreza() {
        return destreza;
    }

    public void setDestreza(Integer destreza) {
        this.destreza = destreza;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Double getArmadura() {
        return armadura;
    }

    public void setArmadura(Double armadura) {
        this.armadura = armadura;
    }

    public abstract Double calcularAtaque (Double velocidadDefensor, Double armaduraDefensor);

    public void mejorarHabilidades() {
        // Aumentar la salud en 25000
        this.salud += 25000.0;
    }
}
