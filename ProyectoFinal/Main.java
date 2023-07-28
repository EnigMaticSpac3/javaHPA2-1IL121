import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            // Objetos
            Inventario inventario = new Inventario();
            Vaca vaca = new Vaca();
            Gallina gallina = new Gallina();
            VentasPanel ventasPanel = new VentasPanel();
            Factura factura = new Factura();

            // Objetos de JAVA
            JPanel panel, inventarioPanel, inventarioGallinaLabels, inventarioVacaLabels, facturaPanel, panelInforme;
            JPanel labels, controls, inventarioGallina1, inventarioGallina2,
                    inventarioGallina3, inventarioVaca, facturaLabels, facturaCamposHuevo, facturaCamposLeche,
                    facturaCabeza, facturaMedio, facturaPie, informeAnimales, informeHuevos, informeHuevos1,
                    informeHuevos2, informeHuevos3, informeFactura, informeFacturaLabels, informeLeche;
            JTextField razaV, edadTxt, pesoTxt, huevosProdTxt, lechesProdTxt;

            panel = new JPanel(new BorderLayout(5, 5));
            labels = new JPanel(new GridLayout(0, 1, 2, 2));
            controls = new JPanel(new GridLayout(0, 1, 2, 2));
            inventarioPanel = new JPanel(new GridLayout(12, 6, 2, 2));
            inventarioGallinaLabels = new JPanel(new GridLayout(1, 6, 2, 2));
            inventarioGallina1 = new JPanel(new GridLayout(1, 6, 2, 2));
            inventarioGallina2 = new JPanel(new GridLayout(1, 6, 2, 2));
            inventarioGallina3 = new JPanel(new GridLayout(1, 6, 2, 2));
            inventarioVacaLabels = new JPanel(new GridLayout(1, 5, 2, 2));
            inventarioVaca = new JPanel(new GridLayout(1, 3, 2, 2));
            facturaPanel = new JPanel(new BorderLayout(5, 5));
            facturaLabels = new JPanel(new GridLayout(1, 4, 2, 2));
            facturaCamposHuevo = new JPanel(new GridLayout(1, 4, 2, 2));
            facturaCamposLeche = new JPanel(new GridLayout(1, 4, 2, 2));
            facturaCabeza = new JPanel(new GridLayout(0, 1, 2, 2));
            facturaMedio = new JPanel(new GridLayout(4, 4, 3, 3));
            facturaPie = new JPanel(new GridLayout(3, 1, 2, 2));
            panelInforme = new JPanel(new GridLayout(0, 2, 2, 2));
            informeAnimales = new JPanel(new GridLayout(0, 5, 5, 5));
            informeHuevos = new JPanel(new BorderLayout(2, 2));
            informeHuevos1 = new JPanel(new GridLayout(0, 3, 4, 4));
            informeHuevos2 = new JPanel(new GridLayout(0, 3, 4, 4));
            informeHuevos3 = new JPanel(new GridLayout(0, 3, 4, 4));
            informeFactura = new JPanel(new GridLayout(0, 5, 3, 3));
            informeFacturaLabels = new JPanel(new GridLayout(1, 5, 3, 3));
            informeLeche = new JPanel(new GridLayout(0, 2, 3, 3));

            // imagenes
            ImageIcon inicio = new ImageIcon("./imgs/inicio.png");
            ImageIcon informe = new ImageIcon("./imgs/granjaInforme.jpg");

            // Variables
            int opcion, edad = 0, huevosProd = 0, lechesProd = 0, cantDocenaHuevo = 0, cantLitrosLeche = 0, numRegistro;
            double peso = 0.0, totalVentaHuevos = 0, totalVentaLeche = 0, totalVenta = 0, precioVentaLeche = 0,
                    precioVentaHuevo = 0;
            String raza;
            String[] razasGallina = { "Isa Brown", "Lohman", "Castellana Negra" };
            String[] identificadores = { "ISBWN", "LHMN", "CTLANGR" };
            String[] opcionesInforme = { "Historial Animales", "Historial Prod. Huevos", "Historial Prod. Leche",
                    "Historial Facturas", "Salir" };
            String[] opcionesInicio = { "Acceder a Inventario", "Ventas", "Informes", "Salir" };
            String[] opcionesInventario = { "Registrar Gallina", "Registrar Vaca", "Registrar Prod.Huevos",
                    "Registrar Prod.Leche", "Regresar" };
            boolean bien, cancelado;

            // Inicio
            do { // todo el programa
                 // PANTALLA DE INICIO
                opcion = JOptionPane.showOptionDialog(null,
                        "",
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
                            inventarioGallinaLabels.add(new JLabel("Huevos Vendidos", SwingConstants.CENTER));
                            inventarioGallinaLabels.add(new JLabel("Huevos Disponibles", SwingConstants.CENTER));

                            // Fila 1 de las Gallinas
                            inventarioGallina1.add(new JLabel("Isa Brown"));
                            inventarioGallina1.add(new JLabel("ISBWN", SwingConstants.CENTER));
                            inventarioGallina1.add(new JLabel(Integer.toString(inventario.getCantidadGallinas()[0]),
                                    SwingConstants.CENTER));
                            inventarioGallina1
                                    .add(new JLabel(Integer.toString(inventario.getHuevosProducidos()[0]),
                                            SwingConstants.CENTER));
                            inventarioGallina1.add(new JLabel(Integer.toString(inventario.getHuevosVendidos()[0]),
                                    SwingConstants.CENTER));
                            inventarioGallina1
                                    .add(new JLabel(Integer.toString(inventario.getHuevosDisponibles()[0]) + " huevos",
                                            SwingConstants.CENTER));

                            // Fila 2 de las Gallinas
                            inventarioGallina2.add(new JLabel("Lohman"));
                            inventarioGallina2.add(new JLabel("LHMN", SwingConstants.CENTER));
                            inventarioGallina2.add(new JLabel(Integer.toString(inventario.getCantidadGallinas()[1]),
                                    SwingConstants.CENTER));
                            inventarioGallina2
                                    .add(new JLabel(Integer.toString(inventario.getHuevosProducidos()[1]),
                                            SwingConstants.CENTER));
                            inventarioGallina2.add(new JLabel(Integer.toString(inventario.getHuevosVendidos()[1]),
                                    SwingConstants.CENTER));
                            inventarioGallina2
                                    .add(new JLabel(Integer.toString(inventario.getHuevosDisponibles()[1]) + " huevos",
                                            SwingConstants.CENTER));

                            // Fila 3 de las Gallinas
                            inventarioGallina3.add(new JLabel("Castellana Negra", SwingConstants.LEFT));
                            inventarioGallina3.add(new JLabel("CTLANGR", SwingConstants.CENTER));
                            inventarioGallina3.add(new JLabel(Integer.toString(inventario.getCantidadGallinas()[2]),
                                    SwingConstants.CENTER));
                            inventarioGallina3
                                    .add(new JLabel(Integer.toString(inventario.getHuevosProducidos()[2]),
                                            SwingConstants.CENTER));
                            inventarioGallina3.add(new JLabel(Integer.toString(inventario.getHuevosVendidos()[2]),
                                    SwingConstants.CENTER));
                            inventarioGallina3
                                    .add(new JLabel(Integer.toString(inventario.getHuevosDisponibles()[2]) + " huevos",
                                            SwingConstants.CENTER));

                            // Labels de las Vacas
                            inventarioVacaLabels.add(new JLabel("Raza"));
                            inventarioVacaLabels.add(new JLabel("Cantidad", SwingConstants.CENTER));
                            inventarioVacaLabels.add(new JLabel("Producción de Leche (litros)", SwingConstants.CENTER));
                            inventarioVacaLabels.add(new JLabel("Leche Vendida", SwingConstants.CENTER));
                            inventarioVacaLabels.add(new JLabel("Leche Disponible", SwingConstants.CENTER));

                            // Fila de las Vacas
                            inventarioVaca.add(new JLabel("Brahman"));
                            inventarioVaca.add(
                                    new JLabel(Integer.toString(inventario.getCantidadVacas()), SwingConstants.CENTER));
                            inventarioVaca.add(new JLabel(Integer.toString(inventario.getCantidadLeche()),
                                    SwingConstants.CENTER));
                            inventarioVaca.add(
                                    new JLabel(Integer.toString(inventario.getLecheVendida()), SwingConstants.CENTER));
                            inventarioVaca.add(new JLabel(Integer.toString(inventario.getLecheDisponible()) + " litros",
                                    SwingConstants.CENTER));

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
                                    JTextField identificador = new JTextField(
                                            identificadores[razaG.getSelectedIndex()]);

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
                                                            "La edad debe ser 1 o mayor para producción",
                                                            "Edad no admitida - Registro Gallina",
                                                            JOptionPane.ERROR_MESSAGE);
                                                    bien = false;
                                                }
                                                if (edad > 6) {
                                                    JOptionPane.showMessageDialog(null,
                                                            "La edad de la gallina no se acepta. Está fuera de la vida útil",
                                                            "Edad no admitida - Registro Gallina",
                                                            JOptionPane.ERROR_MESSAGE);
                                                    bien = false;
                                                }
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
                                                gallina.asignar(edad, peso, razaG.getSelectedItem().toString(),
                                                        identificador.getText());
                                                // registramos la gallina en la lista enlazada
                                                Gallina gallinaR = new Gallina();
                                                gallinaR.asignar(edad, peso, razaG.getSelectedItem().toString(),
                                                        identificador.getText());
                                                inventario.registrarGallina(gallinaR);

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
                                                    vaca.asignar(edad, peso, razaV.getText());
                                                    // registrar en la lista enlazada
                                                    Vaca vacaR = new Vaca();
                                                    vacaR.asignar(edad, peso, razaV.getText());
                                                    inventario.registrarVaca(vacaR);

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
                                    JTextField identificadorP = new JTextField(
                                            identificadores[razaGP.getSelectedIndex()]);

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
                                                gallina.setRaza(razaGP.getSelectedItem().toString());
                                                gallina.setProduccionHuevos(huevosProd);

                                                // registrar en la lista enlazada
                                                Gallina gallinaRP = new Gallina();
                                                gallinaRP.setRaza(razaGP.getSelectedItem().toString());
                                                gallinaRP.setProduccionHuevos(huevosProd);
                                                inventario.registrarHuevos(gallinaRP, identificadorP.getText(),
                                                        gallinaRP.getProduccionHuevos());

                                                System.out.println("Raza: " + identificadorP.getText());
                                                System.out.println("# Huevos: " + huevosProd);
                                            }
                                        }
                                    } while (!bien);
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
                                                vaca.setLecheProducida(lechesProd);

                                                // guardar registro en la lista enlazada
                                                Vaca vacaR = new Vaca();
                                                vacaR.setLecheProducida(lechesProd);
                                                inventario.registrarLeche(vacaR, lechesProd);

                                                System.out.println("Raza: " + razaV.getText());
                                                System.out.println("# Leches Prod: " + lechesProd);
                                            }
                                        }
                                    } while (!bien);
                                    break;
                                case 4: // Regresar
                                    opcion = JOptionPane.CLOSED_OPTION;
                                    break;

                            }
                        } while (opcion != JOptionPane.CLOSED_OPTION);
                        opcion = 0;
                        break;
                    case 1:
                        // reseteamos los TextField del panel
                        ventasPanel.nombreCliente.setText("");
                        ventasPanel.cantLitrosLeche.setText("");
                        ventasPanel.cantDocenasHuevo.setText("");
                        ventasPanel.precioVentaLeche.setText("");
                        ventasPanel.precioVentaHuevo.setText("");
                        do {
                            bien = true;
                            cancelado = false;
                            opcion = JOptionPane.showConfirmDialog(null, ventasPanel,
                                    "Registrando Venta",
                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                            // si cancela
                            if (opcion == JOptionPane.CANCEL_OPTION) {
                                opcion = JOptionPane.showConfirmDialog(null,
                                        "¿Cancelar Venta?",
                                        "Cancelando Venta", JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE, null);

                                if (opcion == JOptionPane.YES_OPTION) {
                                    bien = true;
                                    break;
                                } else {
                                    bien = false;
                                    cancelado = true;
                                }
                            }

                            // validamos los datos ingresados
                            if (!cancelado) {
                                // validar el # leches producidas de la vaca
                                try {
                                    cantLitrosLeche = Integer.parseInt(ventasPanel.cantLitrosLeche.getText());
                                    // Cumple con los requisitos
                                    if (cantLitrosLeche < 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "El # de leches vendidas no puede ser negativo",
                                                "Numero no admitido - Registro Venta",
                                                JOptionPane.ERROR_MESSAGE);
                                        bien = false;
                                    }

                                    // verificar que la cantidad de leches solicitadas no sobrepase la cantidad disponible.
                                    if (cantLitrosLeche > inventario.getLecheDisponible()) {
                                        JOptionPane.showMessageDialog(null,
                                                "El # de Litros solicitados sobrepasa la cantidad disponible",
                                                "Cantidad no aceptada", JOptionPane.ERROR_MESSAGE);
                                        bien = false;
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "El # de leches vendidas debe ser un numero",
                                            "Error ingresando un numero",
                                            JOptionPane.ERROR_MESSAGE);
                                    bien = false;
                                }
                                // validar el # huevos vendidos de la gallina
                                try {
                                    cantDocenaHuevo = Integer.parseInt(ventasPanel.cantDocenasHuevo.getText());
                                    // Cumple con los requisitos
                                    if (cantDocenaHuevo < 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "El # de huevos vendidos no puede ser negativo",
                                                "Numero no admitido - Registro Venta",
                                                JOptionPane.ERROR_MESSAGE);
                                        bien = false;
                                    }

                                    // verificar que la cantidad solcitada no sobrepase la cantidad de huevos
                                    // disponibles
                                    if (cantDocenaHuevo > inventario.getHuevosDisponibles()[0]) {
                                        JOptionPane.showMessageDialog(null,
                                                "La cantidad de huevos solicitados sobrepasa la cantidad de huevos disponibles",
                                                "Cantidad de huevos no disponible",
                                                JOptionPane.ERROR_MESSAGE);
                                        bien = false;
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "El # de huevos vendidos debe ser un numero",
                                            "Error ingresando un numero",
                                            JOptionPane.ERROR_MESSAGE);
                                    bien = false;
                                }
                                // validar el precio de venta de la leche
                                try {
                                    precioVentaLeche = Double.parseDouble(ventasPanel.precioVentaLeche.getText());
                                    // Cumple con los requisitos
                                    if (precioVentaLeche < 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "El precio de venta de la leche no puede ser negativo",
                                                "Numero no admitido - Registro Venta",
                                                JOptionPane.ERROR_MESSAGE);
                                        bien = false;
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "El precio de venta de la leche debe ser un numero",
                                            "Error ingresando un numero",
                                            JOptionPane.ERROR_MESSAGE);
                                    bien = false;
                                }
                                // validar el precio de venta de los huevos
                                try {
                                    precioVentaHuevo = Double.parseDouble(ventasPanel.precioVentaHuevo.getText());
                                    // Cumple con los requisitos
                                    if (precioVentaHuevo < 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "El precio de venta de los huevos no puede ser negativo",
                                                "Numero no admitido - Registro Venta",
                                                JOptionPane.ERROR_MESSAGE);
                                        bien = false;
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "El precio de venta de los huevos debe ser un numero",
                                            "Error ingresando un numero",
                                            JOptionPane.ERROR_MESSAGE);
                                    bien = false;
                                }

                                
                            }
                            
                            // si todo salió bien, creamos la factura y la guardamos en el registro.
                            if (bien) {
                                // llamamos a los metodos de venta
                                if (cantDocenaHuevo > 0) {
                                    raza = identificadores[ventasPanel.razaG.getSelectedIndex()];
                                    inventario.venderHuevos(raza, cantDocenaHuevo);
                                }
    
                                if (cantLitrosLeche > 0) {
                                    inventario.venderLeche(cantLitrosLeche);
                                }
                                // totalVenta = Double.parseDouble(ventasPanel.totalTxt.getText());
                                precioVentaHuevo = Double.parseDouble(ventasPanel.precioVentaHuevo.getText());
                                precioVentaLeche = Double.parseDouble(ventasPanel.precioVentaLeche.getText());
                                cantDocenaHuevo = Integer.parseInt(ventasPanel.cantDocenasHuevo.getText());
                                cantLitrosLeche = Integer.parseInt(ventasPanel.cantLitrosLeche.getText());
                                totalVentaHuevos = cantDocenaHuevo * precioVentaHuevo;
                                totalVentaLeche = cantLitrosLeche * precioVentaLeche;
                                totalVenta = totalVentaHuevos + totalVentaLeche;
                                factura.asignar(ventasPanel.nombreCliente.getText(), new Date().toString(), totalVenta,
                                        precioVentaHuevo, precioVentaLeche, cantDocenaHuevo, cantLitrosLeche);

                                // guardamos la factura en el registro
                                // registrar factura en la lista enlazada
                                Factura facturaR = new Factura();
                                facturaR.asignar(ventasPanel.nombreCliente.getText(), new Date().toString(), totalVenta,
                                        precioVentaHuevo, precioVentaLeche, cantDocenaHuevo, cantLitrosLeche);
                                inventario.registrarFactura(facturaR);

                                facturaPanel.removeAll();
                                facturaCabeza.removeAll();
                                facturaLabels.removeAll();
                                facturaCamposHuevo.removeAll();
                                facturaCamposLeche.removeAll();
                                facturaMedio.removeAll();
                                facturaPie.removeAll();

                                facturaCabeza.add(new JLabel(
                                        "======================= FACTURA DE VENTA ======================= "));
                                facturaCabeza.add(new JLabel("Fecha: " + factura.getFechaFactura()));
                                facturaCabeza.add(new JLabel("Número de Factura: 00" + factura.getNumeroFactura()));
                                facturaCabeza.add(new JLabel("================================================"));
                                facturaCabeza.add(new JLabel("Cliente: " + factura.getNombreCliente()));
                                facturaCabeza.add(new JLabel("-----------------------------------------------"));

                                facturaLabels.add(new JLabel("Producto"));
                                facturaLabels.add(new JLabel("Cantidad"/* , SwingConstants.CENTER */));
                                facturaLabels.add(new JLabel("Precio Unitario"/* , SwingConstants.CENTER */));
                                facturaLabels.add(new JLabel("Valor Total"/* , SwingConstants.CENTER */));

                                facturaCamposHuevo.add(new JLabel("Huevos (docenas)"));
                                facturaCamposHuevo.add(new JLabel(String.format("%d", cantDocenaHuevo)));
                                facturaCamposHuevo.add(new JLabel(String.format("%.2f", precioVentaHuevo)));
                                facturaCamposHuevo.add(new JLabel(String.format("%.2f", totalVentaHuevos)));

                                facturaCamposLeche.add(new JLabel("Leche (litros)"));
                                facturaCamposLeche.add(new JLabel(String.format("%d", cantLitrosLeche)));
                                facturaCamposLeche.add(new JLabel(String.format("%.2f", precioVentaLeche)));
                                facturaCamposLeche.add(new JLabel(String.format("%.2f", totalVentaLeche)));

                                facturaMedio.add(facturaLabels);
                                facturaMedio.add(new JSeparator());
                                if (cantDocenaHuevo > 0)
                                    facturaMedio.add(facturaCamposHuevo);
                                if (cantLitrosLeche > 0)
                                    facturaMedio.add(facturaCamposLeche);

                                facturaPie.add(new JSeparator());
                                facturaPie.add(new JLabel(String.format("TOTAL VENTA: $%.2f%n", totalVenta)));
                                facturaPie.add(new JSeparator());

                                facturaPanel.add(facturaCabeza, BorderLayout.NORTH);
                                facturaPanel.add(facturaMedio, BorderLayout.CENTER);
                                facturaPanel.add(facturaPie, BorderLayout.SOUTH);

                                // Mostrar la factura en un JOptionPane con un JPanel personalizado
                                JOptionPane.showMessageDialog(null, facturaPanel,
                                        "Factura de Venta", JOptionPane.PLAIN_MESSAGE);

                            }
                        } while (!bien);

                        break;
                    case 2: // Informes
                        do {
                            bien = true;
                            panel.removeAll();

                            panel.add(new JLabel("Seleccione el informe que desea generar:"), BorderLayout.SOUTH);
                            panel.add(new JSeparator());
                            panel.add(new JLabel(informe), BorderLayout.CENTER);

                            opcion = JOptionPane.showOptionDialog(null,
                                    panel,
                                    "Informes de la granja",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    opcionesInforme, null);

                            switch (opcion) {
                                case 0: // Informe de Registros de Animales en la granja
                                    panel.removeAll();
                                    informeAnimales.removeAll();

                                    informeAnimales.add(new JLabel("# Registro"));
                                    informeAnimales.add(new JLabel("Tipo", SwingConstants.CENTER));
                                    informeAnimales.add(new JLabel("Raza", SwingConstants.CENTER));
                                    informeAnimales.add(new JLabel("Edad", SwingConstants.CENTER));
                                    informeAnimales.add(new JLabel("Peso", SwingConstants.CENTER));
                                    // informeAnimales.add(new JSeparator());

                                    // llamamos a la lista enlazada del Registro de Animales e imprimimos sus
                                    // valores con un for-loop
                                    numRegistro = 0;
                                    for (Animal animal : inventario.registro.getAnimalesRegistrados()) {
                                        informeAnimales.add(new JLabel("R#" + ++numRegistro));
                                        // para saber el tipo de animal
                                        if (animal.getNombreRaza().equals("Brahman")) {
                                            informeAnimales.add(new JLabel("Vaca", SwingConstants.CENTER));
                                        } else {
                                            informeAnimales.add(new JLabel("Gallina", SwingConstants.CENTER));
                                        }
                                        informeAnimales.add(new JLabel(animal.getNombreRaza(), SwingConstants.CENTER));
                                        informeAnimales.add(new JLabel("" + animal.getEdad(), SwingConstants.CENTER));
                                        informeAnimales.add(new JLabel("" + animal.getPeso(), SwingConstants.CENTER));
                                    }

                                    panel.add(new JLabel("Historial de Registro de Animales"), BorderLayout.NORTH);
                                    panel.add(informeAnimales, BorderLayout.SOUTH);

                                    JOptionPane.showMessageDialog(null, panel, "Historial de Registro de Animales",
                                            JOptionPane.INFORMATION_MESSAGE, null);
                                    break;

                                case 1: // historial de registro de Producción de Huevos
                                    panel.removeAll();
                                    informeHuevos1.removeAll();
                                    informeHuevos2.removeAll();
                                    informeHuevos3.removeAll();

                                    informeHuevos1.setBorder(BorderFactory.createTitledBorder("Isa Brown"));
                                    informeHuevos1.add(new JLabel("# Registro"));
                                    informeHuevos1.add(new JLabel("Raza", SwingConstants.CENTER));
                                    informeHuevos1.add(new JLabel("Producción", SwingConstants.CENTER));
                                    // informeHuevos1.add(new JSeparator());

                                    // llamamos a la lista enlazada del Registro de Produccion de los Huevos de Isa
                                    // Brown
                                    // con un for-loop
                                    numRegistro = 0;
                                    for (Gallina gallinas : inventario.registro.getProdGallinas1()) {
                                        if (gallinas.getNombreRaza() == "Isa Brown") {
                                            informeHuevos1.add(new JLabel("R#" + ++numRegistro));
                                            informeHuevos1
                                                    .add(new JLabel(gallinas.getNombreRaza(), SwingConstants.CENTER));
                                            informeHuevos1.add(new JLabel("" + gallinas.getProduccionHuevos(),
                                                    SwingConstants.CENTER));
                                        }
                                    }

                                    numRegistro = 0;
                                    informeHuevos2.setBorder(BorderFactory.createTitledBorder("Lohman"));
                                    informeHuevos2.add(new JLabel("# Registro"));
                                    informeHuevos2.add(new JLabel("Raza", SwingConstants.CENTER));
                                    informeHuevos2.add(new JLabel("Producción", SwingConstants.CENTER));
                                    for (Gallina gallinas : inventario.registro.getProdGallinas2()) {
                                        if (gallinas.getNombreRaza() == "Lohman") {
                                            informeHuevos2.add(new JLabel("R#" + ++numRegistro));
                                            informeHuevos2
                                                    .add(new JLabel(gallinas.getNombreRaza(), SwingConstants.CENTER));
                                            informeHuevos2.add(new JLabel("" + gallinas.getProduccionHuevos(),
                                                    SwingConstants.CENTER));
                                        }
                                    }

                                    numRegistro = 0;
                                    informeHuevos3.setBorder(BorderFactory.createTitledBorder("Castellana Negra"));
                                    informeHuevos3.add(new JLabel("# Registro"));
                                    informeHuevos3.add(new JLabel("Raza", SwingConstants.CENTER));
                                    informeHuevos3.add(new JLabel("Producción", SwingConstants.CENTER));
                                    for (Gallina gallinas : inventario.registro.getProdGallinas3()) {
                                        if (gallinas.getNombreRaza() == "Castellana Negra") {
                                            informeHuevos3.add(new JLabel("R#" + ++numRegistro));
                                            informeHuevos3
                                                    .add(new JLabel(gallinas.getNombreRaza(), SwingConstants.CENTER));
                                            informeHuevos3.add(new JLabel("" + gallinas.getProduccionHuevos(),
                                                    SwingConstants.CENTER));
                                        }
                                    }

                                    informeHuevos.add(informeHuevos1, BorderLayout.NORTH);
                                    informeHuevos.add(informeHuevos2, BorderLayout.CENTER);
                                    informeHuevos.add(informeHuevos3, BorderLayout.SOUTH);

                                    panel.add(new JLabel("Historial de Registro de Producción de los Huevos por Raza"),
                                            BorderLayout.NORTH);
                                    panel.add(new JSeparator());
                                    panel.add(informeHuevos, BorderLayout.CENTER);

                                    JOptionPane.showMessageDialog(null, panel, "Historial de Registro de Animales",
                                            JOptionPane.INFORMATION_MESSAGE, null);
                                    break;

                                case 2:
                                    panel.removeAll();
                                    informeLeche.removeAll();

                                    informeLeche.setBorder(
                                            BorderFactory.createTitledBorder("Historial Registro de Leches"));
                                    informeLeche.add(new JLabel("# Registro"));
                                    informeLeche.add(new JLabel("Producción de Leches (litro)"));
                                    informeLeche.add(new JSeparator());
                                    informeLeche.add(new JSeparator());
                                    numRegistro = 0;
                                    for (Vaca vacas : inventario.registro.getProdLeche()) {
                                        informeLeche.add(new JLabel("R#" + ++numRegistro));
                                        informeLeche.add(new JLabel("" + vacas.getLecheProducida()));
                                    }
                                    panel.add(informeLeche, BorderLayout.CENTER);
                                    JOptionPane.showMessageDialog(null, panel,
                                            "Historial de Registro de Leches Producidas",
                                            JOptionPane.INFORMATION_MESSAGE, null);
                                    break;

                                case 3:
                                    panel.removeAll();
                                    informeFactura.removeAll();
                                    informeFacturaLabels.removeAll();

                                    informeFacturaLabels.add(new JLabel("N. Factura"));
                                    informeFacturaLabels.add(new JLabel("Cliente", SwingConstants.CENTER));
                                    informeFacturaLabels.add(new JLabel("Leches", SwingConstants.CENTER));
                                    informeFacturaLabels.add(new JLabel("Huevo (docenas)", SwingConstants.CENTER));
                                    informeFacturaLabels.add(new JLabel("Total B./", SwingConstants.CENTER));

                                    for (Factura facturas : inventario.registro.getFacturasRegistradas()) {
                                        informeFactura.add(new JLabel("00" + facturas.getNumeroFactura()));
                                        informeFactura
                                                .add(new JLabel(facturas.getNombreCliente(), SwingConstants.CENTER));
                                        informeFactura.add(new JLabel("" + facturas.getCantidadLitrosLeche(),
                                                SwingConstants.CENTER));
                                        informeFactura.add(new JLabel("" + facturas.getCantidadDocenasHuevo(),
                                                SwingConstants.CENTER));
                                        informeFactura.add(
                                                new JLabel("" + facturas.getTotalFactura(), SwingConstants.CENTER));
                                    }

                                    panel.add(informeFacturaLabels, BorderLayout.NORTH);
                                    panel.add(informeFactura, BorderLayout.CENTER);

                                    JOptionPane.showMessageDialog(null, panel, "Historial de Registro de Facturas",
                                            JOptionPane.INFORMATION_MESSAGE, null);
                                    break;
                            }
                        } while (!bien);

                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            } while (opcion != JOptionPane.CLOSED_OPTION);
        });
    }

}