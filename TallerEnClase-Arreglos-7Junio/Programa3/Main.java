package Programa3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Vocales obj = new Vocales();

        char letras[] = new char[5];
        // variables
        int contVocales = 0, i;
        char letra = ' ';
        boolean bien = true;

        // usuario ingresa caracter
        System.out.println("Cargue los 5 caracteres en el arreglo");
        for (i = 0; i < letras.length;) {
            do {
                bien = true;
                try {
                    System.out.print("Ingrese la letra #"+(i+1) + ": ");
                    letra = (char) leer.read();
                    leer.skip(2);
                } catch (IOException e) {
                    System.out.println("El caracter ingresado no es valido.\nIngresa nuevamente.");
                    bien = false;
                }
            } while (!bien);
            // si todo esta bien, realizamos los procesos en la clase
            obj.asignar(letra);
            obj.cargar(letras, i);
            contVocales = obj.contarVocales(contVocales);
            i++;
        }   

        // Imprimimos el arreglo
        System.out.print("El arreglo letras[] = ");
        for (i = 0; i < letras.length; i++) {
            System.out.print(letras[i] + " ");
        }

        System.out.println("\nTotal de vocales en el arreglo: " + contVocales);
    }
}
