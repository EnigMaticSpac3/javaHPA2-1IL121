import java.io.*;
public class Main2 {
    // Elabore una funcion en java que calcule F(x,y) = raiz(x) / y^2 - 1

    public static void main(String[] args) {
        Funcion obj = new Funcion();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double x = 0.0, y=0.0;
        
        // obj.asignar(E, 5.0);
        try {
            System.out.print("Ingrese un numero double para x: ");
            x = Double.parseDouble(br.readLine());
            System.out.println("\n");
        }
        catch (IOException er) { System.out.println("ERROR: " + er); }
        catch (NumberFormatException err) { System.out.println("ERROR: " + err); }

        try {
            System.out.print("Ingrese un valor double para y: ");
            y = Double.parseDouble(br.readLine());
        } 
        catch (IOException er) { System.out.println("ERROR: " + er); }
        catch (NumberFormatException err) { System.out.println("ERROR: " + err); }

        obj.asignar(x, y); 
        // obj.asignar(5.0, 4.0);
        System.out.println("Funcion = " + obj.calcular());
    }
}
