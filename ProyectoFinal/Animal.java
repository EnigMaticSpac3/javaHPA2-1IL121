// CLASE BASE

public class Animal {
    private int edad;
    private double peso;
    private String nombre;

    public void asignar(int edad, double peso, String nombre) {
        this.edad = edad;
        this.peso = peso;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    public double getPeso() {
        return peso;
    }
    public String getNombre() {
        return nombre;
    }


}