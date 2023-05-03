/* Integrantes:
    
    @Jefferson Chacon   | 20-70-7314
    @Jorge Gonzalez     | 8-1002-2167
    @Amy Him            | 3-753-2253 
    @DIego Ramos        | 8-1002-1456

 * Elabore una aplicación en Java que calcule el saldo de su
 * tarjeta de metrobus, si uste tiene que venir a la Universidad
 * 5 días a la semana sabiendo que tiene un saldo inicial de $50 
 * Imprima el costo x 1 semana y el saldo de su tarjeta.
 */

public class Main {
    public static void main(String[] args) {
        double costo;

        // Print para usuario
        System.out.println("El programa calcula el saldo de su tarjeta al final de la semana si usted tiene que viajar 5 dias a la semana con un saldo inicial de $50 y un costo por viaje de $0.75\n");

        TarjetaMetro obj = new TarjetaMetro();
        obj.asignar(2340, 100.0, .75);

        costo = obj.calcularCosto();

        System.out.println("Costo en la semana: $" + costo);
        obj.actualizarSaldo(costo);

        System.out.println("Saldo restante: $" + obj.traerSaldo());

        // obj.saldo;
    }
}
