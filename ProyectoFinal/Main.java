import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        // Objetos
        Inventario  inventario  = new Inventario();
        Vaca        vaca        = new Vaca();

        // Objetos de JAVA
        JPanel panel = new JPanel(new BorderLayout(5,5));
        JPanel labels, controls;
        JTextField raza, pesoTxt;
        
        // imagenes
        ImageIcon inicio = new ImageIcon("./imgs/granja.jpg");


        // Variables
        int opcion;
        double peso;
        String[] razasGallina       = {"Isa Brown", "Lohman", "Castellana Negra"};
        String[] identificadores    = {"ISBWN", "LHMN", "CTLANGR"};
        String[] opcionesInicio     = {"Acceder a Inventario", "Ventas", "Informes", "Salir"};
        String[] opcionesInventario = {"Registrar Gallina", "Registrar Vaca", "Registrar Prod.Huevos", "Registrar Prod.Leche"};
        boolean bien, cancelado;

        // Inicio
        do {
            opcion = JOptionPane.showOptionDialog(null, null, "Granja", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, inicio, opcionesInicio, null);
            switch (opcion) {
                case 0:
                    do {
                        opcion = JOptionPane.showOptionDialog(null, null, "Inventario de la Granja", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesInventario, null);
                        switch (opcion) {
                            case 0:
                                labels = new JPanel(new GridLayout(0,1,2,2));
                                labels.add(new JLabel("Raza", SwingConstants.TRAILING));
                                labels.add(new JLabel("Identificador", SwingConstants.TRAILING));
                                labels.add(new JLabel("Peso", SwingConstants.TRAILING));
                                panel.add(labels, BorderLayout.LINE_START);
                        
                                controls = new JPanel(new GridLayout(0,1,2,2));
                                JComboBox<String>  razaG = new JComboBox<>(razasGallina);
                                controls.add(razaG);
                                JTextField identificador = new JTextField(identificadores[razaG.getSelectedIndex()]);
                                razaG.addActionListener(e -> {
                                    identificador.setText(identificadores[razaG.getSelectedIndex()]);
                                });
                                controls.add(identificador);
                                identificador.setEditable(false);
                                pesoTxt = new JTextField();
                                controls.add(pesoTxt);
                                panel.add(controls, BorderLayout.CENTER);
                        
                                do {
                                    bien = true;
                                    cancelado = false;
                                    opcion = JOptionPane.showConfirmDialog(null, panel, "Registrando Gallina", JOptionPane.OK_CANCEL_OPTION);
                                    System.out.println("Raza: " + identificador.getText());
                                    System.out.println("Peso: " + new String(pesoTxt.getText()));
                                    
                                    // si cancela
                                    if (opcion == JOptionPane.CANCEL_OPTION) {
                                        opcion = JOptionPane.showConfirmDialog(null, "¿Cancelar Registro de Vaca?", "Cancelando Registro de Vaca", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                                        if (opcion == JOptionPane.YES_OPTION) {
                                            bien = true;
                                            break;
                                        } else {
                                            bien = false;
                                            cancelado = true;
                                        }
                                    }

                                    // validar el peso
                                    if (!cancelado) {
                                        try {
                                            peso = Double.parseDouble(pesoTxt.getText());
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "El peso debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }
                                } while (!bien);
                                break;

                            case 1:
                                labels = new JPanel(new GridLayout(0,1,2,2));
                                labels.add(new JLabel("Raza", SwingConstants.TRAILING));
                                labels.add(new JLabel("Peso", SwingConstants.TRAILING));
                                panel.add(labels, BorderLayout.LINE_START);
                        
                                controls = new JPanel(new GridLayout(0,1,2,2));
                                raza = new JTextField("Brahman");
                                controls.add(raza);
                                raza.setEditable(false);
                                pesoTxt = new JTextField();
                                controls.add(pesoTxt);
                                panel.add(controls, BorderLayout.CENTER);
                        
                                do {
                                    bien = true;
                                    cancelado = false;
                                    opcion = JOptionPane.showConfirmDialog(null, panel, "Registrando Vaca", JOptionPane.OK_CANCEL_OPTION);
                                    System.out.println("Raza: " + raza.getText());
                                    System.out.println("Peso: " + new String(pesoTxt.getText()));
                                    
                                    // si cancela
                                    if (opcion == JOptionPane.CANCEL_OPTION) {
                                        opcion = JOptionPane.showConfirmDialog(null, "¿Cancelar Registro de Vaca?", "Cancelando Registro de Vaca", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                                        if (opcion == JOptionPane.YES_OPTION) {
                                            bien = true;
                                            break;
                                        } else {
                                            bien = false;
                                            cancelado = true;
                                        }
                                    }

                                    // validar el peso
                                    if (!cancelado) {
                                        try {
                                            peso = Double.parseDouble(pesoTxt.getText());
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "El peso debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }
                                } while (!bien);


                        
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
