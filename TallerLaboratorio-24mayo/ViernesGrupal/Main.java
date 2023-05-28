import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Imagenes
        ImageIcon confirmIcon = new ImageIcon("./images/espiral.jpg");
        ImageIcon extraIcon = new ImageIcon("./images/cafesito.jpg");
        ImageIcon inputIcon = new ImageIcon("./images/kekw.jpg");
        ImageIcon imagenCafe = null;
        ImageIcon imgCasaCafe = new ImageIcon("./images/casa_del_cafe.png");

        Cafe cafe = new Cafe();
        
        // bandera logica
        boolean leido = true;
        // Variables de trabajo
        String tipoCafe, inputCantidadBolsas, salida;
        double precioCafe, cantidadRecolectada = 0;
        String seleccionCafe = "";
        int cantidadBolsas = 0, opcion, cajasGrandes, cajasMedianas, cajasPequenas;
        do {

            do {
                leido = true;
                seleccionCafe = JOptionPane.showInputDialog(null, "Seleccione el tipo de cafe:\nA. Arabica\nB. Robusta",
                        "La Casa del Cafe", JOptionPane.QUESTION_MESSAGE, inputIcon, null, null).toString();


                if (!seleccionCafe.toUpperCase().equals("A") && !seleccionCafe.toUpperCase().equals("B")) {
                    JOptionPane.showMessageDialog(null, "Tipo de cafe invalido. Por favor, ingrese A o B.");
                    leido = false;
                } else {
                    leido = true;
                }

                if (seleccionCafe.toUpperCase().equals("A")) {
                    tipoCafe = "Arabica";
                    precioCafe = 5.50;
                } else {
                    tipoCafe = "Robusta";
                    precioCafe = 10.00;
                }

            } while (!leido);

            do {
                leido = true;
                try {
                    inputCantidadBolsas = JOptionPane.showInputDialog(null, 
                    "Ingrese la cantidad de bolsas de cafe a comprar:",
                    "Cantidad de bolsas", 
                    JOptionPane.QUESTION_MESSAGE, 
                    extraIcon, null, null).toString();

                    cantidadBolsas = Integer.parseInt(inputCantidadBolsas);

                    if (cantidadBolsas > 0) {
                        leido = true;
                    } else {
                        if (cantidadBolsas == 0) {
                            JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero", "Error en Cantidad Ingresada", JOptionPane.ERROR_MESSAGE);
                        }
                        JOptionPane.showMessageDialog(null, "La cantidad debe ser un numero entero positivo.", "Error en cantidad Ingresada", JOptionPane.ERROR_MESSAGE);
                        leido = false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El numero ingresado no es valido. Ingrese nuevamente.", "Numero no valido", JOptionPane.ERROR_MESSAGE);
                    leido = false;
                } catch (NullPointerException er) { // este error no se puso en el programa
                    int op = JOptionPane.showConfirmDialog(null, "Desea cancelar el pedido?", "Cancelar Pedido", JOptionPane.YES_NO_OPTION);
                    if (op == JOptionPane.YES_OPTION) {
                        break;
                    } else {
                        leido = false;
                    }
                }
            } while (!leido);

            // asignar
            cafe.asignar(tipoCafe, cantidadBolsas);
            // calculo de cajas usadas
            CalculoCajas cajas = cafe.calcularCajas();

            if (cafe.getTipo().equalsIgnoreCase("A")) {
                imagenCafe = new ImageIcon("./images/arabica.jpg");
            } else {
                imagenCafe = new ImageIcon("./images/robusta.png");
            }

            cajasGrandes = cajas.getCajasGrandes();
            cajasMedianas = cajas.getCajasMedianas();
            cajasPequenas = cajas.getCajasPequenas();

            salida = "Cafe: " + cafe.getTipo() + " \n"
                    + "Cantidad de bolsas pedidas: " + cantidadBolsas + "\t  Costo del pedido: $"
                    + cafe.calcularPedido(precioCafe) //
                    + "\n"
                    + "\t\t\n\nBolsas Usadas:\n"
                    + "\n"
                    + "   - Cajas grandes: "  + cajasGrandes  + "\t Costo: $" + cajasGrandes  * 2.0 + "\n"
                    + "   - Cajas medianas: " + cajasMedianas + "\t Costo: $" + cajasMedianas * 1.0 + "\n"
                    + "   - Cajas pequenas: " + cajasPequenas + "\t Costo: $" + cajasPequenas * 0.5 + "\n"
                    + "\n"
                    + "Costo total por pagar: $" + (cajas.calcularCostoTotal() + cafe.calcularPedido(precioCafe));

            JOptionPane.showMessageDialog(null, salida, "La Casa Del Cafe", JOptionPane.INFORMATION_MESSAGE, imagenCafe);

            opcion = JOptionPane.showOptionDialog(null, "¿Desea realizar otro pedido?", "Casa del Cafe",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, confirmIcon, null, null);
            leido = (opcion == JOptionPane.YES_OPTION);
            cantidadRecolectada += (cajas.calcularCostoTotal() + cafe.calcularPedido(precioCafe));
        } while (leido);

        JOptionPane.showMessageDialog(null, "La cantidad recolectada de ambos cafes: $" + cantidadRecolectada, "La Casa Del Cafe", JOptionPane.INFORMATION_MESSAGE, imgCasaCafe);
        
    }

}
