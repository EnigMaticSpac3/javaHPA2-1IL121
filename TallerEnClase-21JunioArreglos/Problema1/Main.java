import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Frecuencias obj = new Frecuencias();
        int num[] = new int[80];
        int frec[] = new int[10];
        int i;

        for (i = 0; i < num.length; i++) {
            num[i] = random.nextInt(99) + 0;
        }

        // asginamos el arreglo
        obj.asignar(num);
        // calculamos las frecuencias y las guardamos en otro arreglo
        obj.calcularFrecuencias(frec);

        // Imprimimos la tabla de frecuencias
        for (i = 0; i < frec.length; i++) {
            System.out.println("[" + (i * 10) + "-" + ((i * 10) + 9) + "]:\t" + "*".repeat(frec[i]) + "\t(" + frec[i] + ")");
        }

        
    }
}