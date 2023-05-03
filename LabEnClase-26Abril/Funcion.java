public class Funcion {
    private double x, y;

    public void asignar(double x, double y) {
        this.x = x; 
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public double calcular() {
        return Math.sqrt(x) / (Math.pow(y, 2) - 1);
    }
}
