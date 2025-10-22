package prog2.tp_7;

public class Katas {
    public static void main(String[] args) {
        System.out.println("=== Kata 1: Vehículos ===");
        Auto auto = new Auto("Toyota", "Corolla", 4);
        auto.mostrarInfo();

        System.out.println("\n=== Kata 2: Figuras ===");
        Figura[] figuras = { new Circulo(3.5), new Rectangulo(4, 6) };
        for (Figura f : figuras) f.mostrarArea();

        System.out.println("\n=== Kata 3: Empleados ===");
        java.util.List<Empleado> empleados = new java.util.ArrayList<>();
        empleados.add(new EmpleadoPlanta("Laura", 1200, 400));
        empleados.add(new EmpleadoTemporal("Carlos", 800, 10, 50));

        for (Empleado e : empleados) {
            e.mostrarInfo();
            if (e instanceof EmpleadoPlanta) System.out.println("→ Tipo: Empleado de Planta");
            else if (e instanceof EmpleadoTemporal) System.out.println("→ Tipo: Empleado Temporal");
            System.out.println("---------------------");
        }

        System.out.println("\n=== Kata 4: Animales ===");
        java.util.List<Animal> animales = new java.util.ArrayList<>();
        animales.add(new Perro("Firulais"));
        animales.add(new Gato("Michi"));
        animales.add(new Vaca("Lola"));

        for (Animal a : animales) {
            a.describirAnimal();
            a.hacerSonido();
            System.out.println("----------------");
        }
    }
}

// ================= Kata 1 =================
class Vehiculo {
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + " | Modelo: " + modelo);
    }
}

class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + " | Modelo: " + modelo +
                " | Puertas: " + cantidadPuertas);
    }
}

// ================= Kata 2 =================
abstract class Figura {
    protected String nombre;

    public Figura(String nombre) { this.nombre = nombre; }

    public abstract double calcularArea();

    public void mostrarArea() {
        System.out.println(nombre + " → Área: " + calcularArea());
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    private double base, altura;

    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}

// ================= Kata 3 =================
abstract class Empleado {
    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSueldo();

    public void mostrarInfo() {
        System.out.println(nombre + " | Sueldo: $" + calcularSueldo());
    }
}

class EmpleadoPlanta extends Empleado {
    private double bono;

    public EmpleadoPlanta(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    @Override
    public double calcularSueldo() {
        return salarioBase + bono;
    }
}

class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private double pagoPorDia;

    public EmpleadoTemporal(String nombre, double salarioBase, int diasTrabajados, double pagoPorDia) {
        super(nombre, salarioBase);
        this.diasTrabajados = diasTrabajados;
        this.pagoPorDia = pagoPorDia;
    }

    @Override
    public double calcularSueldo() {
        return salarioBase + (diasTrabajados * pagoPorDia);
    }
}

// ================= Kata 4 =================
class Animal {
    protected String nombre;

    public Animal(String nombre) { this.nombre = nombre; }

    public void hacerSonido() {
        System.out.println("El animal hace un sonido.");
    }

    public void describirAnimal() {
        System.out.println("Soy un animal llamado " + nombre);
    }
}

class Perro extends Animal {
    public Perro(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau guau!");
    }
}

class Gato extends Animal {
    public Gato(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau!");
    }
}

class Vaca extends Animal {
    public Vaca(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Muuu!");
    }
}
