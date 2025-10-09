package prog2.tp_4;

public class TP_4 {

    public static void main(String[] args) {
        // Crear empleados con ambos constructores
        Empleado e1 = new Empleado(1, "Carlos López", "Gerente", 2500.0);
        Empleado e2 = new Empleado("Ana Pérez", "Asistente");
        Empleado e3 = new Empleado("Luis García", "Programador");

        // Aplicar aumentos
        e1.actualizarSalario(10.0);   // 10% de aumento
        e2.actualizarSalario(200);    // Aumento fijo de $200
        e3.actualizarSalario(5.0);    // 5% de aumento

        // Mostrar información de cada empleado
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());

        // Mostrar total de empleados creados
        System.out.println(Empleado.mostrarTotalEmpleados());
    }
}
