package Programa1;
// APLICACIÓN DE CONSTRUCTORES 
public class Operaciones {

    private int a, b;
    private double c;

    public void asignar(int a, int b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() { return a; }
    public int getB() { return b; }
    public double getC() { return c; }

    public double calcularE() {
        return Math.sqrt(a+b+c);
    }

    //CONSTRUCTORES
    public Operaciones() {  // Constructor 1
        a = 10; b=5; c=2.00;
    }
    public Operaciones(int a1, int b1, double c1) { // Constructor 2
        a = a1; b=b1; c=c1;
    }

    // error
    // public operaciones() {
    //     a =4;
    // }
}
