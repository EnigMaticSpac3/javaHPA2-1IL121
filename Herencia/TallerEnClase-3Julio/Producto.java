/*Grupo 1IL-121
 Jorge Gonzalez
 Amy Him
 Jeferson Chacon
 Diego Ramos
*/
public class Producto {
    private int numLote;
    private String fechaCaducidad;
    private int cantProd;
    
    public void asignar(int numLote, String fechaCaducidad, int cantProd) {
        this.numLote = numLote;
        this.fechaCaducidad = fechaCaducidad;
        this.cantProd = cantProd;
    }  
    
    public String getFechaCaducidad() {
        return this.fechaCaducidad;
    }
    
    public int getNumLote() {
        return this.numLote;
    }
}