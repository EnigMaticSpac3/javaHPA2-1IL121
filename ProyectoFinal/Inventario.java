// CLASE QUE MANEJA EL INVENTARIO DE LA GRANJA

public class Inventario {
    Gallina[] gallinas;
    Vaca[] vaca;

    public Inventario(int cantGallinas, int cantVacas) {
        gallinas = new Gallina[cantGallinas];
        vaca = new Vaca[cantVacas];
    }
}
