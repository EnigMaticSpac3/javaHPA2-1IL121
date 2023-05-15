import java.io.*;

public class Main {
    public static void main(String[] args) {
        Salario obj = new Salario();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        // control - bandera
        double salario = 0;
        String resp = "s";
        int sw = 1;
        double mayor = 0, total = 0;

        
        do {
            try {
                System.out.print("\nIngrese el salario: $");
                salario = Double.parseDouble(leer.readLine());
            }
            catch (NumberFormatException e) {System.out.println("Error en el numero: " + e);}
            catch (IOException er) {System.out.println("Error: " + er);}

            // asignamos
            obj.asignar(salario);
            // imprimimos los salarios actuales y nuevos
            System.out.print("Salario actual: $"+obj.getSalario());
            // calculamos el nuevo
            obj.calcularAumento();
            // imprimimos el nuevo
            System.out.print("\tSalario nuevo: $"+obj.getSalario());
            // nueva línea
            System.out.println("");

            // calcular el mayor
            mayor = obj.calcularMayorSalario(sw, mayor);
            sw = 0;
            total = obj.calcularTotal(total);
            try {
                System.out.print("Desea continuar?: ");
                resp = leer.readLine() ;
            } catch (IOException e) {
                System.out.println("hubo un error");
            }                
        } while (resp.equals("s"));
        System.out.println("______________________________________");
        System.out.println("El salario mayor es: $"+mayor);
        System.out.println("El total de los nuevos salarios es: $"+total);
    }
}
