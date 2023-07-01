/*
 * Jorge González
 * 8-1002-2167
 */

public class Main {
    public static void main(String[] args) {
        
        // objeto
        Promedio obj = new Promedio();
        // variables de trabajo
        int promedio = 0, mayores = 0, i;
        

        // Llenado el vector lo asignamos al objeto
        // obj.asignar(vector);
        // Luego de llenar el vector calculamos el promedio del vector
        promedio = obj.calcularP();
        // y los mayores que el promedio
        mayores = obj.calcularM(promedio);

        // Lista de datos mayores que el promedio
        int listaM[] = new int[mayores];
        int vector[] = obj.getVal();
        int iLista = 0;
        for (i = 0; i < vector.length; i++) {
            if (vector[i] > promedio) {
                listaM[iLista] = vector[i];
                iLista++;
            }
        }

        // Imprimimos
        System.out.println("El promedio del vector es: " + promedio);
        System.out.println("El numero de datos mayores que el promedio son: " + promedio);
        System.out.println("La lista de esos datos: ");
        for (i = 0; i < listaM.length; i++) {
            System.out.print(" " + listaM[i]);
        }
    }
    
}
