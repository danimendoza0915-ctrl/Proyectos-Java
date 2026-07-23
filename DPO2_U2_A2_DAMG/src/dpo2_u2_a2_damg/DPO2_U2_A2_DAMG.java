//Daniel Mendoza Gutierrez Matricula: ES231109257
package dpo2_u2_a2_damg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DPO2_U2_A2_DAMG implements ActionListener {
    // Componentes de la interfaz
    private JFrame frame;
    private JPanel panelPrincipal;
    private JButton botonAltaRopa, botonBajaRopa, botonConsultas, botonSalir;
    private JTextField campoClaveRopa, campoNombreRopa, campoDescripcionRopa;
    private JButton botonGuardar, botonRegresarAlta;
    private JTextField campoClaveRopaBaja;
    private JButton botonEliminarBaja, botonRegresarBaja;
    private JTextField campoClaveRopaConsultas;
    private JButton botonBuscarConsultas, botonRegresarConsultas;
    private String nombreEstudiante = "Daniel Mendoza Gutierrez";
    private String matriculaEstudiante = "ES231109257";

    public DPO2_U2_A2_DAMG() {
        // Ventana principal
        frame = new JFrame("Almacén de Ropa Blanquita - Sistema de Inventario");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel principal
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(6, 1));

        //Creación de la imagen 
        ImageIcon imagen = new ImageIcon("imagen/Actividaddos.jpg");
        JLabel etiqueta = new JLabel(imagen);

        //Botones del menú principal
        botonAltaRopa = new JButton("AltaRopa");
        botonAltaRopa.addActionListener(this);

        botonBajaRopa = new JButton("BajaRopa");
        botonBajaRopa.addActionListener(this);

        botonConsultas = new JButton("Consultas");
        botonConsultas.addActionListener(this);

        botonSalir = new JButton("Salir");
        botonSalir.addActionListener(this);

        // Añadir los componentes al panel principal
        panelPrincipal.add(etiqueta);
        panelPrincipal.add(botonAltaRopa);
        panelPrincipal.add(botonBajaRopa);
        panelPrincipal.add(botonConsultas);
        panelPrincipal.add(botonSalir);

        // Añadir el panel principal a la ventana
        frame.add(panelPrincipal);
        frame.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        // Acciones de cada botón
        if (e.getSource() == botonAltaRopa) {
            // Formulario AltaRopa
            JFrame altaRopaFrame = new JFrame("AltaRopa");
            altaRopaFrame.setSize(300, 200);
            altaRopaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel altaRopaPanel = new JPanel();
            altaRopaPanel.setLayout(new GridLayout(4, 2));

            campoClaveRopa = new JTextField();
            campoNombreRopa = new JTextField();
            campoDescripcionRopa = new JTextField();
            botonGuardar = new JButton("Guardar");
            botonRegresarAlta = new JButton("Regresar");

            botonGuardar.addActionListener(this);
            botonRegresarAlta.addActionListener(this);

            altaRopaPanel.add(new JLabel("Clave de Ropa:"));
            altaRopaPanel.add(campoClaveRopa);
            altaRopaPanel.add(new JLabel("Nombre de Ropa:"));
            altaRopaPanel.add(campoNombreRopa);
            altaRopaPanel.add(new JLabel("Descripción de Ropa:"));
            altaRopaPanel.add(campoDescripcionRopa);
            altaRopaPanel.add(botonGuardar);
            altaRopaPanel.add(botonRegresarAlta);

            altaRopaFrame.add(altaRopaPanel);
            altaRopaFrame.setVisible(true);
            } else if (e.getSource() == botonBajaRopa) {
            //Formulario BajaRopa
            JFrame bajaRopaFrame = new JFrame("BajaRopa");
            bajaRopaFrame.setSize(300, 200);
            bajaRopaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel bajaRopaPanel = new JPanel();
            bajaRopaPanel.setLayout(new GridLayout(2, 2));

            campoClaveRopaBaja = new JTextField();
            botonEliminarBaja = new JButton("Eliminar");
            botonRegresarBaja = new JButton("Regresar");

            botonEliminarBaja.addActionListener(this);
            botonRegresarBaja.addActionListener(this);

            bajaRopaPanel.add(new JLabel("Clave de Ropa:"));
            bajaRopaPanel.add(campoClaveRopaBaja);
            bajaRopaPanel.add(botonEliminarBaja);
            bajaRopaPanel.add(botonRegresarBaja);

            bajaRopaFrame.add(bajaRopaPanel);
            bajaRopaFrame.setVisible(true);
            } else if (e.getSource() == botonConsultas) {
            // Formulario Consultas
            JFrame consultasFrame = new JFrame("Consultas");
            consultasFrame.setSize(300, 200);
            consultasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel consultasPanel = new JPanel();
            consultasPanel.setLayout(new GridLayout(2, 2));

            campoClaveRopaConsultas = new JTextField();
            botonBuscarConsultas = new JButton("Buscar");
            botonRegresarConsultas = new JButton("Regresar");

            botonBuscarConsultas.addActionListener(this);
            botonRegresarConsultas.addActionListener(this);

            consultasPanel.add(new JLabel("Clave de Ropa:"));
            consultasPanel.add(campoClaveRopaConsultas);
            consultasPanel.add(botonBuscarConsultas);
            consultasPanel.add(botonRegresarConsultas);

            consultasFrame.add(consultasPanel);
            consultasFrame.setVisible(true);
        } else if (e.getSource() == botonSalir) {
            // Acción del botón Salir
            JOptionPane.showMessageDialog(null, nombreEstudiante + "_" + matriculaEstudiante + ": Esta acción cerrará la interfaz gráfica");
            System.exit(0);
        } else if (e.getSource() == botonGuardar) {
            // Acción del botón Guardar
            JOptionPane.showMessageDialog(null, nombreEstudiante + "_" + matriculaEstudiante + ": No es posible guardar el producto porque no existe conexión a Base de datos");
        } else if (e.getSource() == botonEliminarBaja) {
            // Acción del botón Eliminar
            JOptionPane.showMessageDialog(null, nombreEstudiante + "_" + matriculaEstudiante + ": No es posible eliminar el producto porque no existe conexión a Base de datos");
        } else if (e.getSource() == botonBuscarConsultas) {
            // Acción del botón Buscar
            JOptionPane.showMessageDialog(null, nombreEstudiante + "_" + matriculaEstudiante + ": No es posible buscar el producto porque no existe conexión a Base de datos");
        } else if (e.getSource() == botonRegresarAlta || e.getSource() == botonRegresarBaja || e.getSource() == botonRegresarConsultas) {
            // Acción del botón Regresar
            ((JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource())).dispose();
        }
    }

    public static void main(String[] args) {
        new DPO2_U2_A2_DAMG();
    }
}