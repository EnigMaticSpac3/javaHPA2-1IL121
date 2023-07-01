public class Estudiante extends Persona {
    protected int totParciales, totC;

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
            mensaje = "Felicidades " + nombre + "! Eres Sigma Lambda";
        } else if (indice > 2.0) {
            mensaje = nombre + ", eres candidato a Sigma Lambda! Sigue asi";
        } else {
            mensaje = "Sigue esforzándote " + nombre + ". Tu puedes!";
        }
        return mensaje;
    }

    
}
