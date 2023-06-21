/*
 * Integrantes:
 * - Jorge González   | 8-1002-2167
 * - Diego Ramos      | 8-1002-1456
 * - Amy Him          | 3-753-2253
 * - Jefferson Chacon | 20-70-7314
 */
import java.util.Random;

public class MundoM {
    
    private int respUs;

    // datos de entrada
    // respuestas de los niños
    Random random = new Random();

    public void asignar(int respUs) {
        this.respUs = respUs;
    }

    public boolean verificarRespuesta(int respCorrecta) {
        return respUs == respCorrecta;
    }
    
    
    
    public int generarNum(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public char generarOperador(char[] OPERADORES) {
        return OPERADORES[random.nextInt(OPERADORES.length)];
    }

    public int calcularResultado(int num1, int num2, char op) {
        int resultado = 0;
        switch (op) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '/':
                resultado = num1 / num2;
                break;
            case '*':
            resultado = num1 * num2;
                break;
        }
        return resultado;
    }
  
    public int getRespUs() {
        return respUs;
    }
        
}
