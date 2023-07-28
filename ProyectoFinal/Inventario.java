// CLASE QUE MANEJA EL INVENTARIO DE LA GRANJA

public class Inventario {
    // cantidad real
    int[] cantidadGallinas;
    int[] huevosProducidos;
    int cantidadVacas;
    int cantidadLeche;
    // capacidad
    Gallina[] gallinas;
    Vaca[] vacas;


    
    public Inventario() {
        gallinas            = new Gallina[3];
        vacas               = new Vaca[3];
        cantidadGallinas    = new int[3];
        huevosProducidos    = new int[3];
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
        // int i;
        // for (i = 0; i < vacas.length; i++) {
        //     if (vacas[i] == null) {
        //         vacas[i] = vaca;
        //         break;
        //     }
        // }
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
    }

    public void registrarLeche(int cantidad) {
        cantidadLeche += cantidad;
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
}
