package prog2.tp_5;

class UsuarioD {
    private String nombre;
    private String email;

    public UsuarioD(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}

class FirmaDigital {
    private String codigoHash;
    private String fecha;
    private UsuarioD usuario;

    public FirmaDigital(String codigoHash, String fecha, UsuarioD usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario;
    }
}

class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firma;

    public Documento(String titulo, String contenido, String codigoHash, String fecha, UsuarioD usuario) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firma = new FirmaDigital(codigoHash, fecha, usuario);
    }
}

public class punto_8 {
    
}
