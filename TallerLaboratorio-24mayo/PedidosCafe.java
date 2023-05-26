public class PedidosCafe {
    private String tipoCafe;
    private int nBolsas;

    public String getTipoCafe() { return tipoCafe; }
    public int getNBolsas() { return nBolsas; }

    public void asignar(String tipoCafe, int nBolsas) {
        this.nBolsas = nBolsas;
        this.tipoCafe = tipoCafe;
    }

    // Costo x Bolsas
    public double calcularCostoBolsas() {
        return 2;
    }

    

    public double calcularTotal() {
        return 2;
    }


}
