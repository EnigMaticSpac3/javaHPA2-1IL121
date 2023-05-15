import java.io.*;
public class MainG {
    public static void main(String[] args) {
        Empleado obj = new Empleado();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        String nombre = "";
        double salario = 0;
        // control - bandera
        String resp = "s";
        boolean sw = true;
        /* Variables */
        String nombreM = "", res = "";
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

            // asignamos
            obj.asignar(nombre, salario);
            // imprimimos los salarios actuales y nuevos
            System.out.print("Salario actual: $"+obj.getSalario());
            // calculamos el nuevo
            obj.calcularAumento();
            // imprimimos el nuevo
            System.out.print("\tSalario nuevo: $"+obj.getSalario());
            // nueva línea
            System.out.println("");

            // calcular el salario mayor
            // salarioM = obj.calcularMayorSalario(sw, salarioM);
            res = obj.calcularMayor(sw, nombreM, salarioM, res);
            sw = false;
            total = obj.calcularTotal(total);
            try {
                System.out.print("Desea continuar? (n para terminar): ");
                resp = leer.readLine() ;
            } catch (IOException e) {
                System.out.println("hubo un error");
            }                
        } while (!resp.equals("n") || !resp.equals("N"));
        System.out.println("____________________________");
        System.out.println("El empleado con mayor salario es: \n" + res);
        System.out.println("El total de los nuevos salarios es: $"+total);
    }
}
