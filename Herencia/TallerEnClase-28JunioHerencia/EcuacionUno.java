public class EcuacionUno extends Ecuacion {
    private int z, n;

    public void asignar(int z, int n) {
        this.z = z;
        this.n = n;
    }

    public double calcularY() {
        return calcularX() + Math.pow(z, n)/**/;
    }

    public int getZ() {
        return z;
    }

    public int getN() {
        return n;
    }
}
