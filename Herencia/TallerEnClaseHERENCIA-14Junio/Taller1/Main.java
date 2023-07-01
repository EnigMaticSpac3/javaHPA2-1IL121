import java.io.*;

public class Main {
    public static void main(String[] args) {
        Persona obj             = new Persona();
        Estudiante estudiante   = new Estudiante();
        BufferedReader leer     = new BufferedReader(new InputStreamReader(System.in));
        
        // Variables
        String nombre = "", ced = "", mensaje;
        int totP = 0, totC = 0; // Puntos y creditos
        double indice; 
        boolean bien;

        do {
            bien = true;
            try {
                System.out.print("Ingrese su nombre: ");
                nombre = leer.readLine();
            } catch (IOException e) {
                System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                bien = false;
            }
        } while (!bien);

        do {
            bien = true;
            try {
                System.out.print("Ingrese su cedula: ");
                ced = leer.readLine();
            } catch (IOException e) {
                System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                bien = false;
            }
        } while (!bien);

        do {
            bien = true;
            try {
                System.out.print("Ingrese el total de creditos: ");
                totC = Integer.parseInt(leer.readLine());
                // verificar que no sea menor que 0
                if (totC < 0) {
                    System.out.println("Los créditos no pueden ser negativos");
                    bien = false;
                }
                if (totC == 0) {
                    System.out.println("0 créditos no es posible, no calcularias nada. Ingresa un numero mayor a 0");
                }
            } catch (IOException e) {
                System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                bien = false;
            } catch (NumberFormatException er) {
                System.out.println("El numero es invalido. Ingrese otra vez");
                bien = false;
            }
        } while (!bien);

        do {
            bien = true;
            try {
                System.out.print("Ingrese el total de puntos: ");
                totP = Integer.parseInt(leer.readLine());
                // verificar que no se pase de los puntos
                if (totP > (totC * 3)) {
                    System.out.println("Tienes mas puntos que los aceptados. No deberias tener mas de " 
                    + totC * 3 
                    + " puntos.\nIngresa otra vez.");
                    bien = false;
                }
            } catch (IOException e) {
                System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                bien = false;
            } catch (NumberFormatException er) {
                System.out.println("El numero es invalido. Ingrese otra vez");
                bien = false;
            }
        } while (!bien);


        // Trabajamos con el objeto
        estudiante.setNombre(nombre);
        estudiante.setCedula(ced);
        estudiante.asignar(totP, totC);
        indice = estudiante.calcularI();


        // Imprimimos
        System.out.println("--------------------------------");
        System.out.println(String.format("|    Tu indice es de: %.2f     |", indice));
        System.out.println("--------------------------------");
        System.out.println(">> " + estudiante.mensaje(indice));

    }
}
