import java.io.*;
/* ESTE PROGRAMA TRABAJA CON 2 CLASES
*  UNO para la Nomina, 
*  OTRO para calcular el salario y nombre del mayor pagado.
*/
public class Main {
    public static void main(String[] args) {
        Nomina obj = new Nomina();
        // Se crea el 2do objeto para el calcular el Mayor
        Mayor mayor = new Mayor();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        String nombre = "";
        double salario = 0;
        // control - bandera
        String resp = "";
        /* Variables */
        String nombreM = "";
        double salarioM = 0, total = 0;
        boolean bien;
        
        do {
            try {
                System.out.print("Ingrese el nombre del empleado: ");
                nombre = leer.readLine();
            } catch (IOException e) { System.out.println("Error: " + e); }
            do {
                bien = true;
                try {
                    System.out.print("Ingrese el salario: $");
                    salario = Double.parseDouble(leer.readLine());
                }
                catch (NumberFormatException e) {
                    System.out.println("Error en el numero.\nIngrese nuevamente.");
                    bien = false;
                }
                catch (IOException er) {System.out.println("Error: " + er); bien = false;}

            } while (!bien);

            obj.asignar(nombre, salario); // contiene los valores nuevos
            
            mayor.asignar(nombreM, salarioM); // contiene los valores viejos
            System.out.print("Salario actual: $" + obj.getSalario());
            obj.calcularAumento();
            System.out.print("\t\tSalario nuevo: $" + obj.getSalario());
            System.out.println("");

            obj.calcularMayor(mayor); // Calcula el salario mayor

            // guardamos en variables lo calculado por el método anterior
            nombreM = mayor.getNombre();
            salarioM = mayor.getSalario(); 
            
            total = obj.calcularTotal(total);

            // Preguntamos a usuario para finalizar el programa
            try {
                System.out.print("---------------------------------\nDesea continuar? (n para terminar): ");
                resp = leer.readLine() ;
                System.out.println("---------------------------------");
            } catch (IOException e) {
                System.out.println("hubo un error");
            }                
        } while (!resp.toLowerCase().equals("n"));
        System.out.println("______________________________________");
        System.out.println("El empleado con mayor salario es: " + nombreM);
        System.out.println("Con un salario de: $" + salarioM);
        System.out.println("El total de los nuevos salarios es: $"+total);
    }
}
