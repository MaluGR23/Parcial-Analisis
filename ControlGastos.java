import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ControlGastos {
    private List<Gasto> listaGastos;

    public ControlGastos() {
        listaGastos = new ArrayList<>();
    }

    public void agregarGasto(Gasto gasto) {
        listaGastos.add(gasto);
    }

    public List<Gasto> visualizarGastosPorFecha(Date fecha) {
        return listaGastos.stream()
                .filter(gasto -> gasto.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public void mostrarGastosPorFecha(Date fecha) {
        List<Gasto> gastosPorFecha = visualizarGastosPorFecha(fecha);
        if (gastosPorFecha.isEmpty()) {
            System.out.println("No hay gastos registrados para la fecha: " + fecha);
        } else {
            System.out.println("Gastos para la fecha " + fecha + ":");
            gastosPorFecha.forEach(System.out::println);
        }
    }
}
