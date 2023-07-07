public class Congelados extends Producto {
    private double tempR;

    public void asignar(double tempR) {
        this.tempR = tempR;
    }

    public double calcularCostoProd(int cantProd) {
        return cantProd * 50;
    }

    public double getTempR() {
        return this.tempR;
    }
}
