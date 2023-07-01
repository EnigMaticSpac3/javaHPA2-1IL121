/*
 * Jorge González
 * 8-1002-2167
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Cuadrado obj = new Cuadrado();

        // Variables de trabajo
        int i, num   = 0;
        int nume[]   = new int[15];
        int eleva[]  = new int[15];
        boolean bien = true;

        // cargar vector con input de usuario
        for (i = 0; i < nume.length;) {
            do {
                try {
                    bien = true;
                    System.out.print(String.format("Numero [%d]: ", i+1));
                    num = Integer.parseInt(leer.readLine());
                } catch (IOException e) {
                    System.out.println("Hubo un error. Intente otra vez.");
                    bien = false;
                } catch (NumberFormatException er) {
                    System.out.println("El numero ingresado no es valido. Ingrese nuevamente");
                    bien = false;
                }
            } while (!bien);
            // asignar numero al objeto y cargarlo en el arreglo
            obj.asignar(num);
            obj.cargar(nume, i);

            // elevar al cuadrado el valor ingresado
            obj.elevarCuadrado(eleva, i);

            i++;
        }

        // Imprimir el vector nume[]
        System.out.println("Vector nume[]:");
        for (i = 0; i < nume.length; i++) {
            System.out.print(" " + nume[i]);
        }
        System.out.println("\n________________________");
        // Imprimir el vector eleva[]
        System.out.println("Vector eleva[]:");
        for (i = 0; i < eleva.length; i++) {
            System.out.print(" " + eleva[i]);
        }

    }
}