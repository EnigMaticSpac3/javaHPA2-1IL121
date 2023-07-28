// CLASE HIJO DE 'ANIMAL'

public class Gallina extends Animal {
    private String identificador;
    private int produccionHuevos;

    public void asignar(int edad, double peso, String nombreRaza, String identificador) {
        super.asignar(edad, peso, nombreRaza);
        this.identificador = identificador;
    }

    public void setProduccionHuevos(int produccion) {
        this.produccionHuevos = produccion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public int getProduccionHuevos () {
        return produccionHuevos;
    }

}