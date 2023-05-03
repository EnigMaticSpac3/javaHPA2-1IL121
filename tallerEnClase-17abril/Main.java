/*
 * @Integrantes:
 * Diego Ramos
 * Jefferson Chacon
 * Amy Him
 * Jorge Gonzalez
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