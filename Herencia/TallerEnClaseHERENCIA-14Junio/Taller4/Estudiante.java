package Taller3;


class Estudiante extends Persona {
    private int totParciales, totC;

    public void asignar(int tP, int tC) {
        this.totParciales = tP; this.totC = tC;
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
