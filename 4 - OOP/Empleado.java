package prog2.tp_4;

public class Empleado {

    // Atributos privados (encapsulamiento)
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados = 0;

    // Constructor que recibe todos los atributos
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
    }

    // Constructor sobrecargado que recibe solo nombre y puesto
    public Empleado(String nombre, String puesto) {
        totalEmpleados++;
        this.id = totalEmpleados; // ID automático basado en el contador
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 1000.0; // salario por defecto
    }

    // Métodos sobrecargados actualizarSalario
    // 1. Aumenta el salario por porcentaje
    public void actualizarSalario(double porcentaje) {
        this.salario += this.salario * (porcentaje / 100);
    }

    // 2. Aumenta el salario por cantidad fija
    public void actualizarSalario(int cantidad) {
        this.salario += cantidad;
    }

    // Getters y Setters (encapsulamiento)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static int getTotalEmpleados() {
        return totalEmpleados;
    }

    // Método estático para mostrar total de empleados
    public static String mostrarTotalEmpleados() {
        return "Total de empleados creados: " + totalEmpleados;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Empleado [ID: " + id +
                ", Nombre: " + nombre +
                ", Puesto: " + puesto +
                ", Salario: $" + salario + "]";
    }
}