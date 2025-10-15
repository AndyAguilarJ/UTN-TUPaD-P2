package prog2.tp_5;

class UsuarioQR {
    private String nombre;
    private String email;

    public UsuarioQR(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}

class CodigoQR {
    private String valor;
    private UsuarioQR usuario;

    public CodigoQR(String valor, UsuarioQR usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }
}

class GeneradorQR {
    public void generar(String valor, UsuarioQR usuario) {
        CodigoQR codigo = new CodigoQR(valor, usuario);
        System.out.println("QR generado: " + valor);
    }
}

public class punto_13 {
    
}
