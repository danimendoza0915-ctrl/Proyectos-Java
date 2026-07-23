package susaludprimero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SuSaludPrimero extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane;
    private JPanel citaPanel, pedidoPanel, formularioCitaPanel, formularioPagoPanel;
    private JButton agendarCitaButton, ordenarPedidoButton, pagarButton, regresarButton;
    private JTextField nombreTextField, edadTextField, telefonoTextField, emailTextField;
    private JTextField nombrePagoTextField, numeroTarjetaTextField, mesAnioTextField, cvvTextField;
    private JTable[] tablasMedicamentos;
    private DefaultTableModel[] modelosTablas;
    private final String[] tiposMedicamentos = {"Precio Regular", "Ofertas", "Liquidación"};
    private final int MIN_MEDICAMENTOS = 10;
    private final int MAX_MEDICAMENTOS = 15;

    public SuSaludPrimero() {
        setTitle("SuSaludPrimero - Sistema de Gestión Hospitalaria");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        configurarCitaPanel();
        configurarPedidoPanel();

        tabbedPane.addTab("Cita", citaPanel);
        tabbedPane.addTab("Pedido de Medicamento", pedidoPanel);

        add(tabbedPane);

        setVisible(true);
    }

    private void configurarCitaPanel() {
        citaPanel = new JPanel(new BorderLayout());
        formularioCitaPanel = new JPanel(new GridLayout(5, 2));

        nombreTextField = new JTextField();
        edadTextField = new JTextField();
        telefonoTextField = new JTextField();
        emailTextField = new JTextField();

        formularioCitaPanel.add(new JLabel("Nombre: "));
        formularioCitaPanel.add(nombreTextField);
        formularioCitaPanel.add(new JLabel("Edad: "));
        formularioCitaPanel.add(edadTextField);
        formularioCitaPanel.add(new JLabel("Teléfono: "));
        formularioCitaPanel.add(telefonoTextField);
        formularioCitaPanel.add(new JLabel("Email: "));
        formularioCitaPanel.add(emailTextField);

        agendarCitaButton = new JButton("Agendar Cita");
        agendarCitaButton.addActionListener(this);

        citaPanel.add(formularioCitaPanel, BorderLayout.CENTER);
        citaPanel.add(agendarCitaButton, BorderLayout.SOUTH);
    }

    private void configurarPedidoPanel() {
        pedidoPanel = new JPanel(new BorderLayout());

        JPanel tablasPanel = new JPanel(new GridLayout(1, 3));
        tablasMedicamentos = new JTable[3];
        modelosTablas = new DefaultTableModel[3];

        for (int i = 0; i < 3; i++) {
            modelosTablas[i] = new DefaultTableModel(new String[]{"Seleccionar", "Nombre", "Fecha Caducidad", "Precio", "Cantidad"}, 0);
            tablasMedicamentos[i] = new JTable(modelosTablas[i]);
            JScrollPane scrollPane = new JScrollPane(tablasMedicamentos[i]);
            scrollPane.setBorder(BorderFactory.createTitledBorder(tiposMedicamentos[i]));
            cargarMedicamentos(modelosTablas[i]);
            tablasPanel.add(scrollPane);
        }

        ordenarPedidoButton = new JButton("Ordenar Pedido");
        ordenarPedidoButton.addActionListener(this);

        JPanel ordenarPedidoPanel = new JPanel();
        ordenarPedidoPanel.add(ordenarPedidoButton);

        pedidoPanel.add(tablasPanel, BorderLayout.CENTER);
        pedidoPanel.add(ordenarPedidoPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agendarCitaButton) {
            JOptionPane.showMessageDialog(this, "Favor de confirmar cita vía email.");
            limpiarFormularioCita();
        } else if (e.getSource() == ordenarPedidoButton) {
            mostrarFormularioPago();
        } else if (e.getSource() == pagarButton) {
            procesarPago();
        } else if (e.getSource() == regresarButton) {
            regresarAPantallaPedidoMedicamentos();
        }
    }

    private void limpiarFormularioCita() {
        nombreTextField.setText("");
        edadTextField.setText("");
        telefonoTextField.setText("");
        emailTextField.setText("");
    }

    private void cargarMedicamentos(DefaultTableModel model) {
        Random random = new Random();
        int numMedicamentos = random.nextInt(MAX_MEDICAMENTOS - MIN_MEDICAMENTOS + 1) + MIN_MEDICAMENTOS;
        for (int i = 0; i < numMedicamentos; i++) {
            String nombre = "Medicamento " + (i + 1);
            String fechaCaducidad = "20/12/2025";
            double precio = random.nextDouble() * 100 + 10;
            int cantidad = random.nextInt(50) + 10;
            model.addRow(new Object[]{false, nombre, fechaCaducidad, precio, cantidad});
        }
    }

    private void mostrarFormularioPago() {
        formularioPagoPanel = new JPanel(new GridLayout(7, 2));

        nombrePagoTextField = new JTextField();
        numeroTarjetaTextField = new JTextField();
        mesAnioTextField = new JTextField();
        cvvTextField = new JTextField();

        formularioPagoPanel.add(new JLabel("Nombre: "));
        formularioPagoPanel.add(nombrePagoTextField);
        formularioPagoPanel.add(new JLabel("Número de Tarjeta: "));
        formularioPagoPanel.add(numeroTarjetaTextField);
        formularioPagoPanel.add(new JLabel("Mes y Año de Expiración: "));
        formularioPagoPanel.add(mesAnioTextField);
        formularioPagoPanel.add(new JLabel("CVV: "));
        formularioPagoPanel.add(cvvTextField);

        pagarButton = new JButton("Pagar");
        pagarButton.addActionListener(this);

        regresarButton = new JButton("Regresar");
        regresarButton.addActionListener(this);

        formularioPagoPanel.add(pagarButton);
        formularioPagoPanel.add(regresarButton);

        pedidoPanel.removeAll();
        pedidoPanel.add(formularioPagoPanel, BorderLayout.CENTER);
        pedidoPanel.revalidate();
        pedidoPanel.repaint();
    }

    private void procesarPago() {
        restarInventario();

        JOptionPane.showMessageDialog(this, "Pago exitoso. Número de orden: XXXXX. Fecha de entrega: XX/XX/XXXX.");
        regresarAPantallaPedidoMedicamentos();
    }

    private void restarInventario() {
        for (DefaultTableModel model : modelosTablas) {
            for (int i = 0; i < model.getRowCount(); i++) {
                Boolean seleccionado = (Boolean) model.getValueAt(i, 0);
                if (seleccionado != null && seleccionado) {
                    int cantidad = (int) model.getValueAt(i, 4);
                    model.setValueAt(cantidad - 1, i, 4);
                }
            }
        }
    }

    private void regresarAPantallaPedidoMedicamentos() {
        pedidoPanel.removeAll();
        pedidoPanel.add(tablasMedicamentos, BorderLayout.CENTER);
        pedidoPanel.add(ordenarPedidoPanel, BorderLayout.SOUTH);
        pedidoPanel.revalidate();
        pedidoPanel.repaint();
        tabbedPane.setSelectedIndex(1); // Selecciona la pestaña de Pedido de Medicamentos
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SuSaludPrimero::new);
    }
}




