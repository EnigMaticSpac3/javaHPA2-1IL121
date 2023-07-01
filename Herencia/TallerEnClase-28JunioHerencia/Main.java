/*
 * Su profesor de matemáticas le solicita esta semana que escriba un programa que tenga una clase llamada
 * Ecuación con atributos privados y que permita calcular el valor de X. X = a*b-2/c. Al cabo de dos meses
 * se solicita otra clase llamada EcuaciónUno para calcular el valor de y. Y = a*b-2/c+z^n. Instancie un 
 * objeto de EcucacionUno e imprima el valor de 'x' y 'y'; debe reutilizar el código y aplicar herencia.
 * 
 */
import java.io.*;
class Main {
    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        EcuacionUno ecuacionUno = new EcuacionUno();


        // variables
        String cadena  = "";
        int a=0, b=0, c=0, z=0, n=0 ;
        boolean error;

        // Ingresar A
        do {
            error = false;
            try {
                System.out.print("Ingrese el valor de a: ");
                cadena = leer.readLine();
                a = Integer.parseInt(cadena);
            } catch (IOException e) {
                System.out.println("Error al leer el valor de a. Ingrese nuevamente.");
                error = true;
            } catch (NumberFormatException er) {
                System.out.println(String.format("No se acepta %s como valor para a. Ingrese nuevamente.", cadena));
                error = true;
            }
        } while (error);
        
        // Ingresar B
        do {
            error = false;
            try {
                System.out.print("Ingrese el valor de b: ");
                cadena = leer.readLine();
                b = Integer.parseInt(cadena);
            } catch (IOException e) {
                System.out.println("Error al leer el valor de a. Ingrese nuevamente.");
                error = true;
            } catch (NumberFormatException er) {
                System.out.println(String.format("No se acepta %s como valor para b. Ingrese nuevamente.", cadena));
                error = true;
            }
        } while (error);

        // Ingresar C
        do {
            error = false;
            try {
                System.out.print("Ingrese el valor de c: ");
                cadena = leer.readLine();
                c = Integer.parseInt(cadena);
                if (c == 0) {
                    System.out.println("El valor de c no puede ser 0. Ingrese nuevamente.");
                    error = true;
                }
            } catch (IOException e) {
                System.out.println("Error al leer el valor de a. Ingrese nuevamente.");
                error = true;
            } catch (NumberFormatException er) {
                System.out.println(String.format("No se acepta %s como valor para c. Ingrese nuevamente.", cadena));
                error = true;
            }
        } while (error);
        
        // Ingresar Z
        do {
            error = false;
            try {
                System.out.print("Ingrese el valor de z: ");
                cadena = leer.readLine();
                z = Integer.parseInt(cadena);
            } catch (IOException e) {
                System.out.println("Error al leer el valor de z. Ingrese nuevamente.");
                error = true;
            } catch (NumberFormatException er) {
                System.out.println(String.format("No se acepta %s como valor para z. Ingrese nuevamente.", cadena));
                error = true;
            }
        } while (error);

        // Ingresar N
        do {
            error = false;
            try {
                System.out.print("Ingrese el valor de n: ");
                cadena = leer.readLine();
                n = Integer.parseInt(cadena);
                if (n < 0) {
                    System.out.println("El valor de n no puede ser negativo. Ingrese nuevamente.");
                    error = true;
                }
            } catch (IOException e) {
                System.out.println("Error al leer el valor de n. Ingrese nuevamente.");
                error = true;
            } catch (NumberFormatException er) {
                System.out.println(String.format("No se acepta %s como valor para n. Ingrese nuevamente.", cadena));
                error = true;
            }
        } while (error);

        // Asignamos a la clase
        ecuacionUno.asignar(a, b, c);
        ecuacionUno.asignar(z, n);

        // Imprimimos los resultados
        System.out.println(String.format("X: %.2f", ecuacionUno.calcularX()));
        System.out.println(String.format("Y: %.2f", ecuacionUno.calcularY()));
    }
}