import java.io.*;

public class Main {
    public static void main(String[] args) {
        int f,j;
        boolean leido=true;
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        double notas[] = new double [4];
        double notfin=0;
        Estudiante obj = new Estudiante();
        Salida respu[]= new Salida[3];

        for(f=0;f<respu.length;f++)
            respu[f]= new Salida();
        for(f=0;f<respu.length;f++)
            System.out.println(respu[f].getNombre()+respu[f].getNotaf()); // verificar xd
        
        String nom="";

        for(f=0;f<respu.length;f++){
            try { System.out.print("Ingrese el nombre: ");
                nom= br.readLine(); 
            } catch (IOException e ) {System.out.println ("Error");}

            for(j=0;j<notas.length;) {
                do { 
                    try {leido = true;
                        System.out.print ("Ingrese la nota [" + (j+1) + "]: ");
                        notas[j]= Double.parseDouble(br.readLine()); 
                        if (notas[j] > 100) {
                            System.out.println("No sea vivo. Nota menor o igual a 100. Ingrese nuevamente");
                            leido = false;
                        }
                        if (notas[j] < 0) {
                            System.out.println("Enserio. Las notas no pueden ser negativas chaval.\n Ingresa nuevamente.");
                            leido = false;
                        }
                    } catch (NumberFormatException er) { 
                        leido =false;
                        System.out.println ("Error. Ingrese nuevamente"); 
                    } catch (IOException e ) {System.out.println ("Error");}
                } while (!leido);
                j++;
            }
            System.out.println("______________________________________");
            obj.asignar (nom,notas);
            obj.ordenar();
            notfin= obj.calcularN();
            
            respu[f].setNombre(obj.traerN());
            respu[f].setNotaf(notfin);
        }
        System.out.println ("\n NOMBRE\tNOTA FINAL");
        for(j=0;j<respu.length;j++)
        System.out.println (String.format("%s\t%.2f", respu[j].getNombre(),respu[j].getNotaf()) );
    }
}

