package Taller3;

public class Persona {
    protected String nombre;
    protected String cedula;
    
    public void asignar(String nom, String ced) {
        this.nombre = nom; this.cedula = ced;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    
}
