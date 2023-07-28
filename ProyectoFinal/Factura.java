public class Factura {
    private String nombreCliente;
    private String fechaFactura;
    private int numeroFactura;
    private double totalFactura;
    private double precioHuevo;
    private double precioLeche;
    private int cantidadDocenasHuevo;
    private int cantidadLitrosLeche;

    public void asignar(String nombreCliente, String fechaFactura, double totalFactura,
            double precioHuevo, double precioLeche, int cantidadDocenasHuevo, int cantidadLitrosLeche) {
        this.nombreCliente = nombreCliente;
        this.fechaFactura = fechaFactura;
        this.numeroFactura += 001;
        this.totalFactura = totalFactura;
        this.precioHuevo = precioHuevo;
        this.precioLeche = precioLeche;
        this.cantidadDocenasHuevo = cantidadDocenasHuevo;
        this.cantidadLitrosLeche = cantidadLitrosLeche;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public double getPrecioHuevo() {
        return precioHuevo;
    }

    public double getPrecioLeche() {
        return precioLeche;
    }

    public int getCantidadDocenasHuevo() {
        return cantidadDocenasHuevo;
    }

    public int getCantidadLitrosLeche() {
        return cantidadLitrosLeche;
    }

}