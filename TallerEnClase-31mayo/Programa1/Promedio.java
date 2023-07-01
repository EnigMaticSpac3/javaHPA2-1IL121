
public class Promedio {
    private int val[];


    public Promedio() { 
        val = new int[50]; 
        // almacenar en el vector
        for (int i = 0; i < val.length; i++) {
            val[i] = i+1;
        }
    }

    // public void asignar(int val[]) { this.val = val; }

    public int[] getVal() { return val; }

    public int calcularP () {
        int prom = 0;
        for (int i = 0; i < val.length; i++) {
            prom = prom + val[i];
        }
        return prom/val.length;
    }

    public int calcularM(int prom) {
        int cuenta = 0;
        for (int i = 0; i < val.length; i++)
            if (val[i] > prom) { cuenta ++; }
        
        return cuenta;
    }

    // metodo que sigue una logica para almacenar los valores mayores a promedio.
    public void listar(int tempo[], int prom) {
        int cuenta = 0;
        for (int i = 0; i < val.length; i++) {
            if (val[i] > prom) { 
                tempo[cuenta] = val[i];
                cuenta ++; 
            }
        }
    }
}
