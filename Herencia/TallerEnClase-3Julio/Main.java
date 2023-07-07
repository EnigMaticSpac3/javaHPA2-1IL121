/*Grupo 1IL-121
 Jorge Gonzalez
 Amy Him
 Jeferson Chacon
 Diego Ramos
*/
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        Frescos f = new Frescos();
        Congelados c = new Congelados();

        // Variables
        int numL = 0, cantidadP = 0, opcion = 0;
        double temperatura = 0.0, costo = 0.0;
        String fechaC = "", resp = "";
        boolean bien;
        
        do {

            // Menu
            do {
                bien = true;
                System.out.println("1. Frescos");
                System.out.println("2. Congelados");
                System.out.println("3. Salir");

                try {
                    System.out.print("Ingrese una opcion: ");
                    opcion = Integer.parseInt(leer.readLine());
                    if (opcion < 1 || opcion > 3) {
                        System.out.println("Opcion no valida. Ingrese nuevamente");
                        bien = false;
                    }
                } catch (IOException e) {
                    System.out.println("Error. Ingrese nuevamente");
                    bien = false;
                } catch (NumberFormatException er) {
                    System.out.println("Opcion no valida. Ingrese nuevamente");
                    bien = false;
                }
            } while(!bien);

            if (opcion == 3) {
                System.out.println("Gracias por usar el programa");
                System.exit(0);
            }
            
            // Ingresamos los datos globales (numero de lote, fecha de caducidad y cantidad producida)
            // Ingresa el numero de Lote
            do {
                bien = true;
                
                try {
                    System.out.print("Ingrese el numero de lote: ");
                    numL = Integer.parseInt(leer.readLine());
                } catch(NumberFormatException e) {
                    System.out.println("Numero no valido. Ingrese nuevamente");
                    bien = false;
                } catch (IOException er) {
                    System.out.println("Error. Ingrese nuevamente");
                    bien = false;
                }
            } while(!bien);
        
        
            // Ingresa la fecha de Caducidad
            do {
                bien = true;
                try{
                    System.out.print("Ingrese Fecha de caducidad: ");
                    fechaC =leer.readLine(); 
                }    
                catch(IOException e) {
                    System.out.println("Error. Ingrese nuevamente");
                    bien = false;
                }
            } while(!bien);

            // Ingresa la cantidad producida
            do {
                try {
                    System.out.print("Ingrese la cantidad producida: ");
                    cantidadP = Integer.parseInt(leer.readLine());
                } catch (NumberFormatException e) {
                System.out.println("Error. Ingrese nuevamente");
                    bien = false;  
                } catch (IOException er) {
                    System.out.println("Error. Ingrese nuevamente");
                    bien = false;
                }
            } while (!bien);
        
            // Imprima el costo y el número de lote al que pertenece la caja 
            switch(opcion) {
                case 1:
                    f.asignar(numL, fechaC, cantidadP);
                    System.out.println("");
                    costo = f.calcularCostoProd(cantidadP);
                    System.out.println("________________________________________");
                    System.out.println(String.format("El costo de Produccion de los Productos Frescos es: $%.2f",  costo));
                    System.out.println("El numero de lote es:" + f.getNumLote());
                    break;
                    
                case 2:
                    c.asignar(numL, fechaC, cantidadP);
                    System.out.println("");
                    try {
                        System.out.print("Ingrese la Temperatura en °C recomendada: ");
                        temperatura = Double.parseDouble(leer.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Error. Ingrese nuevamente");
                        bien = false;
                    } catch (IOException er) {
                        System.out.println("Error. Ingrese nuevamente");
                        bien = false;
                    }
                    c.asignar(temperatura);
                    System.out.println("________________________________________");
                    System.out.println(String.format("El costo total de los Productos Congelados es: $%.2f", c.calcularCostoProd(cantidadP)));
                    System.out.println("El numero de lote es:" + c.getNumLote());
                    break;                
            }


            // Pregunta si desea continuar
            do {
                bien = true;
                try {
                    System.out.print("Desea continuar? (si/no): ");
                    resp = leer.readLine();
                } catch (IOException e) {
                    System.out.println("Error. Ingrese nuevamente");
                    bien = false;
                }
            } while(!bien);
        } while(resp.toLowerCase().equals("si"));
    }
    

}
