import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        // Objetos
        Inventario  inventario  = new Inventario();
        Vaca        vaca        = new Vaca();
        
        // imagenes
        ImageIcon inicio = new ImageIcon("./imgs/granja.jpg");


        // Variables
        int opcion;
        String[] opcionesInicio = {"Acceder a Inventario", "Ventas", "Informes", "Salir"};
        String[] opcionesInventario = {"Registrar Gallina", "Registrar Vaca", "Registrar Prod.Huevos", "Registrar Prod.Leche"};
        // Inicio
        do {
            opcion = JOptionPane.showOptionDialog(null, null, "Granja", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, inicio, opcionesInicio, null);
            switch (opcion) {
                case 0:
                    do {
                        opcion = JOptionPane.showOptionDialog(null, null, "Inventario de la Granja", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesInventario, null);
                        switch (opcion) {
                            case 0:
                                // inventario.registrarGallina();
                                break;
                            case 1:
                                JPanel p = new JPanel(new BorderLayout(5,5));

                                JPanel labels = new JPanel(new GridLayout(0,1,2,2));
                                labels.add(new JLabel("Raza", SwingConstants.TRAILING));
                                labels.add(new JLabel("Peso", SwingConstants.TRAILING));
                                p.add(labels, BorderLayout.LINE_START);
                        
                                JPanel controls = new JPanel(new GridLayout(0,1,2,2));
                                JTextField raza = new JTextField("Brahman");
                                controls.add(raza);
                                raza.setEditable(false);
                                JTextField peso = new JTextField();
                                controls.add(peso);
                                p.add(controls, BorderLayout.CENTER);
                        
                                JOptionPane.showMessageDialog(null, p, "Log In", JOptionPane.QUESTION_MESSAGE);
                                System.out.println("Raza: " + raza.getText());
                                System.out.println("Peso: " + new String(peso.getText()));
                        
                                break;
                            case 2:
                                // inventario.registrarHuevos();
                                break;
                            case 3:
                                // inventario.registrarLeche();
                                break;
                        }
                    } while (opcion != JOptionPane.CLOSED_OPTION);
                    break;
                case 1:
                    // Ventas ventas = new Ventas();
                    
                    break;
                case 2:
                    // Informes informes = new Informes();
                    
                    break;
                case 3:
                    break;
            }
        } while (opcion != JOptionPane.CLOSED_OPTION);
    }
}
