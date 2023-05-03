// En una población el 40% murió por un virus. 
// Calcular la cantidad de personas que murieron.
// Integrantes:
    
//     @Jefferson Chacon   | 20-70-7314
//     @Jorge Gonzalez     | 8-1002-2167
//     @Amy Him            | 3-753-2253 
//     @DIego Ramos        | 8-1002-1456
public class Main {
    public static void main(String[] args) {
        MuertesPoblacion pob = new MuertesPoblacion();

        pob.asignar(30);
        System.out.println("La poblacion total es de: " + pob.getCant());

        // Calcular cantidad
        System.out.println("La cantidad de la poblacion fallecida por el virus es de: " + pob.calcularM());
    }
}
