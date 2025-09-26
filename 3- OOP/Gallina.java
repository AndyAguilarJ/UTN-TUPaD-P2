package prog2.tp3oop;

public class Gallina {
    int idGallina;
    int edad;
    int huevosPuestos;

    public Gallina(int idGallina, int edad) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = 0;
    }

    public void ponerHuevo() {
        huevosPuestos++;
    }

    public void envejecer() {
        edad++;
    }

    public void mostrarEstado() {
        System.out.println("Gallina " + idGallina + " - Edad: " + edad + ", Huevos: " + huevosPuestos);
    }
}