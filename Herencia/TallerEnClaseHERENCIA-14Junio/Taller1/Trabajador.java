public class Trabajador extends Persona{
    private int hTrabajadas;
    private int tarifaHora;
    private int fechaIngreso;
    
    public int gethTrabajadas() {
        return hTrabajadas;
    }
    public void sethTrabajadas(int hTrabajadas) {
        this.hTrabajadas = hTrabajadas;
    }
    public int getTarifaHora() {
        return tarifaHora;
    }
    public void setTarifaHora(int tarifaHora) {
        this.tarifaHora = tarifaHora;
    }
    public int getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(int fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    
}
