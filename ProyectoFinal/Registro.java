import java.util.LinkedList;
public class Registro {
    private LinkedList<Animal> animalesRegistrados;
    private LinkedList<Factura> facturasRegistradas;
    private LinkedList<Gallina> prodGallinas1;
    private LinkedList<Gallina> prodGallinas2;
    private LinkedList<Gallina> prodGallinas3;
    private LinkedList<Vaca> prodLeche;

    public Registro() {
        animalesRegistrados = new LinkedList<Animal>();
        facturasRegistradas = new LinkedList<Factura>();
        prodGallinas1 = new LinkedList<Gallina>();
        prodGallinas2 = new LinkedList<Gallina>();
        prodGallinas3 = new LinkedList<Gallina>();
        prodLeche = new LinkedList<Vaca>();
    }

    public void registrarAnimal(Animal animal) {
        animalesRegistrados.add(animal);
    }

    public void registrarFactura(Factura factura) {
        facturasRegistradas.add(factura);
    }

    public void registrarProdGallinas1(Gallina gallina) {
        prodGallinas1.add(gallina);
    }

    public void registrarProdGallinas2(Gallina gallina) {
        prodGallinas2.add(gallina);
    }

    public void registrarProdGallinas3(Gallina gallina) {
        prodGallinas3.add(gallina);
    }

    public void registrarProdLeche(Vaca vaca) {
        prodLeche.add(vaca);
    }

    public LinkedList<Animal> getAnimalesRegistrados() {
        return animalesRegistrados;
    }

    public LinkedList<Factura> getFacturasRegistradas() {
        return facturasRegistradas;
    }

    public LinkedList<Gallina> getProdGallinas1() {
        return prodGallinas1;
    }

    public LinkedList<Gallina> getProdGallinas2() {
        return prodGallinas2;
    }

    public LinkedList<Gallina> getProdGallinas3() {
        return prodGallinas3;
    }

    public LinkedList<Vaca> getProdLeche() {
        return prodLeche;
    }
}
