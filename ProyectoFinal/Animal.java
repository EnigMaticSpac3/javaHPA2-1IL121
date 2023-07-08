// CLASE BASE

public class Animal {
    private int edad;
    private double peso;
    private String nombreRaza;

    public void asignar(int edad, double peso, String nombre) {
        this.edad = edad;
        this.peso = peso;
        this.nombreRaza = nombre;
    }

    public int getEdad() {
        return edad;
    }
    public double getPeso() {
        return peso;
    }
    public String getNombreRaza() {
        return nombreRaza;
    }


}