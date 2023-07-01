public class Ecuacion {
    private int a, b, c;

    public void asignar(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcularX() {
        return a*b- (double) 2/c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}