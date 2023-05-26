public class CalculoCajas {
    private int cajasGrandes;
    private int cajasMedianas;
    private int cajasPequenas;

    public CalculoCajas(int cajasGrandes, int cajasMedianas, int cajasPequenas) {
        this.cajasGrandes = cajasGrandes;
        this.cajasMedianas = cajasMedianas;
        this.cajasPequenas = cajasPequenas;
    }

    public double calcularCostoTotal() {
        return cajasGrandes * 2.0 + cajasMedianas * 1.0 + cajasPequenas * 0.5;
    }

    public int getCajasGrandes() {
        return cajasGrandes;
    }

    public int getCajasMedianas() {
        return cajasMedianas;
    }

    public int getCajasPequenas() {
        return cajasPequenas;
    }
}
