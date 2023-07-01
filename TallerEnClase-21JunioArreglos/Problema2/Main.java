package Problema2;
/*
 * Se dispone de n temperaturas almacenadas en un arreglo. 
 * Se desea calcular  la temperatura mayor y menor y en qué hora se dio. 
 */
public class Main {
    public static void main(String[] args) {
        
        double[] temp = {40.0, 32.4, 36.5, 23.0};
        int[] hora = {5, 6, 7, 8};
        Temperatura obj = new Temperatura();
        // variables
        int mayor, menor;
        
        // objeto
        obj.asignar(temp, hora);
        mayor = obj.calcularIndiceMayor();
        menor = obj.calcularIndiceMenor();

        System.out.println("La temperatura mayor es: " + temp[mayor]);
        System.out.println("A las: " + hora[mayor] + " de la tarde.");
        System.out.println("La temperatura menor es: " + temp[menor]);
        System.out.println("A las: " + hora[menor] + " de la tarde");

        
    }
}
