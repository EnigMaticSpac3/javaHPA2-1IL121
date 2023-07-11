// CLASE HIJO DE 'ANIMAL'

public class Vaca extends Animal {
    private int lecheProducida;

    public void asignar(int edad, double peso, String nombreRaza, int lecheProducida) {
        super.asignar(edad, peso, nombreRaza);
        this.lecheProducida = lecheProducida;
    }

    public int getLecheProducida () {
        return lecheProducida;
    }
}
