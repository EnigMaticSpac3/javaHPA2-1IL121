public class Frecuencias {
    private int [] arr;

    public void asignar(int [] arr) {
        this.arr = arr;
    }

    public void calcularFrecuencias(int[] frec) {
        int i;

        for (i = 0; i < arr.length; i++) {
            frec[arr[i] / 10]++;
        }

    }

    public int[] getArr() {
        return arr;
    }
}