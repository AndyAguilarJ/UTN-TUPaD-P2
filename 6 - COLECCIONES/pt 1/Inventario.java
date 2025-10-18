package prog2.tp_6;
import java.util.*;

public class Inventario {
    private final ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void listarProductos() {
        productos.forEach(Producto::mostrarInfo);
    }

    public Producto buscarProductoPorId(String id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public void eliminarProducto(String id) {
        productos.removeIf(p -> p.getId().equals(id));
    }

    public void actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) p.setCantidad(nuevaCantidad);
    }

    public void filtrarPorCategoria(CategoriaProducto categoria) {
        productos.stream().filter(p -> p.getCategoria() == categoria).forEach(Producto::mostrarInfo);
    }

    public int obtenerTotalStock() {
        return productos.stream().mapToInt(Producto::getCantidad).sum();
    }

    public Producto obtenerProductoConMayorStock() {
        return productos.stream().max(Comparator.comparingInt(Producto::getCantidad)).orElse(null);
    }

    public void filtrarProductosPorPrecio(double min, double max) {
        productos.stream()
                .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                .forEach(Producto::mostrarInfo);
    }

    public void mostrarCategoriasDisponibles() {
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.println(c + ": " + c.getDescripcion());
        }
    }
}
