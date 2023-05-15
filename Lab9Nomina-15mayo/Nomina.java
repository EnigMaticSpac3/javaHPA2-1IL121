public class Nomina {
    private double salario;
    private String nombre;

    public void asignar(String nombre ,double salario) {
        this.salario = salario;
        this.nombre = nombre;
    }

    public double getSalario() { return salario; }
    public String getNombre() { return nombre; }

    public void calcularAumento() {
        // es void porque el metodo que devuelve el atributo es el GET
        salario += salario *20/100;
    }
    // este es el que se usa ahora
    public void calcularMayor(Mayor mayor) {
        if (salario > mayor.getSalario()) {
            mayor.asignar(nombre, salario);
        }
    }
    // este ya no se usa
    public String calcularMayorSalario(boolean primera, String nombreM, double salarioM, String resp) {
        if(primera) {
            salarioM = salario;
        } else {
            if (salarioM < salario) {
                salarioM = salario;
                nombreM = nombre;
            }
        }
        resp = "Nombre del empleado: " + nombreM + "\nSueldo: " + salarioM;
        return resp;
    }

    public double calcularTotal(double total) {
        total += salario;
        return total;
    }

}
