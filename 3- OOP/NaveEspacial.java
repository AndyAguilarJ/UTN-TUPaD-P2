package prog2.tp3oop;

public class NaveEspacial {
    String nombre;
    int combustible;
    final int MAX_COMBUSTIBLE = 100;

    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
    }

    public void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado 🚀");
        } else {
            System.out.println("❌ No hay suficiente combustible para despegar");
        }
    }

    public void avanzar(int distancia) {
        int consumo = distancia * 2;
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println(nombre + " avanzó " + distancia + " unidades");
        } else {
            System.out.println("❌ No hay suficiente combustible para avanzar");
        }
    }

    public void recargarCombustible(int cantidad) {
        if (combustible + cantidad > MAX_COMBUSTIBLE) {
            combustible = MAX_COMBUSTIBLE;
            System.out.println("⚠️ Tanque lleno, no se puede sobrepasar el límite");
        } else {
            combustible += cantidad;
        }
    }

    public void mostrarEstado() {
        System.out.println("Nave: " + nombre + " - Combustible: " + combustible);
    }
}
