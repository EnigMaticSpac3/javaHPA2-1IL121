/* Integrantes:
    
    @Jefferson Chacon   | 20-70-7314
    @Jorge Gonzalez     | 8-1002-2167
    @Amy Him            | 3-753-2253 
    @DIego Ramos        | 8-1002-1456
*/
import java.io.*;
public class Main2 {
    public static void main(String[] args) throws IOException {
        double saldo, costo;
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        // Instanciar al objeto
        TarjetaMetro obj = new TarjetaMetro();

        System.out.print("Ingrese el saldo de su tarjeta: $");
        saldo = Double.parseDouble(leer.readLine());

        obj.asignar(1234, saldo, .5);
        costo = obj.calcularCosto();
        obj.actualizarSaldo(costo);
        System.out.println("SALDO: " + obj.traerSaldo());

    }
}
