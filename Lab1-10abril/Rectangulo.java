public class Rectangulo {

    private double largo, ancho;

    public void asignarLyA(double l, double a) {
        largo = l;
        ancho = a;
    }

    public double getLargo() { return largo; }
    public double getAncho() { return ancho; }

    // Calculamos el area
    public double calcularArea() {
        return largo * ancho;
    }

}