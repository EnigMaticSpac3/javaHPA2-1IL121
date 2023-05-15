public class Salario {
    private double salario;

    public void asignar(double salario) {
        this.salario = salario;
    }

    public double getSalario() { return salario; }

    public void calcularAumento() {
        // es void porque el metodo que devuelve el atributo es el GET
        salario += salario *20/100;
    }

    public double calcularMayorSalario(int sw, double mayor) {
        // sw - bandera
        if (sw == 1) {
            mayor = salario;
        } else {
            if (mayor < salario) {
                mayor = salario;
            }
        }
        return mayor;
    }

    public double calcularTotal(double total) {
        total += salario;
        return total;
    }

}
