package prog2.tp1oparitmetica;

import java.util.Scanner;

public class TP1OpAritmetica {

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar los dos números
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();
            // Realizar operaciones y mostrar resultados
            System.out.println("\nResultados:");
            System.out.printf("%.2f + %.2f = %.2f%n", num1, num2, num1 + num2);
            System.out.printf("%.2f - %.2f = %.2f%n", num1, num2, num1 - num2);
            System.out.printf("%.2f * %.2f = %.2f%n", num1, num2, num1 * num2);
            // Validar división por cero
            if (num2 != 0) {
                System.out.printf("%.2f / %.2f = %.2f%n", num1, num2, num1 / num2);
            } else {
                System.out.println("Error: No se puede dividir entre cero");
            }
            // Cerrar el Scanner
        }
    }
}
