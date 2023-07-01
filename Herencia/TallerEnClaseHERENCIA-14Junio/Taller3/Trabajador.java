package Taller3;

public class Trabajador extends Persona {
    protected int horasTrabajadas;
    protected double tarifaHora;

    public void asignar(int hT, double tH) {
        this.horasTrabajadas = hT; this.tarifaHora = tH;
    }

    public double calcularSalario() {
        double salario;
        salario = horasTrabajadas*tarifaHora;
        return salario;
    }
}
