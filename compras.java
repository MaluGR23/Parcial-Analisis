import java.util.ArrayList;
import java.util.List;

class Articulo {
    private String nombre;
    private int cantidad;

    public Articulo(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " (Cantidad: " + cantidad + ")";
    }

	public String getNombre() {
		
		return null;
	}

	public void setCantidad(int nuevaCantidad) {
		
		
	}
}

 class listaCompras {
    private List<Articulo> listaCompras = new ArrayList<>();

    public void agregarArticulo(String nombre, int cantidad) {
        Articulo nuevoArticulo = new Articulo(nombre, cantidad);
        listaCompras.add(nuevoArticulo);
        System.out.println("Articulo agregado: " + nuevoArticulo);
    }

    public void mostrarLista() {
        System.out.println("Lista de Compras:");
        for (Articulo articulo : listaCompras) {
            System.out.println("- " + articulo);
        }
    }
    
    

 public void editarArticulo(String nombre, int nuevaCantidad) {
     for (Articulo articulo : listaCompras) {
         if (articulo.getNombre().equalsIgnoreCase(nombre)) {
             articulo.setCantidad(nuevaCantidad);
             System.out.println("Articulo actualizado: " + articulo);
             return;
         }
     }
     System.out.println("Articulo no encontrado: " + nombre);
 }
}
    

public class Main {
    public static void main(String[] args) {
        listaCompras lista = new listaCompras();
        lista.agregarArticulo("Manzanas", 4);
        lista.agregarArticulo("Pan", 1);
        lista.mostrarLista();
    }
}
