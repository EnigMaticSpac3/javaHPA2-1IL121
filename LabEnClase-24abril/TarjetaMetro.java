public class TarjetaMetro {
    private double saldo, costoViaje;
    private int id;

    
    public void asignar(int id, double saldo, double costo) {
        this.id = id;
        this.saldo = saldo;
        this.costoViaje = costo;
    }
    
    public double calcularCosto () {
        double costo; 
        // costo = saldo - costoViaje *10;
        costo = costoViaje *10;
        return costo;
    }

    public void actualizarSaldo(double costo) {
        saldo = saldo - costo;
    }

    public int traerId() { return id; }
    public double traerSaldo() { return saldo; }
    public double costoViaje() { return costoViaje; }
}
