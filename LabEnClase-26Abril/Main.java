public class Main {
    // Elabore una funcion en java que calcule F(x,y) = raiz(x) / y^2 - 1

    public static void main(String[] args) {
        Funcion obj = new Funcion();
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // double x = 0.0, y=0.0;
        obj.asignar(5.0, 4.0);
        // obj.asignar(E, 5.0);
        

        System.out.println("Funcion = " + obj.calcular());
    }
}
