// CLASE HIJO DE 'ANIMAL'

public class Vaca extends Animal {
    private int lecheProducida;

    public void asignar(int edad, double peso, String nombreRaza) {
        super.asignar(edad, peso, nombreRaza);
    }

    public void setLecheProducida(int produccion) {
        this.lecheProducida = produccion;
    }

    public int getLecheProducida () {
        return lecheProducida;
    }
}
