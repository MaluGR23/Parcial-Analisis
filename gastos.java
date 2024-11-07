import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//objeto
class gasto {
    private String descripcion;
    private double monto;
    private String categoria;
    private String metodoPago;

    public gasto(String descripcion, double monto, String categoria, String metodoPago) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.categoria = categoria;
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return descripcion + " - " + monto + " (" + categoria + ", Pago: " + metodoPago + ")";
    }
}

//métodos
class controlGastos {
	
    private List<gasto> listaDegastos = new ArrayList<>();
    private double presupuesto;

    public void agregargasto(String descripcion, double monto, String categoria, String metodoPago) {
        gasto nuevogasto = new gasto(descripcion, monto, categoria, metodoPago);
        listaDegastos.add(nuevogasto);
        System.out.println("gasto agregado: " + nuevogasto);
    }
    public void eliminarGasto(gasto gasto){
        listaDegastos.remove(gasto);
    }

    public void mostrargastos() {
        System.out.println("Lista de gastos:");
        for (gasto gasto : listaDegastos) {
            System.out.println("- " + gasto);
        }
    }
    
    public ArrayList<gasto> buscarporpalabraclave(String palabra) {
        ArrayList<gasto> gast = new ArrayList<>();
        for(gasto gasto:listaDegastos) {
            String[] gastosplit = gasto.toString().split(" - ");
            if(gastosplit[0].contains(palabra)) {
                gast.add(gasto);
            }
        }
        
    return gast;
    
    }
    public ArrayList<gasto> gastosPorCategoria(String categoria){
        ArrayList<gasto> gastosfiltrados = new ArrayList<>();
        for(gasto gasto: listaDegastos) {
            String[] tempString1 = gasto.toString().split("\\(");
            String tempString2 = tempString1[1].split(",")[0].trim();
            if(tempString2.equals(categoria)) {
            	gastosfiltrados.add(gasto);
            }
        }
        return gastosfiltrados;
    }
    public void establecerPresupuesto(double nuevoPresupuesto) {
        if (nuevoPresupuesto >= 0) {
            this.presupuesto = nuevoPresupuesto;
            System.out.println("Presupuesto mensual actualizado a: $" + nuevoPresupuesto);
        } else {
            System.out.println("El presupuesto no puede ser negativo.");
        }
    }
    public String notificacionPresupuesto(){

        return ("El presupuesto disponible es: " +presupuesto);


    }
    public void cargarGastosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    String descripcion = datos[0];
                    double monto = Double.parseDouble(datos[1]);
                    String categoria = datos[2];
                    String metodoPago = datos[3];

                    agregargasto(descripcion, monto, categoria, metodoPago);
                } else {
                    System.out.println("Línea en formato incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato numérico del monto: " + e.getMessage());
        }
    }
    
    public void guardarGastosEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (gasto g : listaDegastos) {
                writer.write(g.toString());
                writer.newLine();  
            }
            System.out.println("Gastos guardados exitosamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los gastos en el archivo: " + e.getMessage());
        }
    }
    //imprime la lista de gastos
    public void listarGastos (){


        int numeral = 1;

        for(gasto gasto: listaDegastos){
            System.out.println(numeral+". "+gasto);
            numeral++;
        }

    }
    public void calcularTotalGastos() {
        ArrayList<Double> gastos = new ArrayList<>();
        double totalGastos = 0; 
        for (double gastosRealizados : gastos) {
            totalGastos += gastosRealizados;
        }
    }
    

}
    
    
    




    public static void main(String[] args) {
        controlGastos control = new controlGastos();
        control.agregargasto("Cena", 25.50, "Comida", "Tarjeta");
        control.agregargasto("Transporte", 10.00, "Transporte", "Efectivo");
        control.listarGastos();


    }
}

class Gasto {
    private int id;
    private double monto;
    private String descripcion;
    private String categoria;
    private Date fecha;

    public Gasto(int id, double monto, String descripcion, String categoria, Date fecha) {
        this.id = id;
        this.monto = monto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void mostrarGasto() {
        System.out.println("ID: " + id);
        System.out.println("Monto: $" + monto);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Categoría: " + categoria);
        System.out.println("Fecha: " + fecha);
    }
}

class ControlDeGastos {
    private List<Gasto> gastos;

    public ControlDeGastos() {
        this.gastos = new ArrayList<>();
    }

    public void agregarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public Gasto buscarGastoPorId(int id) {
        for (Gasto gasto : gastos) {
            if (gasto.getId() == id) {
                return gasto;
            }
        }
        return null;
    }

    public void editarGasto(int id) {
        Gasto gasto = buscarGastoPorId(id);
        if (gasto != null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Editando el gasto con ID: " + id);
            gasto.mostrarGasto();

            System.out.print("Ingrese el nuevo monto (actual: $" + gasto.getMonto() + "): ");
            double nuevoMonto = scanner.nextDouble();
            gasto.setMonto(nuevoMonto);

            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.print("Ingrese la nueva descripción (actual: " + gasto.getDescripcion() + "): ");
            String nuevaDescripcion = scanner.nextLine();
            gasto.setDescripcion(newDescripcion);

            System.out.print("Ingrese la nueva categoría (actual: " + gasto.getCategoria() + "): ");
            String nuevaCategoria = scanner.nextLine();
            gasto.setCategoria(newCategoria);

            System.out.println("Gasto actualizado exitosamente.");
            gasto.mostrarGasto();
        } else {
            System.out.println("No se encontró gasto con el ID proporcionado.");
        }
    }
}
