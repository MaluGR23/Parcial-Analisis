import java.util.ArrayList;
import java.util.List;

class informacionDiarioContenido {
    private String contenido;
    private ArrayList<String> Etiquetas;

    public informacionDiarioContenido(String contenido) {
        this.contenido = contenido;
    }
    public ArrayList<String> getEtiquetas() {
        return Etiquetas;
    }

    @Override
    public String toString() {
        return contenido;
    }
}

class informacionDiarioFecha {
    private String fecha;

    public informacionDiarioFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return fecha;
    }
}

class diarioPersonal {
    private List<informacionDiarioContenido> diarioContenido = new ArrayList<>();
    private List<informacionDiarioFecha> diarioFecha = new ArrayList<>();

    public int contarLasEntradas(){
        int tamaño = diarioContenido.size() ;
        System.out.println (tamaño) ;
        return tamaño ;
    }

    public void agregarEntradaContenido(String contenido) {
        informacionDiarioContenido nuevaEntrada = new informacionDiarioContenido(contenido);
        diarioContenido.add(nuevaEntrada);
        System.out.println("Entrada agregada: " + nuevaEntrada);
    }

    public void agregarEntradaFecha(String fecha) {
        informacionDiarioFecha nuevaEntrada = new informacionDiarioFecha(fecha);
        diarioFecha.add(nuevaEntrada);
        System.out.println("Entrada agregada: " + nuevaEntrada);
    }

    public void mostrarDiario() {
        System.out.println("Entradas del Diario:");
        for (informacionDiarioFecha entradaFechas : diarioFecha) {
            for (informacionDiarioContenido entradaContenidos : diarioContenido) {
                System.out.println("- " + entradaContenidos);
            }
        for (informacionDiarioFecha entradaPorFecha : diarioFecha) {
            for (informacionDiarioContenido entradaPorContenido : diarioContenido) {
                System.out.println("- " + entradaPorFecha + entradaPorContenido);
            }
        for (informacionDiarioFecha entrada : diarioFecha) {
            System.out.println("- " + entrada);
        }
    }

    public void mostrarUltimasEntradas(int cantidad) {
        System.out.println("Ultimas " + cantidad + " entradas:");
        int inicio = Math.max(diario.size() - cantidad, 0);

        for (int i = diario.size() - 1; i >= inicio; i--) {

        for (int i = diario.size() - 1; i >= inicio; i--) { 

            System.out.println("- " + diario.get(i));

        }
    }
     public void buscarPorPalabraClave(String palabraClave) {
        System.out.println("Entradas que contienen la palabra clave \"" + palabraClave + "\":");
        boolean encontrado = false;

        for (informacionDiarioContenido entrada : diarioContenido) {
            if (entrada.getContenido().toLowerCase().contains(palabraClave.toLowerCase())) {
                System.out.println("- " + entrada);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron entradas con la palabra clave.");
        }
    }
    public void verEntradasPorEtiqueta(String etiqueta){
        for(informacionDiarioContenido entrada: diarioContenido){
            if(entrada.getEtiquetas().contains(etiqueta)){
                System.out.println("- " + entrada.toString());
            }
        }
    }
    public List<informacionDiarioContenido> FiltrarEntradasPorPlabrasClave(String palabraClave) {
        List<informacionDiarioContenido> palabrasClave = new List<>();
        for (informacionDiarioContenido informacion : diarioContenido) {
            String[] array = informacion.toString().split(": ");
            if (array[1].contains(palabraClave))
                palabrasClave.add(informacion);
        }
        return palabrasClave;
    }
}

public class diario {
    public static void main(String[] args) {
        diarioPersonal diario = new diarioPersonal();
        diario.agregarEntradaFecha("2024-10-31");
        diario.agregarEntradaContenido("Estudie programacion en Java.");

        diario.agregarEntradaContenido("Hoy fue un buen dia.");
        diario.agregarEntradaFecha("2024-11-01");
         diario.buscarPorPalabraClave("Java");
        diario.mostrarDiario();
    }
}

public class Diario {
    private List<String> entradas;
    
    public Diario() {
        this.entradas = new ArrayList<>();
    }

    public void agregarEntrada(String entrada) {
        entradas.add(entrada);
    }

    public void limpiarDiario() {
        entradas.clear();
        System.out.println("El diario ha sido limpiado. Todas las entradas han sido eliminadas.");
    }

    class Entrada {
    private String titulo;
    private String contenido;
    private String fecha;

    public Entrada(String titulo, String contenido, String fecha) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public String toTexto() {
        return "Fecha: " + fecha + "\nTítulo: " + titulo + "\nContenido: " + contenido + "\n";
    }
}

class Diario {
    private List<Entrada> entradas;

    public Diario() {
        this.entradas = new ArrayList<>();
    }

    public void agregarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public void guardarEntradasEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Entrada entrada : entradas) {
                writer.write(entrada.toTexto());
                writer.write("\n-----------------------\n");
            }
            System.out.println("Entradas guardadas exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar las entradas en el archivo: " + e.getMessage());
        }
    }

    public void eliminarEntrada(int indice) {
        if (indice >= 0 && indice < diarioFecha.size() && indice < diarioContenido.size()) {
            System.out.println("Eliminando entrada: Fecha: " + diarioFecha.get(indice) + ", Contenido: " + diarioContenido.get(indice));
            diarioFecha.remove(indice);
            diarioContenido.remove(indice);
            System.out.println("Entrada eliminada con éxito.");
        } else {
            System.out.println("Índice fuera de rango. No se puede eliminar la entrada.");
        }
    }
}