
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",\\s*"); 
                if (partes.length == 2) {
                    String nombre = partes[0];
                    int cantidad = Integer.parseInt(partes[1]);
                    agregarArticulo(nombre, cantidad);
                }
            }
            System.out.println("Lista cargada desde archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al formatear la cantidad: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        listaCompras lista = new listaCompras();
        lista.agregarArticulo("Manzanas", 4);
        lista.agregarArticulo("Pan", 1);
        lista.cargarDesdeArchivo("listaCompras.txt");
        lista.mostrarLista();
    }
}
