// CLASE HIJO DE 'ANIMAL'

public class Vaca extends Animal {
    private int cantidadVacas;

    public void asignar(int edad, double peso, String nombreRaza, int cantidadVacas) {
        super.asignar(edad, peso, nombreRaza);
        this.cantidadVacas = cantidadVacas;
    }

    public int getCantidadVacas() {
        return cantidadVacas;
    }
}
