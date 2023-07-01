/*
 * Jorge González
 * 8-1002-2167
 */

public class Cuadrado {
    private int num;


    public void asignar(int num) {
        this.num = num;
    }

    public int getNum() { return num; }

    public void cargar(int nume[], int posicion) {
        nume[posicion] = num;
    }
    public void elevarCuadrado(int eleva[], int posicion) {
        eleva[posicion] = num*num;
    }
}
