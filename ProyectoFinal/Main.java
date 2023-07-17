import javax.swing.*;
import java.awt.*;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        // Objetos
        Inventario  inventario  = new Inventario();
        Vaca        vaca        = new Vaca();

        // Objetos de JAVA
        JPanel panel;
        JPanel labels, controls;
        JTextField raza, edadTxt, pesoTxt, huevosProdTxt, lechesProdTxt;
        panel       = new JPanel(new BorderLayout(5,5));
        labels      = new JPanel(new GridLayout(0,1,2,2));
        controls    = new JPanel(new GridLayout(0,1,2,2));

        // imagenes
        ImageIcon inicio = new ImageIcon("./imgs/inicio.png");


        // Variables
        int opcion, edad = 0, huevosProd = 0, lechesProd = 0;
        double peso = 0.0;
        String[] razasGallina       = {"Isa Brown", "Lohman", "Castellana Negra"};
        String[] identificadores    = {"ISBWN", "LHMN", "CTLANGR"};
        String[] opcionesInicio     = {"Acceder a Inventario", "Ventas", "Informes", "Salir"};
        String[] opcionesInventario = {"Registrar Gallina", "Registrar Vaca", "Registrar Prod.Huevos", "Registrar Prod.Leche", "Regresar"};
        boolean bien, cancelado;

        // Inicio
        do {
            opcion = JOptionPane.showOptionDialog(null, null, "Granja", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, inicio, opcionesInicio, null);
            switch (opcion) {
                case 0:
                    do {
                        opcion = JOptionPane.showOptionDialog(null, null, "Inventario de la Granja", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesInventario, null);
                        switch (opcion) {
                            case 0: // registrar GALLINA
                                panel.removeAll();
                                labels.removeAll();
                                controls.removeAll();
                                labels.add(new JLabel("Raza", SwingConstants.TRAILING));
                                labels.add(new JLabel("Identificador", SwingConstants.TRAILING));
                                labels.add(new JLabel("Edad", SwingConstants.TRAILING));
                                labels.add(new JLabel("Peso (kg)", SwingConstants.TRAILING));
                                panel.add(labels, BorderLayout.LINE_START);
                        
                                JComboBox<String>  razaG = new JComboBox<>(razasGallina);
                                controls.add(razaG);
                                JTextField identificador = new JTextField(identificadores[razaG.getSelectedIndex()]);

                                razaG.addActionListener(e -> {
                                    identificador.setText(identificadores[razaG.getSelectedIndex()]);
                                });

                                controls.add(identificador);
                                identificador.setEditable(false);
                                edadTxt = new JTextField();
                                controls.add(edadTxt);
                                pesoTxt = new JTextField();
                                controls.add(pesoTxt);
                                panel.add(controls, BorderLayout.CENTER);
                        
                                do {
                                    edadTxt.setText("");
                                    pesoTxt.setText("");
                                    bien = true;
                                    cancelado = false;
                                    opcion = JOptionPane.showConfirmDialog(null, panel, "Registrando Gallina", JOptionPane.OK_CANCEL_OPTION);
                                    System.out.println("Raza: " + identificador.getText());
                                    System.out.println("Edad: " + edadTxt.getText());
                                    System.out.println("Peso (kg): " + new String(pesoTxt.getText()));
                                    
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

                                    if (!cancelado) {
                                        // validar el peso de la Gallina
                                        try {
                                            peso = Double.parseDouble(pesoTxt.getText());
                                            // Cumple con los requisitos
                                            if (peso < 1.7 || peso > 2.2) {
                                                JOptionPane.showMessageDialog(null, "El peso debe estar entre 1,7 - 2,2 kg", "Peso no admitido - Registro Gallina", JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }
                                            
                                            // # trabajo con el objeto
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "El peso debe ser un numero", "Peso no admitido - Registro Vaca", JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }

                                    // validamos la edad de la Gallina
                                    try {
                                        edad = Integer.parseInt(edadTxt.getText());
                                        // Cumple con los requisitos
                                        if (edad < 1) {
                                            JOptionPane.showMessageDialog(null, "La edad debe ser 1 0 mayor para producción", "Edad no admitida - Registro Gallina", JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                        
                                        // # trabajo con el objeto
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "La edad debe ser un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
                                        bien = false;
                                    }
                                } while (!bien);
                                break;

                            case 1: // Registrar VACA
                                panel.removeAll();
                                labels.removeAll();
                                controls.removeAll();
                                labels.add(new JLabel("Raza", SwingConstants.TRAILING));
                                labels.add(new JLabel("Edad", SwingConstants.TRAILING));
                                labels.add(new JLabel("Peso (kg)", SwingConstants.TRAILING));
                                panel.add(labels, BorderLayout.LINE_START);
                                
                                raza = new JTextField("Brahman");
                                controls.add(raza);
                                raza.setEditable(false);
                                edadTxt = new JTextField();
                                controls.add(edadTxt);
                                pesoTxt = new JTextField();
                                controls.add(pesoTxt);
                                panel.add(controls, BorderLayout.CENTER);
                                
                                do {
                                    edadTxt.setText("");
                                    pesoTxt.setText("");
                                    bien = true;
                                    cancelado = false;
                                    opcion = JOptionPane.showConfirmDialog(null, panel, "Registrando Vaca", JOptionPane.OK_CANCEL_OPTION);
                                    System.out.println("Raza: " + raza.getText());
                                    System.out.println("Edad: " + edadTxt.getText());
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

                                    if (!cancelado) {
                                        // validar el peso de la vaca
                                        try {
                                            peso = Double.parseDouble(pesoTxt.getText());
                                            // Cumple con los requisitos
                                            if (peso < 450 || peso > 550) {
                                                JOptionPane.showMessageDialog(null, "El peso debe estar entre 450 - 550 kg", "Error", JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }
                                            
                                            // # trabajo con el objeto

                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "El peso debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }

                                        try {
                                            edad = Integer.parseInt(edadTxt.getText());
                                            // Cumple con los requisitos
                                            if (edad < 2 || edad > 12) {
                                                JOptionPane.showMessageDialog(null, "La edad de la Vaca debe estar en 2 - 12 años para Producción", "Edad fuera de rango - Registro Vaca", JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }
                                            
                                            // # trabajo con el objeto

                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "La edad debe ser un numero", "Error ingresando un numero", JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }
                                } while (!bien);


                        
                                break;
                            case 2: // Registro de produccion de huevos
                                panel.removeAll();
                                labels.removeAll();
                                controls.removeAll();
                                labels.add(new JLabel("Fecha", SwingConstants.TRAILING));
                                labels.add(new JLabel("Raza", SwingConstants.TRAILING));
                                labels.add(new JLabel("Identificador", SwingConstants.TRAILING));
                                labels.add(new JLabel("# Huevos Producidos", SwingConstants.TRAILING));
                                panel.add(labels, BorderLayout.LINE_START);
                                
                                // fecha para registro (FEATURE)
                                JTextField fecha = new JFormattedTextField(new Date());
                                fecha.setEditable(false);
                                controls.add(fecha);
                                JComboBox<String>  razaGP = new JComboBox<>(razasGallina);
                                controls.add(razaGP);
                                JTextField identificadorP = new JTextField(identificadores[razaGP.getSelectedIndex()]);

                                razaGP.addActionListener(e -> {
                                    identificadorP.setText(identificadores[razaGP.getSelectedIndex()]);
                                });

                                controls.add(identificadorP);
                                identificadorP.setEditable(false);
                                huevosProdTxt = new JTextField();
                                controls.add(huevosProdTxt);
                                panel.add(controls, BorderLayout.CENTER);

                                do {
                                    huevosProdTxt.setText("");
                                    bien = true;
                                    cancelado = false;
                                    opcion = JOptionPane.showConfirmDialog(null, panel, "Registrando Huevos Producidos", JOptionPane.OK_CANCEL_OPTION);
                                    System.out.println("Raza: " + identificadorP.getText());
                                    System.out.println("# Huevos: " + huevosProdTxt.getText());
                                    
                                    // si cancela
                                    if (opcion == JOptionPane.CANCEL_OPTION) {
                                        opcion = JOptionPane.showConfirmDialog(null, "¿Cancelar Registro de Produccion?", "Cancelando Registro de Produccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                                        if (opcion == JOptionPane.YES_OPTION) {
                                            bien = true;
                                            break;
                                        } else {
                                            bien = false;
                                            cancelado = true;
                                        }
                                    }

                                    if (!cancelado) {
                                        // validar el numero de huevos de la Gallina
                                        try {
                                            huevosProd = Integer.parseInt(huevosProdTxt.getText());
                                            // Cumple con los requisitos
                                            if (huevosProd < 0) {
                                                JOptionPane.showMessageDialog(null, "El numero de huevos no puede ser negativo", "# Huevos no admitido - Registro Produccion", JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }
                                            
                                            // # trabajo con el objeto
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "El # Huevos debe ser un numero", "# Huevos no admitido - Registro Produccion", JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }
                                } while (!bien);
                                // inventario.registrarHuevos();
                                break;
                            case 3: // Registro de produccion de leche
                                panel.removeAll();
                                labels.removeAll();
                                controls.removeAll();
                                labels.add(new JLabel("Fecha", SwingConstants.TRAILING));
                                labels.add(new JLabel("Raza", SwingConstants.TRAILING));
                                labels.add(new JLabel("# Leches Producidas", SwingConstants.TRAILING));
                                panel.add(labels, BorderLayout.LINE_START);
                                
                                // fecha para registro (FEATURE)
                                JTextField fechaL = new JFormattedTextField(new Date());
                                fechaL.setEditable(false);
                                controls.add(fechaL);
                                raza = new JTextField("Brahman");
                                controls.add(raza);
                                raza.setEditable(false);
                                lechesProdTxt = new JTextField();
                                controls.add(lechesProdTxt);
                                
                                panel.add(controls, BorderLayout.CENTER);
                                
                                do {
                                    lechesProdTxt.setText("");
                                    bien = true;
                                    cancelado = false;
                                    opcion = JOptionPane.showConfirmDialog(null, panel, "Registrando Leches Producidas", JOptionPane.OK_CANCEL_OPTION);
                                    System.out.println("Raza: " + raza.getText());
                                    System.out.println("Edad: " + lechesProdTxt.getText());
                                    
                                    // si cancela
                                    if (opcion == JOptionPane.CANCEL_OPTION) {
                                        opcion = JOptionPane.showConfirmDialog(null, "¿Cancelar Registro de Produccion de Leches?", "Cancelando Registro de Produccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

                                        if (opcion == JOptionPane.YES_OPTION) {
                                            bien = true;
                                            break;
                                        } else {
                                            bien = false;
                                            cancelado = true;
                                        }
                                    }

                                    if (!cancelado) {
                                        // validar el # leches producidas de la vaca
                                        try {
                                            lechesProd = Integer.parseInt(lechesProdTxt.getText());
                                            // Cumple con los requisitos
                                            if (lechesProd < 0) {
                                                JOptionPane.showMessageDialog(null, "El # de leches producidas no puede ser negativo", "Numero no admitido - Registro Produccion", JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }
                                            
                                            // # trabajo con el objeto

                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "El # de leches producidas debe ser un numero", "Error ingresando un numero", JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }
                                } while (!bien);
                                // inventario.registrarLeche();
                                break;
                            case 4: // Regresar
                                opcion = JOptionPane.CLOSED_OPTION;
                                break;
                            
                        }
                    } while (opcion != JOptionPane.CLOSED_OPTION);
                    opcion = 0;
                    break;
                case 1:
                    // Ventas ventas = new Ventas();
                    
                    break;
                case 2:
                    // Informes informes = new Informes();
                    
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (opcion != JOptionPane.CLOSED_OPTION);
    }
}
