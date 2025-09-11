package prog2.tp1programacion;

import java.util.Scanner;

public class TP1Programacion {

    public static void main(String[] args) {
        String nombre = "mauricio";
        int edad = 22;
        double height;
        height = 1.78;  
        boolean estudiante;
        estudiante = true;
        
        System.out.println(nombre);
        System.out.println(edad);
        System.out.println(height);
        System.out.print(estudiante);
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese su edad: ");
            String nombreS = scanner.nextLine();
            
            System.out.print("Ingrese su edad: ");
            int edadS = scanner.nextInt();
            
            System.out.println("\nDatos ingresados:");
            System.out.println("nombre: "  + nombreS);
            System.out.println("Edad: " + edadS);
        }
    }
}
