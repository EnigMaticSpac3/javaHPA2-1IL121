/*
 Integrantes:
    
    @Jefferson Chacon   | 20-70-7314
    @Jorge Gonzalez     | 8-1002-2167
    @Amy Him            | 3-753-2253 
    @DIego Ramos        | 8-1002-1456
 */

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        int id;
        String name;
        double saldo, costo;
        // Instanciar al objeto
        TarjetaMetro obj = new TarjetaMetro();
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        // Leemos el nombre de la persona
        System.out.print("Como te llamas?: ");
        name = leer.readLine();

        // Leemos id de la tarjeta
        System.out.print("ID: ");
        id = Integer.parseInt(leer.readLine());

        // Leemos saldo de la tarjeta
        System.out.print("Ingrese el saldo de su tarjeta: $");
        saldo = Double.parseDouble(leer.readLine());

        // Leemos el costo del viaje
        System.out.print("Costo de Viaje: $");
        costo = Double.parseDouble(leer.readLine());

        obj.asignar(id, saldo, costo);
        costo = obj.calcularCosto();
        obj.actualizarSaldo(costo);
        // System.out.println("SALDO: " + obj.traerSaldo());
        System.out.println("\n\n_________________\nHola " + name + "!\n" + "Tu costo Semanal es de: $" + costo + "\nEl saldo de su Tarjeta queda en: $" + obj.traerSaldo());
    }
}
