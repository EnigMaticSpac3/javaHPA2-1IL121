public class Mayor {
    private double salario;
    private String nombre;


    public void asignar(String nombre, double salario) {
        this.nombre = nombre; // "Jorge"
        this.salario = salario; // 200
    }

    public double getSalario() { return salario; }
    public String getNombre() { return nombre; }

    // public void calcularMayor(String nombre, double salario) {
        
    // }
}
