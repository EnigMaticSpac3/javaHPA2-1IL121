package Programa4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        Encripta obj = new Encripta();

        // Variables
        String palabra = "", resp = "";
        boolean bien = true;
        do {
            do {
                try {
                    System.out.print("Ingrese la palabra a encriptar: ");
                    palabra = leer.readLine();
                } catch (IOException e) {
                    System.out.println("Hubo un error.\nIngrese nuevamente");
                    bien = false;
                }
            } while (!bien);
            
            // Asignamos
            obj.asignar(palabra);
    
            // Imprimimos
            System.out.println("La palabra original es: " + palabra);
            System.out.println("La palabra encriptada es: " + obj.encriptar());

            // Preguntamos si desea encriptar otra palabra
            System.out.print("__________________________________________\n" 
            +"¿Desea encriptar otra palabra? (si/no): ");
            try {
                resp = leer.readLine();
            } catch (IOException e) {
                System.out.println("Hubo un error.\nIngrese nuevamente");
                bien = false;
            }
        } while (!resp.toLowerCase().equals("no"));
    }
}
