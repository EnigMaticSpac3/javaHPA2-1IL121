/*
 * Su profesor de matemáticas le solicita esta semana que escriba un programa que tenga una clase llamada
 * Ecuación con atributos privados y que permita calcular el valor de X. X = a*b-2/c. Al cabo de dos meses
 * se solicita otra clase llamada EcuaciónUno para calcular el valor de y. Y = a*b-2/c+z^n. Instancie un 
 * objeto de EcucacionUno e imprima el valor de 'x' y 'y'; debe reutilizar el código y aplicar herencia.
 * 
 */

class Main {
    public static void main(String[] args) {
        EcuacionUno ecuacionUno = new EcuacionUno();
        ecuacionUno.asignar(1, 2, 3);
        ecuacionUno.asignar(4, 5);
        System.out.println(String.format("X: %.2f", ecuacionUno.calcularX()));
        System.out.println(String.format("Y: %.2f", ecuacionUno.calcularY()));
    }
}