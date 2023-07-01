public class Estudiante extends Persona {
    // private int[] notas;
    // private String carrera;
    // private int numMaterias = 3;
    
    private int totParciales, totC;

    public void asignar(int tp, int tc) {
        this.totParciales = tp; this.totC = tc;
    }

    public double calcularI() {
        double indice;
        indice = (double) totParciales/totC;
        return indice;
    }

    public String mensaje(double indice) {
        String mensaje = "";
        if (indice > 2.49) {
            mensaje = "Felicidades " + getNombre() + "! Eres Sigma Lambda";
        } else if (indice > 2.0) {
            mensaje = getNombre() + ", eres candidato a Sigma Lambda! Sigue asi";
        } else {
            mensaje = "Sigue esforzándote " + getNombre() + ". Tu puedes!";
        }
        return mensaje;
    }

    
}
