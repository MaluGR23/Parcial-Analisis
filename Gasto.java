import java.util.Date;

public class Gasto {
    private Date fecha;
    private double monto;
    private String descripcion;

    public Gasto(Date fecha, double monto, String descripcion) {
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "fecha=" + fecha +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
