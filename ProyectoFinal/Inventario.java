// CLASE QUE MANEJA EL INVENTARIO DE LA GRANJA

public class Inventario {
    // cantidad real
    int[] cantidadGallinas;
    int[] huevosProducidos;
    int[] huevosVendidos;
    int[] huevosDisponibles;
    int cantidadVacas;
    int cantidadLeche;
    int lecheVendida;
    int lecheDisponible;
    // capacidad
    Gallina[] gallinas;
    Vaca[] vacas;


    
    public Inventario() {
        gallinas            = new Gallina[3];
        vacas               = new Vaca[3];
        cantidadGallinas    = new int[3];
        huevosProducidos    = new int[3];
        huevosVendidos      = new int[3];
        huevosDisponibles   = new int[3];
        cantidadVacas       = 0;
        cantidadLeche       = 0;
    }

    public void registrarGallina(Gallina gallina) {
            
        switch(gallina.getIdentificador()) {
            // "ISBWN", "LHMN", "CTLANGR" 
            case "ISBWN":
                cantidadGallinas[0]++;
                break;
            case "LHMN":
                cantidadGallinas[1]++;
                break;
            case "CTLANGR":
                cantidadGallinas[2]++;
                break;
        }        

    }    

    public void registrarVaca(Vaca vaca) {
        cantidadVacas++;
    }

    public void registrarHuevos(String raza, int cantidad) {
        switch(raza) {
            // "ISBWN", "LHMN", "CTLANGR" 
            case "ISBWN":
                huevosProducidos[0] += cantidad;
                break;
            case "LHMN":
                huevosProducidos[1] += cantidad;
                break;
            case "CTLANGR":
                huevosProducidos[2] += cantidad;
                break;
        }       
        huevosDisponibles[0] = huevosProducidos[0] - huevosVendidos[0];
        huevosDisponibles[1] = huevosProducidos[1] - huevosVendidos[1];
        huevosDisponibles[2] = huevosProducidos[2] - huevosVendidos[2]; 
    }

    public void registrarLeche(int cantidad) {
        cantidadLeche += cantidad;
        lecheDisponible = cantidadLeche - lecheVendida;
    }

    public void venderHuevos(String raza, int cantidad) {
        switch(raza) {
            // "ISBWN", "LHMN", "CTLANGR" 
            case "ISBWN":
                huevosVendidos[0] += cantidad;
                break;
            case "LHMN":
                huevosVendidos[1] += cantidad;
                break;
            case "CTLANGR":
                huevosVendidos[2] += cantidad;
                break;
        }       
        huevosDisponibles[0] = huevosProducidos[0] - huevosVendidos[0];
        huevosDisponibles[1] = huevosProducidos[1] - huevosVendidos[1];
        huevosDisponibles[2] = huevosProducidos[2] - huevosVendidos[2];  
    }

    public void venderLeche(int cantidad) {
        lecheVendida += cantidad;
        lecheDisponible = cantidadLeche - lecheVendida;
    }




    public int[] getCantidadGallinas() {
        return cantidadGallinas;
    }

    public int[] getHuevosProducidos() {
        return huevosProducidos;
    }

    public int getCantidadLeche() {
        return cantidadLeche;
    }
    
    public int getCantidadVacas() {
        return cantidadVacas;
    }
    
    public Gallina[] getGallinas() {
        return gallinas;
    }
    
    public Vaca[] getVacas() {
        return vacas;
    }

    public int[] getHuevosVendidos() {
        return huevosVendidos;
    }

    public int getLecheVendida() {
        return lecheVendida;
    }

    public int[] getHuevosDisponibles() {
        return huevosDisponibles;
    }

    public int getLecheDisponible() {
        return lecheDisponible;
    }

}
