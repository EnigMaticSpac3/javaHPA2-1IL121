import java.io.*;
public class Main5 {
    // Elabore una funcion en java que calcule F(x,y) = raiz(x) / y^2 - 1

    public static void main(String[] args) {
        Funcion obj = new Funcion();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean leido = true; // bandera logica
        double x = 0.0, y=0.0;
        do {
            try {
                System.out.print("Ingrese un numero double para x: ");
                x = Double.parseDouble(br.readLine());
                System.out.println("\n");
                leido = true;
            }
            catch (IOException er) { System.out.println("ERROR: " + er); }
            catch (NumberFormatException err) { System.out.println("ERROR: " + err); leido = false; }
        } while (!leido);

        do {
            try {
                System.out.print("Ingrese un valor double para y: ");
                y = Double.parseDouble(br.readLine());
                leido = true;
                // Prevenir que y sea igual a 1
                if (y == 1) { 
                    System.out.println("y tiene que ser distinto de 1.\nIngrese nuevamente."); 
                    leido = false;
                }
            } 
            catch (IOException er) { System.out.println("ERROR: " + er); }
            catch (NumberFormatException err) { System.out.println("ERROR: " + err); leido = false; }            
        } while (!leido);

        obj.asignar(x, y); 
        // obj.asignar(5.0, 4.0);
        // obj.asignar(E, 5.0);
        System.out.println("Funcion = " + obj.calcular());
    }
}
