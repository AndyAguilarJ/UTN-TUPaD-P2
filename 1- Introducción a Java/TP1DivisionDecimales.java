package prog2.tp1divisiondecimales;

import java.util.Scanner;
public class TP1DivisionDecimales {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();
        
        if (num2 != 0) {
            double resultado = num1 / num2;
            System.out.printf("El resultado es: %.2f%n", resultado);
        } else {
            System.out.println("Error: No se puede dividir entre cero");
        }
        
        scanner.close();
    }
}