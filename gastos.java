import java.util.ArrayList;
import java.util.List;

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

class controlGastos {
    private List<gasto> listaDegastos = new ArrayList<>();

    public void agregargasto(String descripcion, double monto, String categoria, String metodoPago) {
        gasto nuevogasto = new gasto(descripcion, monto, categoria, metodoPago);
        listaDegastos.add(nuevogasto);
        System.out.println("gasto agregado: " + nuevogasto);
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

    public void eliminarGasto(gasto gasto){
        gastos.remove(gasto);
    }
}

public class Maingastos {
    public static void main(String[] args) {
        controlGastos control = new controlGastos();
        control.agregargasto("Cena", 25.50, "Comida", "Tarjeta");
        control.agregargasto("Transporte", 10.00, "Transporte", "Efectivo");
        control.mostrargastos();
    }
}

    
public void calcularTotalGastos() {
    ArrayList<Double> gastos = new ArrayList<>();
    double totalGastos = 0; 
    for (double gastosRealizados : gastos) {
        totalGastos += gastosRealizados;
    }
}




