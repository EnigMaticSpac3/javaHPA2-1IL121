public class Planta {
    
    private int produccion;

    public void asignar(int produccion) { this.produccion = produccion; }

    public void cargar(int planta[], int posicion) { planta[posicion] = produccion; }

    public double calcularPromedio(int planta[]) {
        int i, promedio = 0;
        for (i = 0; i < planta.length; i++) {
            promedio += planta[i];
        }
        return promedio / planta.length;
    }

    public int calcularMayor(int planta[]) {
        int i, mayor = 0, indiceMayor = 0;
        for (i = 0; i < planta.length; i++) {
            if (planta[i] > mayor) {
                mayor = planta[i];
                indiceMayor = i;
            }
        }
        return indiceMayor;
    }

    public int calcularMayores(int planta[], double promedio) {
        int i, contador = 0;
        for (i = 0; i < planta.length; i++) {
            if (planta[i] > promedio) {
                contador++;
            }
        }
        return contador;
    }
}