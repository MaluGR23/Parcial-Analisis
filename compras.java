import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Articulo {
	private String nombre;
	private int cantidad;
	private boolean comprado;

	public Articulo(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.comprado = false;
	}

	public void filtrarComprados() {

		this.comprado = true;
	}

	public boolean isComprado() {
		return comprado;
	}

	@Override
	public String toString() {
		return nombre + " (Cantidad: " + cantidad + ")";
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCantidad(int nuevaCantidad) {
		// TODO Auto-generated method stub
		
	}
}

class listaCompras {
	private List<Articulo> listaCompras = new ArrayList<>();

	public void eliminarArticulos ( int index) { 
		if (index >= 0 && index < listaCompras.size()) {
			listaCompras.remove(index);
		}
		else{ 
			System.out.println("Error: índice fuera de rango, artículo no encontrado.");
		}
    }
	
	public void filtrarArticulosComprados(String nombre) {
		
		for (Articulo articulo : listaCompras) {
			if(articulo.toString().contains(nombre)) {
				
				articulo.filtrarComprados();
				System.out.println("Articulo filtrado por comprado: " + articulo);
				return;
			}
		}
  }
  
	public List<Articulo> filtrarArticulosPendientes () { 
		List<Articulo> listaDeArticulosPendientes = new List<>() ;
		for( Articulo articulo : listaCompras ) {
			if ( articulo.isComprado() != true ){ 
				listaDeArticulosPendientes.add(articulo); 
			}
		}
		return listaDeArticulosPendientes;
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
        System.out.println("Error al formatear la cantidad: "+e.getMessage());
    }
}

	public void ordenarArticulosAlfabeticamente ( List<Articulo> articulos){
		Collections.sort(articulos);
	}
	
	public void contarArticulos() {
		int totalArticulos = listaCompras.size();
		System.out.println("Número total de artículos: " + totalArticulos);
		}
		public Articulo buscarArticulos(String nombreArticulo){
			for(Articulo art :  listaCompras){
				String[] nombre = art.toString().split(" ");
				if(nombre[0].equalsIgnoreCase(nombreArticulo)){
					return art;
			}
		}
		return null;
	}
}

public class Main {
public static void main(String[] args) {
    listaCompras lista = new listaCompras();
    lista.agregarArticulo("Manzanas", 4);
    lista.agregarArticulo("Pan", 1);
    lista.cargarDesdeArchivo("listaCompras.txt");
    lista.mostrarLista();
	Articulo.ordenarArticulosAlfabeticamente(listaCompras);
}
}

public class ListaDeCompras {
    private List<Articulo> articulos;

    public ListaDeCompras() {
        this.articulos = new ArrayList<>();
    }

    // Método para agregar un artículo a la lista
    public void agregarArticulo(String nombre) {
        articulos.add(new Articulo(nombre));
    }

    // Método para marcar un artículo como comprado por su nombre
    public boolean marcarArticuloComoComprado(String nombre) {
        for (Articulo articulo : articulos) {
            if (articulo.getNombre().equalsIgnoreCase(nombre)) {
                articulo.setComprado(true);
                System.out.println("Artículo '" + nombre + "' ha sido marcado como comprado.");
                return true;
            }
        }
        System.out.println("Artículo '" + nombre + "' no encontrado en la lista.");
        return false;
    }

    // Método para mostrar el estado de todos los artículos en la lista
    public void mostrarArticulos() {
        for (Articulo articulo : articulos) {
            System.out.println("- " + articulo.getNombre() + " (Comprado: " + articulo.isComprado() + ")");
        }
    }

	class Articulo {
    private String nombre;
    private boolean comprado;

    public Articulo(String nombre) {
        this.nombre = nombre;
        this.comprado = false; // Por defecto, el artículo no está comprado
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}

public class ListaDeCompras {
    private List<Articulo> articulos;

    public ListaDeCompras() {
        this.articulos = new ArrayList<>();
    }

    // Método para agregar un artículo a la lista
    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    // Método para mostrar los artículos en la lista
    public void mostrarArticulos() {
        if (articulos.isEmpty()) {
            System.out.println("La lista de compras está vacía.");
        } else {
            System.out.println("Artículos en la lista de compras:");
            for (Articulo articulo : articulos) {
                System.out.println("- " + articulo.getNombre() + " (Cantidad: " + articulo.getCantidad() + ")");
            }
        }
    }

    // Método para limpiar la lista de compras
    public void limpiarLista() {
        articulos.clear();
        System.out.println("La lista de compras ha sido limpiada. Todos los artículos han sido eliminados.");
    }

class Articulo {
    private String nombre;
    private int cantidad;

    public Articulo(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
}