/* Elabore una aplicacion en java que compute los votos obtenidos por cada candidato que participo en una contienda electoral,se lee el voto dado por cada persona 
 *al candidato de su preferencia, se cuenta con 5 candidatos, los votantes deben introducir su voto, el cual debe oscilar entre 1 ..5. Se desea imprimir los votos obtenidos por cada 
 *candidato, luego ordenelos ubicandolos de mayor a menor. Se debe leer el nombre de cada candidato e imprimirlo tambien ordenado segun el arreglo de votos*/

// El programa no ordena asi que eso es lo que deben hacer, luego de estudiar este laboratorio
// Contar los votos invalidados
import java.io.*;

class Elecciones {
    private String nomC;
    private int voto;

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public void cargarN(String cand[], int c) {
        cand[c] = nomC;
    }

    public void totalizarV(int totV[]) {
        totV[voto - 1] = totV[voto - 1] + 1;
    }
}

public class LabD {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Elecciones obj = new Elecciones();
        String nomC[] = new String[3];
        int totV[] = new int[5];
        int v, can = 0;
        char resp = 's';
        String nom;
        boolean leido = true;
        for (v = 0; v < nomC.length; v++) {

            try {
                System.out.println("Nombre del Candidato");
                nom = br.readLine();
                obj.setNomC(nom);
                obj.cargarN(nomC, v);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        while (resp == 's') {

            System.out.println("\n\n****** Elecciones *****\n\n");

            do {

                try {
                    // es hasta 5
                    System.out.println("Escriba [1]-[2]-[3], segun el candidato de su preferencia");
                    can = Integer.parseInt(br.readLine());
                    leido = true;
                    // validar el voto
                    obj.setVoto(can);
                    obj.totalizarV(totV);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Ingrese un valor numerico ");
                    leido = false;
                } catch (IOException e) {
                    System.out.println(e);
                    leido = false;
                } 
                // catch (ArrayIndexOutOfBoundsException e) {
                //     System.out.println(e + "\nVuelva a leer ese valor esta fuera del rango ");
                //     leido = false;
                // }

            } while (!leido);

            try {
                System.out.println("DESEA PROCESAR OTRO Votante s/n");
                resp = (char) br.read();
                br.skip(1);  // error
            } catch (IOException e) {
                System.out.println(e);
            }

        }
        for (v = 0; v < nomC.length; v++)
            System.out.println("\n" + nomC[v] + "\t\t" + totV[v]);
    }
}
