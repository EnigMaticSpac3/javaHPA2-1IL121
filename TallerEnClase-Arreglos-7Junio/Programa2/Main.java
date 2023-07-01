import java.io.*;

public class Main {
    public static void main(String[] args) {
        Planta obj = new Planta();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        // Variables
        int[] planta = new int[5];
        int i, produccion = 0, contador = 0;
        double promedio;
        boolean bien = true;

        System.out.println("Ingrese la produccion de las plantas.");

        for (i = 0; i < planta.length;) {
            do {
                bien = true;
                try {
                    System.out.print("Producion Planta [" + (i+1) + "]: ");
                    produccion = Integer.parseInt(leer.readLine());
                } catch (IOException e) {
                    System.out.println("Hubo un error. Ingrese Nuevamente");
                    bien = false;
                } catch (NumberFormatException er) {
                    System.out.println("El numero ingresado no es valido. Ingrese nuevamente");
                    bien = false;
                }
            } while (!bien);
            obj.asignar(produccion);
            obj.cargar(planta, i);
            i++;
        }

        // calcular promedio
        promedio = obj.calcularPromedio(planta);

        // Imprimir producciones de todas las plantas
        System.out.println("Produccion de todas las plantas.");
        for (i = 0; i < planta.length; i++) {
            System.out.println(String.format("Planta #%d: %d", i+1, planta[i]));
        }

        // # de plantas que tuvo la mayor produccion en la semana
        contador = obj.calcularMayores(planta, promedio);
        System.out.println("Las plantas con mayor produccion: " + contador);

        // # de LA PLANTA con mayor produccion
        i =   obj.calcularMayor(planta);
        System.out.println("La planta con mayor produccion es: #" + (i+1) + "\n"
        + "Con una produccion de: " + planta[i]);

        // Imprimir mayores que promedio
        System.out.println("Mayores que el promedio. ["+promedio+"]");
        for (i = 0; i < planta.length; i++) {
            if (planta[i] > promedio) {
                System.out.print(String.format("Planta #%d, ", i+1));
            }
        }
    }
}
