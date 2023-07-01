package Programa3;

public class Vocales {
    private char letra;

    public void asignar(char letra) {
        this.letra = letra;
    }

    public void cargar(char[] letras, int posicion) {
        letras[posicion] = letra;
    }

    public int contarVocales(int contador) {
        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            contador++;
        }
        return contador;
    }

    public char getLetra() {
        return letra;
    }
}
