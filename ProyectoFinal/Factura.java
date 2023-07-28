public class Factura {
    private String nombreCliente;
    private String fechaFactura;
    private int numeroFactura;
    private double totalFactura;
    private String[] productos;
    private double[] precios;
    private int[] cantidades;

    public void asignar(String nombreCliente, String fechaFactura, int numeroFactura, double totalFactura,
            String[] productos, double[] precios, int[] cantidades) {
        this.nombreCliente = nombreCliente;
        this.fechaFactura = fechaFactura;
        this.numeroFactura = numeroFactura;
        this.totalFactura = totalFactura;
        this.productos = productos;
        this.precios = precios;
        this.cantidades = cantidades;
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

    public String[] getProductos() {
        return productos;
    }

    public double[] getPrecios() {
        return precios;
    }

    public int[] getCantidades() {
        return cantidades;
    }
}