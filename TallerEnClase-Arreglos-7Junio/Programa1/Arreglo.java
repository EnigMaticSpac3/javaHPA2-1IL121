package Programa1;

public class Arreglo {
    private int arr[];

    // public EliminarDuplicados(int tamanho) {
    //     int arr[] = new int[tamanho];
    // }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void eliminarDuplicados() {
        int i, j;
        // elimino los duplicados
        for (i = 0; i < arr.length; i++) {
            for (j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = 0;
                }
            }
        }
        // ordeno el arreglo
        int temp;
        i = 0;
        do {
            for (j = i + 1; j < arr.length; j+=1)
                if (arr[i] == 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            i = i + 1;
        } while (i < arr.length);
    }

    public int[] getArr() {
        return arr;
    }


    
}
