package prog2.tp2programacion;
import java.util.Scanner;

public class Tp2programacion
{
    
    static Scanner sc = new Scanner(System.in);
    static double descuentoGlobal = 0.10; // para el ejercicio 11

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== MENÚ DE EJERCICIOS =====");
            System.out.println("1. Verificación de Año Bisiesto");
            System.out.println("2. Determinar el Mayor de Tres Números");
            System.out.println("3. Clasificación de Edad");
            System.out.println("4. Calculadora de Descuento según categoría");
            System.out.println("5. Suma de Números Pares (while)");
            System.out.println("6. Contador de Positivos, Negativos y Ceros (for)");
            System.out.println("7. Validación de Nota (do-while)");
            System.out.println("8. Cálculo del Precio Final con impuesto y descuento");
            System.out.println("9. Composición de funciones para costo de envío");
            System.out.println("10. Actualización de stock");
            System.out.println("11. Cálculo de descuento especial");
            System.out.println("12. Modificación de un array de precios");
            System.out.println("13. Impresión recursiva de arrays");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                case 6 -> ejercicio6();
                case 7 -> ejercicio7();
                case 8 -> ejercicio8();
                case 9 -> ejercicio9();
                case 10 -> ejercicio10();
                case 11 -> ejercicio11();
                case 12 -> ejercicio12();
                case 13 -> ejercicio13();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // 1. Año bisiesto
    static void ejercicio1() {
        System.out.print("Ingrese un año: ");
        int año = sc.nextInt();
        boolean bisiesto = (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
        System.out.println("El año " + año + (bisiesto ? " es bisiesto." : " no es bisiesto."));
    }

    // 2. Mayor de tres números
    static void ejercicio2() {
        System.out.print("Ingrese el primer número: ");
        int n1 = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int n2 = sc.nextInt();
        System.out.print("Ingrese el tercer número: ");
        int n3 = sc.nextInt();
        int mayor = Math.max(n1, Math.max(n2, n3));
        System.out.println("El mayor es: " + mayor);
    }

    // 3. Clasificación de edad
    static void ejercicio3() {
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();
        if (edad < 12) System.out.println("Eres un Niño.");
        else if (edad < 18) System.out.println("Eres un Adolescente.");
        else if (edad < 60) System.out.println("Eres un Adulto.");
        else System.out.println("Eres un Adulto mayor.");
    }

    // 4. Descuento según categoría
    static void ejercicio4() {
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        char cat = sc.next().toUpperCase().charAt(0);
        double desc = switch (cat) {
            case 'A' -> 0.10;
            case 'B' -> 0.15;
            case 'C' -> 0.20;
            default -> 0.0;
        };
        double precioFinal = precio - (precio * desc);
        System.out.println("Descuento aplicado: " + (desc * 100) + "%");
        System.out.println("Precio final: " + precioFinal);
    }

    // 5. Suma de pares con while
    static void ejercicio5() {
        int suma = 0, num;
        do {
            System.out.print("Ingrese un número (0 para terminar): ");
            num = sc.nextInt();
            if (num % 2 == 0) suma += num;
        } while (num != 0);
        System.out.println("La suma de los números pares es: " + suma);
    }

    // 6. Contador de positivos, negativos y ceros
    static void ejercicio6() {
        int pos = 0, neg = 0, ceros = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int n = sc.nextInt();
            if (n > 0) pos++;
            else if (n < 0) neg++;
            else ceros++;
        }
        System.out.println("Positivos: " + pos + "\nNegativos: " + neg + "\nCeros: " + ceros);
    }

    // 7. Validación de nota con do-while
    static void ejercicio7() {
        int nota;
        do {
            System.out.print("Ingrese una nota (0-10): ");
            nota = sc.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota inválida.");
            }
        } while (nota < 0 || nota > 10);
        System.out.println("Nota guardada correctamente.");
    }

    // 8. Precio final con impuesto y descuento
    static void ejercicio8() {
        System.out.print("Ingrese el precio base del producto: ");
        double base = sc.nextDouble();
        System.out.print("Ingrese el impuesto en %: ");
        double imp = sc.nextDouble() / 100;
        System.out.print("Ingrese el descuento en %: ");
        double desc = sc.nextDouble() / 100;
        double precioFinal = base + (base * imp) - (base * desc);
        System.out.println("El precio final es: " + precioFinal);
    }

    // 9. Costo envío + total compra
    static void ejercicio9() {
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese el peso del paquete (kg): ");
        double peso = sc.nextDouble();
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = sc.next();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        double total = calcularTotalCompra(precio, costoEnvio);
        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + total);
    }

    static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) return peso * 5;
        else return peso * 10;
    }

    static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    // 10. Actualización de stock
    static void ejercicio10() {
        System.out.print("Ingrese el stock actual: ");
        int stock = sc.nextInt();
        System.out.print("Ingrese la cantidad vendida: ");
        int vendida = sc.nextInt();
        System.out.print("Ingrese la cantidad recibida: ");
        int recibida = sc.nextInt();
        int nuevoStock = stock - vendida + recibida;
        System.out.println("El nuevo stock es: " + nuevoStock);
    }

    // 11. Descuento especial (global)
    static void ejercicio11() {
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        double descuentoAplicado = precio * descuentoGlobal;
        double precioFinal = precio - descuentoAplicado;
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    // 12. Arrays
    static void ejercicio12() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        for (double p : precios) System.out.println("Precio: $" + p);
        precios[2] = 129.99; // modificamos un valor
        System.out.println("Precios modificados:");
        for (double p : precios) System.out.println("Precio: $" + p);
    }

    // 13. Arrays recursivos
    static void ejercicio13() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        imprimirArrayRecursivo(precios, 0);
        precios[2] = 129.99;
        System.out.println("Precios modificados:");
        imprimirArrayRecursivo(precios, 0);
    }

    static void imprimirArrayRecursivo(double[] arr, int i) {
        if (i < arr.length) {
            System.out.println("Precio: $" + arr[i]);
            imprimirArrayRecursivo(arr, i + 1);
        }
    }
}