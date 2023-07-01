package Problema2;

public class Temperatura {
    private double[] temp;
    private int[] hora;

    public void asignar(double[] temp, int[] hora) {
        this.temp = temp;
        this.hora = hora;
    }

    public int calcularIndiceMayor() {
        int i = 0, x;
        double temporal = temp[0];
        for (x = 0; x < temp.length; x++) {
            if (temporal < temp[x]) {
                // temporal = temp[x]; no se necesita
                i = x;
            }
        }
        return i;
    }
    public int calcularIndiceMenor() {
        int i = 0, x; 
        double temporal = temp[0];
        for (x = 0; x < temp.length; x++) {
            if (temporal > temp[x]) {
                // temporal = temp[x]; no se necesita
                i = x;
            }
        }
        return i;
    }

    public double[] getTemp() {
        return temp;
    }

    public int[] getHora() {
        return hora;
    }

    
}
