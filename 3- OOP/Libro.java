package prog2.tp3oop;

public class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;

    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        setAñoPublicacion(añoPublicacion);
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAñoPublicacion() { return añoPublicacion; }

    public void setAñoPublicacion(int añoPublicacion) {
        if (añoPublicacion > 0 && añoPublicacion <= 2025) {
            this.añoPublicacion = añoPublicacion;
        } else {
            System.out.println("❌ Año de publicación inválido: " + añoPublicacion);
        }
    }

    public void mostrarInfo() {
        System.out.println("Libro: " + titulo + " de " + autor + " (" + añoPublicacion + ")");
    }
}