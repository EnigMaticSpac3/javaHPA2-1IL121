public class Estudiante {
    private String nom;
    private double notaP[];

    Estudiante() {
        notaP = new double[4];
    }

    void asignar(String no, double n[]) {
        nom = no;
        notaP = n;
    }

    void ordenar() {
        int i, j;
        // BLOQUE DE INSTRUCCIONES
        i = 0;
        double temp;
        do {
            for (j = i + 1; j < notaP.length; j = j + 1)
                if (notaP[i] < notaP[j]) {
                    temp = notaP[i];
                    notaP[i] = notaP[j];
                    notaP[j] = temp;
                }
            i = i + 1;
        } while (i < 3);
    }

    double calcularN() {
        double not = 0.00;
        int f;
        for (f = 0; f < 3; f++)
            not = not + notaP[f];
        return not / 3;
    }

    String traerN() {
        return nom;
    }


    double[] traerNo() {
        return notaP;
    }
}

