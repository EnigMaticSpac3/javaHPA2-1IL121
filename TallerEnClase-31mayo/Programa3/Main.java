/*
 * Jorge González
 * 8-1002-2167
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Estado obj = new Estado();
        // variables de trabajo
        int i;
        char num[], noma[];
        boolean bien = true;

        // Ingresamos los datos en el arreglo num[]
        do {
            bien = true;
            System.out.println("Ingrese los 15 caracteres del vector num[]");
            for (i = 0; i < 15; i++) {
                num[i] = Keyboard.readChar();
                if (num[i] != '0' && num[i] != '1') {
                    bien = false;
                }
            }
        } while (!bien);
        // Ingresamos los datos en el arreglo noma[]

        // Imprimir vector num[]
        num = obj.getNum();
        System.out.println("Vector num[]");
        for (i = 0; i < num.length; i++) {
            System.out.print(" " + num[i]);
        }
        System.out.println("\n------------------------");
        // Imprimir vector noma[]
        noma = obj.getNoma();
        System.out.println("Vector noma[]");
        for (i = 0; i < noma.length; i++) {
            System.out.print(" " + noma[i]);
        }
        System.out.println("\n______________________");
        // Imprimir estado
        if (obj.verificarEstado()) {
            System.out.println("Son Iguales!");
        } else {
            System.out.println("Son Diferentes!");
        }
    }
}
