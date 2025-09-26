package prog2.tp3oop;

public class Tp3oop {
    public static void main(String[] args) {
        System.out.println("===== 1. Estudiante =====");
        Estudiante e1 = new Estudiante("Ana", "Pérez", "Programación", 8.5);
        e1.mostrarInfo();
        e1.subirCalificacion(1.0);
        e1.bajarCalificacion(0.5);
        e1.mostrarInfo();

        System.out.println("\n===== 2. Mascota =====");
        Mascota m1 = new Mascota("Firulais", "Perro", 3);
        m1.mostrarInfo();
        m1.cumplirAnios();
        m1.mostrarInfo();

        System.out.println("\n===== 3. Libro =====");
        Libro l1 = new Libro("Cien Años de Soledad", "García Márquez", 1967);
        l1.setAñoPublicacion(-100); // inválido
        l1.setAñoPublicacion(1982); // válido
        l1.mostrarInfo();

        System.out.println("\n===== 4. Gallinas =====");
        Gallina g1 = new Gallina(1, 2);
        Gallina g2 = new Gallina(2, 1);
        g1.envejecer();
        g1.ponerHuevo();
        g2.ponerHuevo();
        g2.ponerHuevo();
        g1.mostrarEstado();
        g2.mostrarEstado();

        System.out.println("\n===== 5. Nave Espacial =====");
        NaveEspacial nave = new NaveEspacial("Apollo", 50);
        nave.despegar();
        nave.avanzar(30); // no alcanza
        nave.recargarCombustible(70);
        nave.avanzar(20);
        nave.mostrarEstado();
    }
}