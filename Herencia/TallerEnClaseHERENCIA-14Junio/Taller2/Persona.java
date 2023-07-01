public class Persona {
    protected String nombre;
    protected String cedula;
    private int telefono;
    private String correo;
    
    public void asignar(String nom, String ced) {
        this.nombre = nom; this.cedula = ced;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
