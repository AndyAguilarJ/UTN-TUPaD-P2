package prog2.tp_5;

class ClienteR {
    private String nombre;
    private String telefono;

    public ClienteR(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}

class Mesa {
    private int numero;
    private int capacidad;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }
}

class Reserva {
    private String fecha;
    private String hora;
    private ClienteR cliente;
    private Mesa mesa;

    public Reserva(String fecha, String hora, ClienteR cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }
}

public class punto_6 {
    
}
