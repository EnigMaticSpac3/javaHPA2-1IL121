/*
 * Integrantes:
 * - Jorge González   | 8-1002-2167
 * - Diego Ramos      | 8-1002-1456
 * - Amy Him          | 3-753-2253
 * - Jefferson Chacon | 20-70-7314
 */
public class Ecuacion {
    private int[] terminos;

    public Ecuacion() {
        terminos = new int[3];
    }

    public void cargarTerminos(int num1, int num2, int resultado) {
        terminos[0] = num1;
        terminos[1] = num2;
        terminos[2] = resultado;
    }

    // tentativo
    public int obtenerRespuesta(int posicion, int[] terminos) {
        return terminos[posicion];
    }

    public String generarEcuacion(int posicion, char operador) {
        String ecuacion = "";
        switch(posicion) {
            case 0:
                ecuacion = "?" + " " + operador + " " + terminos[1] + " = " + terminos[2];
                break;
            case 1:
                ecuacion = terminos[0] + " " + operador + " " + "?" + " = " + terminos[2];
                break;
            case 2:
                ecuacion = terminos[0] + " " + operador + " " + terminos[1] + " = " + "?";
                break;
        }

        return ecuacion;
    }

    public int[] getTerminos() {
        return terminos;
    }

    
}
