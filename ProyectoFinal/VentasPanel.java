import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class VentasPanel extends JPanel {
    public JPanel ventaHuevoPanel, ventaLechePanel, totalPanel;
    public JTextField precioVentaHuevo, cantDocenasHuevo, precioVentaLeche, cantLitrosLeche;
    public JLabel subTotalHuevoTxt, subTotalLecheTxt, totalTxt;
    public VentasPanel() {
        ventaHuevoPanel = new JPanel(new GridLayout(4, 2, 2, 2));
        ventaLechePanel = new JPanel(new GridLayout(4, 2, 2, 2));
        totalPanel = new JPanel(new BorderLayout(5, 5));
        
        setBorder(BorderFactory.createTitledBorder("Sistema de Ventas"));
        setLayout(new BorderLayout(5, 5));
        // venta de huevos
        ventaHuevoPanel.setBorder(BorderFactory.createTitledBorder("Venta de Huevos (docena)"));
        precioVentaHuevo = new JTextField();
        cantDocenasHuevo = new JTextField();
        subTotalHuevoTxt = new JLabel("0");
        subTotalHuevoTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ventaHuevoPanel.add(new JLabel("Precio Venta"));
        ventaHuevoPanel.add(precioVentaHuevo);
        ventaHuevoPanel.add(new JLabel("Cantidad de Docenas"));
        ventaHuevoPanel.add(cantDocenasHuevo);
        ventaHuevoPanel.add(new JLabel("SubTotal $"));
        ventaHuevoPanel.add(subTotalHuevoTxt);

        // venta de leche
        ventaLechePanel.setBorder(BorderFactory.createTitledBorder("Venta de Leche (litros)"));
        precioVentaLeche = new JTextField();
        cantLitrosLeche = new JTextField();
        subTotalLecheTxt = new JLabel("0");
        subTotalLecheTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ventaLechePanel.add(new JLabel("Precio Venta"));
        ventaLechePanel.add(precioVentaLeche);
        ventaLechePanel.add(new JLabel("Cantidad de Litros"));
        ventaLechePanel.add(cantLitrosLeche);
        ventaLechePanel.add(new JLabel("SubTotal $"));
        ventaLechePanel.add(subTotalLecheTxt);

        // panel para el total
        totalTxt = new JLabel("Total: $0.00");
        totalTxt.setForeground(Color.RED);
        totalTxt.setFont(new Font("Arial", Font.BOLD, 20));
        totalPanel.add(new JLabel("Total $"));
        totalPanel.add(totalTxt);

        // agregar los componentes al panel principal
        add(ventaHuevoPanel, BorderLayout.WEST);
        add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.CENTER);
        add(ventaLechePanel, BorderLayout.EAST);
        add(totalTxt, BorderLayout.SOUTH);
        // Escuchadores para detectar cambios en los campos de entrada
        precioVentaHuevo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarSubtotalHuevo();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarSubtotalHuevo();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarSubtotalHuevo();
            }
        });

        cantDocenasHuevo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarSubtotalHuevo();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarSubtotalHuevo();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarSubtotalHuevo();
            }
        });

        precioVentaLeche.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarSubtotalLeche();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarSubtotalLeche();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarSubtotalLeche();
            }
        });

        cantLitrosLeche.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarSubtotalLeche();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarSubtotalLeche();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarSubtotalLeche();
            }
        });
    }

    public void actualizarSubtotalHuevo() {
        try {
            double precio = Double.parseDouble(precioVentaHuevo.getText());
            int cantidad = Integer.parseInt(cantDocenasHuevo.getText());
            double subtotal = precio * cantidad;
            subTotalHuevoTxt.setText(String.format("%.2f", subtotal));
            actualizarTotal();
        } catch (NumberFormatException ex) {
            subTotalHuevoTxt.setText("0.00");
            actualizarTotal();
        }
    }

    public void actualizarSubtotalLeche() {
        try {
            double precio = Double.parseDouble(precioVentaLeche.getText());
            int cantidad = Integer.parseInt(cantLitrosLeche.getText());
            double subtotal = precio * cantidad;
            subTotalLecheTxt.setText("" + String.format("%.2f", subtotal));
            actualizarTotal();
        } catch (NumberFormatException ex) {
            subTotalLecheTxt.setText("0.00");
            actualizarTotal();
        }
    }

    public void actualizarTotal() {
        double huevoSubtotal = Double.parseDouble(subTotalHuevoTxt.getText());
        double lecheSubtotal = Double.parseDouble(subTotalLecheTxt.getText());
        double total = huevoSubtotal + lecheSubtotal;
        totalTxt.setText("Total: $" + String.format("%.2f", total));
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         JFrame frame = new JFrame("Ventas");
    //         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //         VentasPanel ventasPanel = new VentasPanel();
    //         ventasPanel.totalTxt = new JLabel("Total: 0.00");
    //         ventasPanel.totalTxt.setForeground(Color.RED);
    //         ventasPanel.add(ventasPanel.totalTxt);
    //         frame.add(ventasPanel);
    //         frame.pack();
    //         frame.setVisible(true);
    //     });
    // }
}
