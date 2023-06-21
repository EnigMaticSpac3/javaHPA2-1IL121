/*
 * Integrantes:
 * - Jorge González   | 8-1002-2167
 * - Diego Ramos      | 8-1002-1456
 * - Amy Him          | 3-753-2253
 * - Jefferson Chacon | 20-70-7314
 */
public class Adivinanza {
    private String preguntas[];
    private String resp[][];
    private int respCorrecta[];
    private int random;

    public void asignar (String preguntas[], String resp[][], int respCorrecta[], int random) {
        this.preguntas      = preguntas;
        this.resp           = resp;
        this.respCorrecta   = respCorrecta; 
        this.random         = random;
    }

    public String generarPregunta() {
        return preguntas[random];
    }
    
    public String[] generarRespuestas() {
        return resp[random];
    }

    public int generarRespCorrecta() {
        return respCorrecta[random];
    }


    public String[] getPreguntas() {
        return preguntas;
    }

    public String[][] getResp() {
        return resp;
    }

    public int[] getRespCorrecta() {
        return respCorrecta;
    }

    public int getRandom() {
        return random;
    }

}
