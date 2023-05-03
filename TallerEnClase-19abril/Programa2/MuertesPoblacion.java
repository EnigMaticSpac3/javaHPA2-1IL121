public class MuertesPoblacion {
    private int cant;

    public void asignar(int cant) {
        this.cant = cant;
    }

    public int getCant() { return cant; }

    public double calcularM() {
        return cant * 0.4;
    }
}