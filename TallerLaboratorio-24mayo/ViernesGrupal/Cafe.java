public class Cafe {
    private String tipo;
    private int cantidadBolsas;

    public void asignar(String tipo, int cantidadBolsas) {
        this.tipo = tipo;
        this.cantidadBolsas = cantidadBolsas;
    }
    public String getTipo() {
        return tipo;
    }

    public int getCantidadBolsas() {
        return cantidadBolsas;
    }
    
    public CalculoCajas calcularCajas() {
        int cajasGrandes, bolsasRestantes1, cajasMedianas, bolsasRestantes2, cajasPequenas, bolsasRestantesPequenas;
        
        cajasGrandes = cantidadBolsas / 20;
        bolsasRestantes1 = cantidadBolsas - cajasGrandes * 20;
        cajasMedianas = bolsasRestantes1 / 10;
        bolsasRestantes2 = bolsasRestantes1 - cajasMedianas * 10;
        cajasPequenas = bolsasRestantes2 / 5;
        bolsasRestantesPequenas = bolsasRestantes2 % 5;
        if (bolsasRestantesPequenas > 0) {
            cajasPequenas++;
        }

        return new CalculoCajas(cajasGrandes, cajasMedianas, cajasPequenas);
    }

    public double calcularPedido(double precioCafe) {
        double costoPedido;
        if (tipo.equals("Arabica")) {
            costoPedido = precioCafe * cantidadBolsas;
        } else {
            costoPedido = precioCafe * cantidadBolsas;
        }
        return costoPedido;
    }

    
}
