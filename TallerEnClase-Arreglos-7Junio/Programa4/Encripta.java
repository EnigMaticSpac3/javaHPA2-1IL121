package Programa4;

public class Encripta {
    private String palabra;

    public void asignar(String palabra) {
        this.palabra = palabra;
    }

    public String encriptar() {
        char[] letras = new char[palabra.length()];
        letras = palabra.toCharArray();
        int i;
        
        for (i = 0; i < letras.length; i++) {
            letras[i] = (char) (letras[i] + 3);
        }
        String encriptado = new String(letras);
        return encriptado;
    }
}
