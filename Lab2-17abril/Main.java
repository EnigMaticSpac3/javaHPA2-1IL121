/*
 * Integrantes:
    
    @Jefferson Chacon   | 20-70-7314
    @Jorge Gonzalez     | 8-1002-2167
    @Amy Him            | 3-753-2253 
    @DIego Ramos        | 8-1002-1456
 */

import java.text.DecimalFormat;
class Main {
    public static void main(String[] args) {
        // Declaramos el formateador para los decimales
        DecimalFormat formatear = new DecimalFormat("0.000");
        // Declaramos objeto
        Funcion f = new Funcion();
        // Damos valores a sus atributos
        f.asignar(10, 3);

        System.out.println("El valor de x: " + f.getX());
        System.out.println("El valor de y: " + f.getY());
        System.out.println("La funcion devuelve: " + formatear.format(f.calcular()));
    }
}