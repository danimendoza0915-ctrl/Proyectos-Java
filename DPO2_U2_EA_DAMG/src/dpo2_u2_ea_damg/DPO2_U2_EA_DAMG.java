//Daniel Mendoza Gutierrez ES231109257
package dpo2_u2_ea_damg;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

// Manejo de archivos
class ArchivoManager {
    public static void guardarInformacionEnArchivo(String datos, String archivoNombre) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoNombre, true))) {
            escritor.write(datos);
            escritor.newLine();
            System.out.println("Se guardó exitosamente en el archivo: " + archivoNombre);
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + archivoNombre);
        }
    }
}

public class DPO2_U2_EA_DAMG {

    public static void main(String[] args) {
        // Ventana principal
        JFrame frame = new JFrame(" Estudiantes y becas");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menuEstudiante = new JMenu("Estudiante");
        menuBar.add(menuEstudiante);

        JMenuItem itemAltasEstudiante = new JMenuItem("Altas");
        menuEstudiante.add(itemAltasEstudiante);
        itemAltasEstudiante.addActionListener((ActionEvent e) -> {
            // Formulario de estudiante
            JPanel panelEstudiante = new JPanel(new GridLayout(7, 2));
            frame.setContentPane(panelEstudiante);

            JTextField txtNombre = new JTextField();
            JTextField txtMatricula = new JTextField();
            JTextField txtSemestre = new JTextField();
            JTextField txtCarrera = new JTextField();
            JTextField txtPromedio = new JTextField();
            JTextField txtDireccion = new JTextField();

            JButton btnGuardar = new JButton("Guardar");
            btnGuardar.addActionListener((ActionEvent event) -> {
                String informacionEstudiante = String.format("%s, %s, %s, %s, %s, %s",
                        txtNombre.getText(), txtMatricula.getText(), txtSemestre.getText(),
                        txtCarrera.getText(), txtPromedio.getText(), txtDireccion.getText());
                ArchivoManager.guardarInformacionEnArchivo(informacionEstudiante, "estudiantes.txt");
                JOptionPane.showMessageDialog(frame, "Se guardó exitosamente en la base de datos");
            });

            JButton btnSalir = new JButton("Salir");
            btnSalir.addActionListener((ActionEvent event) -> {
                frame.setContentPane(new JPanel());
                frame.setJMenuBar(menuBar);
                frame.setVisible(true);
            });

            panelEstudiante.add(new JLabel("Nombre:"));
            panelEstudiante.add(txtNombre);
            panelEstudiante.add(new JLabel("Matricula:"));
            panelEstudiante.add(txtMatricula);
            panelEstudiante.add(new JLabel("Semestre:"));
            panelEstudiante.add(txtSemestre);
            panelEstudiante.add(new JLabel("Carrera:"));
            panelEstudiante.add(txtCarrera);
            panelEstudiante.add(new JLabel("Promedio:"));
            panelEstudiante.add(txtPromedio);
            panelEstudiante.add(new JLabel("Dirección:"));
            panelEstudiante.add(txtDireccion);
            panelEstudiante.add(btnGuardar);
            panelEstudiante.add(btnSalir);

            frame.setVisible(true);
        });

        JMenu menuBeca = new JMenu("Beca");
        menuBar.add(menuBeca);

        JMenuItem itemBeca = new JMenuItem("Beca");
        menuBeca.add(itemBeca);
        itemBeca.addActionListener((ActionEvent e) -> {
            // Formulario de becas
            JPanel panelBeca = new JPanel(new GridLayout(6, 2));
            frame.setContentPane(panelBeca);

            JTextField txtMatricula = new JTextField();
            JTextField txtNombre = new JTextField();
            JComboBox<String> cbTipoBeca = new JComboBox<>(new String[] {"Desempeño académico", "Abono escolar", "Madre soltera", "Padre soltero"});
            JTextField txtFechaInicio = new JTextField();
            JTextField txtProgreso = new JTextField();

            JButton btnGuardar = new JButton("Guardar");
            btnGuardar.addActionListener((ActionEvent event) -> {
                String informacionBeca = String.format("%s, %s, %s, %s, %s",
                        txtMatricula.getText(), txtNombre.getText(), cbTipoBeca.getSelectedItem().toString(),
                        txtFechaInicio.getText(), txtProgreso.getText());
                ArchivoManager.guardarInformacionEnArchivo(informacionBeca, "becas.txt");
                JOptionPane.showMessageDialog(frame, "Se guardó exitosamente en la base de datos");
            });

            JButton btnSalir = new JButton("Salir");
            btnSalir.addActionListener((ActionEvent event) -> {
                frame.setContentPane(new JPanel());
                frame.setJMenuBar(menuBar);
                frame.setVisible(true);
            });

            panelBeca.add(new JLabel("Matricula:"));
            panelBeca.add(txtMatricula);
            panelBeca.add(new JLabel("Nombre:"));
            panelBeca.add(txtNombre);
            panelBeca.add(new JLabel("Tipo de beca:"));
            panelBeca.add(cbTipoBeca);
            panelBeca.add(new JLabel("Fecha inicio:"));
            panelBeca.add(txtFechaInicio);
            panelBeca.add(new JLabel("Progreso:"));
            panelBeca.add(txtProgreso);
            panelBeca.add(btnGuardar);
            panelBeca.add(btnSalir);

            frame.setVisible(true);
        });

        JMenu menuImprimir = new JMenu("Imprimir");
        menuBar.add(menuImprimir);

        JMenuItem itemImprimir = new JMenuItem("Imprimir");


        frame.setVisible(true);
    }
}
