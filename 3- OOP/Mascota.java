package prog2.tp3oop;

public class Mascota {
    String nombre;
    String especie;
    int edad;

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void mostrarInfo() {
        System.out.println("Mascota: " + nombre + ", Especie: " + especie + ", Edad: " + edad);
    }

    public void cumplirAnios() {
        edad++;
    }
}