public class Mayor {
    private double salario;
    private String nombre;


    public void asignar(String nombre, double salario) {
        this.nombre = nombre; 
        this.salario = salario; 
    }

    public double getSalario() { return salario; }
    public String getNombre() { return nombre; }

}

