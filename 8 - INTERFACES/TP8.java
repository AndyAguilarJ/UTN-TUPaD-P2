
package prog2.tp7;

import java.io.*;
import java.util.*;

// ======================== PARTE 1: Interfaces en E-commerce ========================
public class TP8 {
    public static void main(String[] args) {
        System.out.println("=== PARTE 1: SISTEMA DE E-COMMERCE ===");

        // Crear productos
        Producto p1 = new Producto("Laptop", 1500.0);
        Producto p2 = new Producto("Mouse", 25.0);
        Producto p3 = new Producto("Teclado", 50.0);

        // Crear pedido y agregar productos
        Pedido pedido = new Pedido();
        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);
        pedido.agregarProducto(p3);

        // Crear cliente y asociarlo al pedido
        Cliente cliente = new Cliente("Juan Pérez", "juan@mail.com");
        pedido.setCliente(cliente);

        // Cambiar estado y notificar
        pedido.cambiarEstado("Procesando");
        pedido.cambiarEstado("Enviado");

        // Mostrar total del pedido
        System.out.println("Total del pedido: $" + pedido.calcularTotal());

        // Probar pagos
        Pago tarjeta = new TarjetaCredito();
        PagoConDescuento paypal = new PayPal();

        tarjeta.procesarPago(pedido.calcularTotal());
        double totalConDescuento = paypal.aplicarDescuento(pedido.calcularTotal());
        paypal.procesarPago(totalConDescuento);

        // ======================== PARTE 2: EXCEPCIONES ========================
        System.out.println("\n=== PARTE 2: MANEJO DE EXCEPCIONES ===");

        // 1. División segura
        try {
            dividirNumeros(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero. " + e.getMessage());
        }

        // 2. Conversión de cadena a número
        try {
            convertirTextoANumero("abc");
        } catch (NumberFormatException e) {
            System.out.println("Error: El texto ingresado no es un número válido.");
        }

        // 3. Lectura de archivo inexistente
        try {
            leerArchivo("no_existe.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");
        }

        // 4. Excepción personalizada
        try {
            validarEdad(-5);
        } catch (EdadInvalidaException e) {
            System.out.println("Edad inválida: " + e.getMessage());
        }

        // 5. try-with-resources
        tryWithResourcesDemo("ejemplo.txt");
    }

    // --- Métodos de la Parte 2 ---

    // 1. División segura
    public static void dividirNumeros(int a, int b) {
        int resultado = a / b;
        System.out.println("Resultado: " + resultado);
    }

    // 2. Conversión de texto a número
    public static void convertirTextoANumero(String texto) {
        int numero = Integer.parseInt(texto);
        System.out.println("Número convertido: " + numero);
    }

    // 3. Lectura de archivo
    public static void leerArchivo(String nombreArchivo) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(nombreArchivo));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }

    // 4. Excepción personalizada
    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad debe estar entre 0 y 120 años.");
        }
        System.out.println("Edad válida: " + edad);
    }

    // 5. try-with-resources
    public static void tryWithResourcesDemo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            System.out.println("Contenido del archivo:");
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo con try-with-resources: " + e.getMessage());
        }
    }
}

// ======================== INTERFACES ========================
interface Pagable {
    double calcularTotal();
}

interface Pago {
    void procesarPago(double monto);
}

interface PagoConDescuento extends Pago {
    double aplicarDescuento(double monto);
}

interface Notificable {
    void notificarCambio(String mensaje);
}

// ======================== CLASES DE E-COMMERCE ========================
class Producto implements Pagable {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double calcularTotal() {
        return precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}

class Pedido implements Pagable {
    private List<Producto> productos = new ArrayList<>();
    private String estado;
    private Cliente cliente;

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        if (cliente != null) {
            cliente.notificarCambio("Su pedido cambió de estado a: " + estado);
        }
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) total += p.calcularTotal();
        return total;
    }
}

class Cliente implements Notificable {
    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public void notificarCambio(String mensaje) {
        System.out.println("Notificación para " + nombre + " (" + email + "): " + mensaje);
    }
}

// ======================== PAGOS ========================
class TarjetaCredito implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con Tarjeta de Crédito procesado: $" + monto);
    }
}

class PayPal implements PagoConDescuento {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago con PayPal procesado: $" + monto);
    }

    @Override
    public double aplicarDescuento(double monto) {
        double descuento = monto * 0.10;
        System.out.println("Descuento PayPal del 10% aplicado: -$" + descuento);
        return monto - descuento;
    }
}

// ======================== EXCEPCIÓN PERSONALIZADA ========================
class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}

