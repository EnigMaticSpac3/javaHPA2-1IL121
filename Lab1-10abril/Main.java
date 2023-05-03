/*
INTEGRANTES:
@Jefferson Chacon   | 20-70-7314
@Jorge Gonzalez     | 8-1002-2167
@Amy Him            | 3-753-2253 
@DIego Ramos        | 8-1002-1456

Diseñe un programa que maneja una clase llamada Rectangulo con sus respectivos atributos,
métodos.


 * Se tiene una oficina en forma rectangular de 7 metros de largo por 6,5 metros de ancho. 
 * Se cuenta con dos alfombras también rectangulares, que se colocaran sobre el piso de dicha oficina. 
 * La alfombra 1 mide 3.8 metros por 4.6 metros y la alfombre 2 4.5 metros por 2.3 metros. 
 * Se desea saber qué parte del piso de la oficina quedara cubierta y/o qué parte no, 
 * para ayudar a decidir si se compran o no otra alfombra.  
 */

public class Main {
    public static void main(String[] args) {
        double areaOficina, areaA1, areaA2, areaCubierta, areaNoCubierta;
        Rectangulo oficina = new Rectangulo();
        Rectangulo alfombra1 = new Rectangulo();
        Rectangulo alfombra2 = new Rectangulo();

        oficina.asignarLyA(7, 6.5);
        alfombra1.asignarLyA(3.8, 4.6);
        alfombra2.asignarLyA(4.5, 2.3);

        areaOficina = oficina.calcularArea();
        areaA1 = alfombra1.calcularArea();
        areaA2 = alfombra2.calcularArea();

        System.out.println("Area de oficina: " + areaOficina); 
        System.out.println("Area de alfombra 1: " + areaA1);
        System.out.println("Area de alfombra 2: " + areaA2);

        // Area cubierta
        areaCubierta = areaA1 + areaA2;
        areaNoCubierta = areaOficina - areaCubierta;

        System.out.println("Area de la oficina cubierta: " + areaCubierta);

        // Area que falta por cubrir
        System.out.println("Falta por cubrir un area de: " + areaNoCubierta);

        // Mostrar mensaje al usuario
        System.out.println("_______________________________________");
        if (areaNoCubierta > 0) {
            System.out.println("Falta area por cubrir. Se deben comprar mas alfombras.");
        } else {
            System.out.println("Se cubrio todo el area. No hace falta comprar mas alfombras.");
        }
    }
}

