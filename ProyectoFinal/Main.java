import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Objetos
        Inventario inventario = new Inventario(0, 0);
        Vaca vaca = new Vaca();

        // Objetos de JAVA
        JPanel panel, inicioPanel, inventarioPanel, inventarioGallinaLabels, inventarioVacaLabels;
        JPanel labels, controls, mensaje, inicioLabels, inicioControls, inventarioGallina1, inventarioGallina2, inventarioGallina3, inventarioVaca;
        JTextField razaV, edadTxt, pesoTxt, huevosProdTxt, lechesProdTxt, cantGallinasTxt, cantVacasTxt;
        panel                       = new JPanel(new BorderLayout(5, 5));
        inicioPanel                 = new JPanel(new BorderLayout(5, 5));
        labels                      = new JPanel(new GridLayout(0, 1, 2, 2));
        controls                    = new JPanel(new GridLayout(0, 1, 2, 2));
        mensaje                     = new JPanel(new GridLayout(0, 1, 0, 5));
        inicioLabels                = new JPanel(new GridLayout(4, 1, 10, 10));
        inicioControls              = new JPanel(new GridLayout(4, 1, 10, 10));
        inventarioPanel             = new JPanel(new GridLayout(12, 4, 2, 2));
        inventarioGallinaLabels     = new JPanel(new GridLayout(1, 4, 2, 2));
        inventarioGallina1          = new JPanel(new GridLayout(1, 4, 2, 2));
        inventarioGallina2          = new JPanel(new GridLayout(1, 4, 2, 2));
        inventarioGallina3          = new JPanel(new GridLayout(1, 4, 2, 2));
        inventarioVacaLabels        = new JPanel(new GridLayout(1, 3, 2, 2));
        inventarioVaca              = new JPanel(new GridLayout(1, 3, 2, 2));

        // imagenes
        ImageIcon inicio = new ImageIcon("./imgs/inicio.png");

        // Variables
        int opcion, edad = 0, huevosProd = 0, lechesProd = 0, cantGallinas = 0, cantVacas = 0;
        double peso = 0.0;
        String panelInventario;
        String[] razasGallina = { "Isa Brown", "Lohman", "Castellana Negra" };
        String[] identificadores = { "ISBWN", "LHMN", "CTLANGR" };
        String[] opcionesIngreso = { "Ingresar", "Salir" };
        String[] opcionesInicio = { "Acceder a Inventario", "Ventas", "Informes", "Salir" };
        String[] opcionesInventario = { "Registrar Gallina", "Registrar Vaca", "Registrar Prod.Huevos",
                "Registrar Prod.Leche", "Regresar" };
        boolean bien, cancelado, iniciado;

        // Inicio
        iniciado = false; // con esto sabemos el estado del programa (iniciado o no)
        do { // todo el programa
            if (!iniciado) {
                do {
                    iniciado = true; // con esto sabemos que ya se inicio
                    panel.removeAll();
                    inicioPanel.removeAll();
                    mensaje.removeAll();
                    inicioLabels.removeAll();
                    inicioControls.removeAll();

                    mensaje.add(new JLabel("Iniciando el Sistema", SwingConstants.CENTER));
                    mensaje.add(new JLabel("Ingrese la capacidad de su granja:", SwingConstants.CENTER));
                    mensaje.add(new JLabel("", SwingConstants.CENTER));
                    mensaje.add(new JLabel(""));
                    panel.add(mensaje, BorderLayout.NORTH);

                    inicioLabels.add(new JLabel("Gallinas:", SwingConstants.TRAILING));
                    inicioLabels.add(new JLabel("Vacas:", SwingConstants.TRAILING));
                    inicioPanel.add(inicioLabels, BorderLayout.LINE_START);

                    cantGallinasTxt = new JTextField();
                    inicioControls.add(cantGallinasTxt);
                    cantVacasTxt = new JTextField();
                    inicioControls.add(cantVacasTxt);
                    inicioPanel.add(inicioControls, BorderLayout.CENTER);

                    panel.add(inicioPanel, BorderLayout.CENTER);

                    opcion = JOptionPane.showOptionDialog(null,
                            panel,
                            "Granja", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE,
                            inicio,
                            opcionesIngreso, null);

                    if (opcion == JOptionPane.CLOSED_OPTION || opcion == 1) {
                        System.exit(0);
                    }
                    // validamos los datos ingresados
                    try {
                        cantGallinas = Integer.parseInt(cantGallinasTxt.getText());
                        cantVacas = Integer.parseInt(cantVacasTxt.getText());
                        // Cumple con los requisitos
                        if (cantGallinas < 0 || cantVacas < 0) {
                            JOptionPane.showMessageDialog(null,
                                    "La cantidad de Gallinas y Vacas no puede ser negativa",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            iniciado = false;

                        } else {
                            inventario = new Inventario(cantGallinas, cantVacas);
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "La cantidad de Gallinas y Vacas debe ser un numero",
                                "Error ingresando un numero",
                                JOptionPane.ERROR_MESSAGE);
                        iniciado = false;
                    }
                } while (!iniciado);
            }

            // PANTALLA DE INICIO
            opcion = JOptionPane.showOptionDialog(null,
                    "________________________________"
                            + "\nCapacidad de la Granja\n"
                            + "Gallinas: " + cantGallinas + "\n"
                            + "Vacas: " + cantVacas + "\n"
                            + "_______________________________"
                            + "\nEspacio Disponible\n"
                            + "Gallinas: " + inventario.gallinas.length + "\n"
                            + "Vacas: " + inventario.vaca.length + "\n",
                    "Granja", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    inicio,
                    opcionesInicio, null);

            switch (opcion) {
                case 0:
                    do {
                        inventarioPanel.removeAll();
                        inventarioGallinaLabels.removeAll();
                        inventarioGallina1.removeAll();
                        inventarioGallina2.removeAll();
                        inventarioGallina3.removeAll();
                        inventarioVacaLabels.removeAll();
                        inventarioVaca.removeAll();
                         
                        inventarioPanel.setBorder(BorderFactory.createTitledBorder("Inventario de la Granja"));
                        inventarioGallinaLabels.add(new JLabel("Raza"));
                        inventarioGallinaLabels.add(new JLabel("Identificador", SwingConstants.CENTER));
                        inventarioGallinaLabels.add(new JLabel("Cantidad", SwingConstants.CENTER));
                        inventarioGallinaLabels.add(new JLabel("Producción de Huevos", SwingConstants.CENTER));

                        // Fila 1 de las Gallinas
                        inventarioGallina1.add(new JLabel("Isa Brown"));
                        inventarioGallina1.add(new JLabel("ISBWN", SwingConstants.CENTER));
                        inventarioGallina1.add(new JLabel("20", SwingConstants.CENTER));
                        inventarioGallina1.add(new JLabel("10 huevos", SwingConstants.CENTER));

                        // Fila 2 de las Gallinas
                        inventarioGallina2.add(new JLabel("Lohman"));
                        inventarioGallina2.add(new JLabel("LHMN", SwingConstants.CENTER));
                        inventarioGallina2.add(new JLabel("15", SwingConstants.CENTER));
                        inventarioGallina2.add(new JLabel("8 huevos", SwingConstants.CENTER));
                        
                        // Fila 3 de las Gallinas
                        inventarioGallina3.add(new JLabel("Castellana Negra"));
                        inventarioGallina3.add(new JLabel("CTLANGR", SwingConstants.CENTER));
                        inventarioGallina3.add(new JLabel("12", SwingConstants.CENTER));
                        inventarioGallina3.add(new JLabel("6 huevos", SwingConstants.CENTER));
                        
                        // Labels de las Vacas
                        inventarioVacaLabels.add(new JLabel("Raza"));
                        inventarioVacaLabels.add(new JLabel("Cantidad", SwingConstants.CENTER));
                        inventarioVacaLabels.add(new JLabel("Producción de Leche (litros)", SwingConstants.CENTER));

                        // Fila de las Vacas
                        inventarioVaca.add(new JLabel("Brahman"));
                        inventarioVaca.add(new JLabel("5", SwingConstants.CENTER));
                        inventarioVaca.add(new JLabel("20 litros", SwingConstants.CENTER));

                        inventarioPanel.add(new JLabel(""));
                        inventarioPanel.add(new JLabel("Gallinas"));
                        inventarioPanel.add(inventarioGallinaLabels);
                        inventarioPanel.add(new JSeparator());
                        inventarioPanel.add(inventarioGallina1);
                        inventarioPanel.add(inventarioGallina2);
                        inventarioPanel.add(inventarioGallina3);
                        inventarioPanel.add(new JLabel(""));
                        inventarioPanel.add(new JLabel("Vacas:"));
                        inventarioPanel.add(inventarioVacaLabels);
                        inventarioPanel.add(new JSeparator());
                        inventarioPanel.add(inventarioVaca);      

                        panelInventario = ""
                        + "----------------Inventario----------------\n"
                        + "Gallinnas:\n"
                        + "Raza\t|\tIdentificador\t|\tCantidad\t|\tProducción de Huevos\n"
                        + "";
                        opcion = JOptionPane.showOptionDialog(null,
                                inventarioPanel,
                                "Inventario de la Granja",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null,
                                opcionesInventario, null);
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

                                JComboBox<String> razaG = new JComboBox<>(razasGallina);
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
                                    opcion = JOptionPane.showConfirmDialog(null, panel,
                                            "Registrando Gallina",
                                            JOptionPane.OK_CANCEL_OPTION);

                                    // si cancela
                                    if (opcion == JOptionPane.CANCEL_OPTION) {
                                        opcion = JOptionPane.showConfirmDialog(null,
                                                "¿Cancelar Registro de Gallina?",
                                                "Cancelando Registro de Gallina",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null);

                                        if (opcion == JOptionPane.YES_OPTION) {
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
                                                JOptionPane.showMessageDialog(null,
                                                        "El peso debe estar entre 1,7 - 2,2 kg",
                                                        "Peso no admitido - Registro Gallina",
                                                        JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }

                                            // # trabajo con el objeto
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El peso debe ser un numero",
                                                    "Peso no admitido - Registro Vaca",
                                                    JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }

                                        // validamos la edad de la Gallina
                                        try {
                                            edad = Integer.parseInt(edadTxt.getText());
                                            // Cumple con los requisitos
                                            if (edad < 1) {
                                                JOptionPane.showMessageDialog(null,
                                                        "La edad debe ser 1 0 mayor para producción",
                                                        "Edad no admitida - Registro Gallina",
                                                        JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }

                                            // # trabajo con el objeto
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "La edad debe ser un numero entero",
                                                    "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }

                                    if (bien) {
                                        // confirmar registro
                                        opcion = JOptionPane.showConfirmDialog(null,
                                                "¿Registrar Gallina?\n"
                                                        + "Usted ha ingresado lo siguiente:\n"
                                                        + "Raza: " + identificador.getText() + "\n"
                                                        + "Edad: " + edadTxt.getText() + "\n"
                                                        + "Peso: " + pesoTxt.getText() + "\n",
                                                "Confirmar Registro de Gallina",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null);
                                        if (opcion == JOptionPane.NO_OPTION) {
                                            bien = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "Gallina Registrada Exitosamente",
                                                    "Registro Exitoso",
                                                    JOptionPane.INFORMATION_MESSAGE);

                                            // # trabajo con el objeto
                                            System.out.println("Raza: " + identificador.getText());
                                            System.out.println("Edad: " + edad);
                                            System.out.println("Peso (kg): " + peso);
                                        }
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

                                razaV = new JTextField("Brahman");
                                controls.add(razaV);
                                razaV.setEditable(false);
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
                                    opcion = JOptionPane.showConfirmDialog(null, panel,
                                            "Registrando Vaca",
                                            JOptionPane.OK_CANCEL_OPTION);

                                    // si cancela
                                    if (opcion == JOptionPane.CANCEL_OPTION) {
                                        opcion = JOptionPane.showConfirmDialog(null,
                                                "¿Cancelar Registro de Vaca?",
                                                "Cancelando Registro de Vaca",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null);

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
                                                JOptionPane.showMessageDialog(null,
                                                        "El peso debe estar entre 450 - 550 kg",
                                                        "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El peso debe ser un numero",
                                                    "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }

                                        try {
                                            edad = Integer.parseInt(edadTxt.getText());
                                            // Cumple con los requisitos
                                            if (edad < 2 || edad > 12) {
                                                JOptionPane.showMessageDialog(null,
                                                        "La edad de la Vaca debe estar en 2 - 12 años para Producción",
                                                        "Edad fuera de rango - Registro Vaca",
                                                        JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "La edad debe ser un numero",
                                                    "Error ingresando un numero",
                                                    JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }

                                        // confirmar registro
                                        if (bien) {
                                            opcion = JOptionPane.showConfirmDialog(null,
                                                    "¿Registrar Vaca?\n"
                                                            + "Usted ha ingresado lo siguiente:\n"
                                                            + "Raza: " + razaV.getText() + "\n"
                                                            + "Edad: " + edadTxt.getText() + "\n"
                                                            + "Peso: " + pesoTxt.getText() + "\n",
                                                    "Confirmar Registro de Vaca",
                                                    JOptionPane.YES_NO_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE, null);
                                            if (opcion == JOptionPane.NO_OPTION) {
                                                bien = false;
                                            } else {
                                                JOptionPane.showMessageDialog(null,
                                                        " Vaca Registrada Exitosamente",
                                                        "Registro Exitoso",
                                                        JOptionPane.INFORMATION_MESSAGE);

                                                // # trabajo con el objeto
                                                System.out.println("Raza: " + razaV.getText());
                                                System.out.println("Edad: " + edad);
                                                System.out.println("Peso: " + peso);
                                            }
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
                                JComboBox<String> razaGP = new JComboBox<>(razasGallina);
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
                                    opcion = JOptionPane.showConfirmDialog(null, panel,
                                            "Registrando Huevos Producidos",
                                            JOptionPane.OK_CANCEL_OPTION);

                                    // si cancela
                                    if (opcion == JOptionPane.CANCEL_OPTION) {
                                        opcion = JOptionPane.showConfirmDialog(null,
                                                "¿Cancelar Registro de Produccion?",
                                                "Cancelando Registro de Produccion", JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null);

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
                                                JOptionPane.showMessageDialog(null,
                                                        "El numero de huevos no puede ser negativo",
                                                        "# Huevos no admitido - Registro Produccion",
                                                        JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }

                                            // # trabajo con el objeto
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El # Huevos debe ser un numero",
                                                    "# Huevos no admitido - Registro Produccion",
                                                    JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }

                                    if (bien) {
                                        // confirmar registro
                                        opcion = JOptionPane.showConfirmDialog(null,
                                                "¿Registrar Producción de Huevos?\n"
                                                        + "Usted ha ingresado lo siguiente:\n"
                                                        + "Raza: " + razaGP.getSelectedItem() + " "
                                                        + "(" + identificadorP.getText() + ")" + "\n"
                                                        + "# Huevos Prod: " + huevosProd + "\n",
                                                "Confirmar Producción de Huevos",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null);
                                        if (opcion == JOptionPane.NO_OPTION) {
                                            bien = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    "Producción Registrada Exitosamente",
                                                    "Registro Exitoso",
                                                    JOptionPane.INFORMATION_MESSAGE);

                                            // # trabajo con el objeto
                                            System.out.println("Raza: " + razaGP.getSelectedItem());
                                            System.out.println("# Huevos: " + huevosProd);
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
                                labels.add(new JLabel("# Leches Prod. (litros)", SwingConstants.TRAILING));
                                panel.add(labels, BorderLayout.LINE_START);

                                // fecha para registro (FEATURE)
                                JTextField fechaL = new JFormattedTextField(new Date());
                                fechaL.setEditable(false);
                                controls.add(fechaL);
                                razaV = new JTextField("Brahman");
                                controls.add(razaV);
                                razaV.setEditable(false);
                                lechesProdTxt = new JTextField();
                                controls.add(lechesProdTxt);

                                panel.add(controls, BorderLayout.CENTER);

                                do {
                                    lechesProdTxt.setText("");
                                    bien = true;
                                    cancelado = false;
                                    opcion = JOptionPane.showConfirmDialog(null, panel,
                                            "Registrando Leches Producidas",
                                            JOptionPane.OK_CANCEL_OPTION);

                                    // si cancela
                                    if (opcion == JOptionPane.CANCEL_OPTION) {
                                        opcion = JOptionPane.showConfirmDialog(null,
                                                "¿Cancelar Registro de Produccion de Leches?",
                                                "Cancelando Registro de Produccion", JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null);

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
                                                JOptionPane.showMessageDialog(null,
                                                        "El # de leches producidas no puede ser negativo",
                                                        "Numero no admitido - Registro Produccion",
                                                        JOptionPane.ERROR_MESSAGE);
                                                bien = false;
                                            }

                                            // # trabajo con el objeto

                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El # de leches producidas debe ser un numero",
                                                    "Error ingresando un numero",
                                                    JOptionPane.ERROR_MESSAGE);
                                            bien = false;
                                        }
                                    }

                                    // confirmar registro
                                    if (bien) {
                                        opcion = JOptionPane.showConfirmDialog(null,
                                                "¿Registrar Producción?\n"
                                                        + "Usted ha ingresado lo siguiente:\n"
                                                        + "Raza: " + razaV.getText() + "\n"
                                                        + "# Leches Prod: " + lechesProd + "\n",
                                                "Confirmar Producción de Leche",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE, null);
                                        if (opcion == JOptionPane.NO_OPTION) {
                                            bien = false;
                                        } else {
                                            JOptionPane.showMessageDialog(null,
                                                    " Producción Registrada Exitosamente",
                                                    "Registro Exitoso",
                                                    JOptionPane.INFORMATION_MESSAGE);

                                            // # trabajo con el objeto
                                            System.out.println("Raza: " + razaV.getText());
                                            System.out.println("# Leches Prod: " + lechesProd);
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
