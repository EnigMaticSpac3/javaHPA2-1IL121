package Programa1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Arreglo obj = new Arreglo();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        // Variables
        int tamanho=0, i;
        boolean bien = true;

        do {
            bien = true;
            try {
                System.out.print("Ingrese el tamanho del arreglo: ");
                tamanho = Integer.parseInt(leer.readLine());
            } catch (IOException e) {
                System.out.println("Error");
                bien = false;
            } catch (NumberFormatException er) {
                System.out.println("El numero ingresado no es valido. Ingrese Nuevamente");
                bien = false;
            }
        } while(!bien);
        
        int arr[] = new int[tamanho];
        for (i = 0; i < tamanho;) {
            do {
                bien = true;
                try {
                    System.out.print("Ingrese el numero [" + (i+1) + "]: ");
                    arr[i] = Integer.parseInt(leer.readLine());
                } catch (IOException e) {
                    System.out.println("Error. Ingrese nuevamente.");
                    bien = false;
                } catch (NumberFormatException er) {
                    System.out.println("El numero ingresado no es valido. Ingrese Nuevamente");
                    bien = false;
                }
            } while (!bien);
            i++;
        }
        obj.setArr(arr);
        obj.eliminarDuplicados();
        System.out.println("El arreglo sin duplicados es: ");
        for (i = 0; i < tamanho; i++) {
            System.out.print(" "+obj.getArr()[i]);
        }


    }
}
