// CLASE HIJO DE 'ANIMAL'

public class Gallina {
    private int[] produccionDiaria;

    public Gallina() {
        produccionDiaria = new int[365]; 
        //para los 365 dias pues
    }
    public void registrarProduccionDiaria(int dia, int cantidadHuevos){
        produccionDiaria[dia] = cantidadHuevos;
    }

    public int obtenerProduccionDiaria(int dia){
        return produccionDiaria[dia];
    }

}