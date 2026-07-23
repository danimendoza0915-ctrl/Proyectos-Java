//Daniel Mendoza Gutierrez ES231109257
package dpo2_u3_a2_damg;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class DPO2_U3_A2_DAMG {
    public static void main(String[] args) {
        // Configuración del frame principal
        JFrame frame = new JFrame("Sistema de Gestión de Libros");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creación de la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Creación del menú y submenús de formulario libros
        JMenu librosMenu = new JMenu("Formulario para libros");
        JMenuItem registrarItem = new JMenuItem("Registrar libro");
        JMenuItem eliminarItem = new JMenuItem("Eliminar libro");

        // Acciones para el submenú de registro
        registrarItem.addActionListener((ActionEvent e) -> {
            registrarLibro();
        });

        // Acciones para el submenú de eliminación
        eliminarItem.addActionListener((ActionEvent e) -> {
            eliminarLibro();
        });

        librosMenu.add(registrarItem);
        librosMenu.add(eliminarItem);

        // Creación del menú y submenús de Reportes
        JMenu reportesMenu = new JMenu("Reportes de libro");
        JMenuItem consultarLibrosItem = new JMenuItem("Reporte de libros registrados");
        consultarLibrosItem.addActionListener((ActionEvent e) -> {
            consultarLibros();
        });
        reportesMenu.add(consultarLibrosItem);

        // Creación del menú para Cerrar aplicación
        JMenu salirMenu = new JMenu("Cerrar aplicación");
        JMenuItem salirItem = new JMenuItem("Cerrar aplicación");
        salirItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        salirMenu.add(salirItem);

        // Agregando los menús a la barra de menú
        menuBar.add(librosMenu);
        menuBar.add(reportesMenu);
        menuBar.add(salirMenu);

        // Configurando la barra de menú en el frame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    // Función para registrar un libro
    public static void registrarLibro() {
        JFrame registroFrame = new JFrame("Registrar Libro");

        // Componentes para el formulario de registro
        JLabel idLabel = new JLabel("Id libro: ");
        JTextField idField = new JTextField(15);
        JLabel titleLabel = new JLabel("Título del libro: ");
        JTextField titleField = new JTextField(15);
        JLabel autorLabel = new JLabel("Autor del libro: ");
        JTextField autorField = new JTextField(15);
        JLabel fechaLabel = new JLabel("Fecha de publicación del libro: ");
        JTextField fechaField = new JTextField(15);

        JButton guardarButton = new JButton("Guardar datos del libro");
        guardarButton.addActionListener((ActionEvent event) -> {
            int IdLibro = Integer.parseInt(idField.getText());
            String Titulo = titleField.getText();
            String Autor = autorField.getText();
            String FechaPublicación = fechaField.getText();

            Atributos nuevoLibro = new Atributos(IdLibro, Titulo, Autor, FechaPublicación);

            GestiónBaseDeDatos gestor = new GestiónBaseDeDatos();
            gestor.insertarLibro(nuevoLibro);

            JOptionPane.showMessageDialog(registroFrame, "Libro ingresado correctamente");
        });

        JButton RegresarButton = new JButton("Regresar al menú");
        RegresarButton.addActionListener((ActionEvent e1) -> {
            registroFrame.dispose();
        });

        JPanel panelRegistro= new JPanel();
        panelRegistro.setLayout(new GridLayout(6,1, 5, 5));
        panelRegistro.add(idLabel);
        panelRegistro.add(idField);
        panelRegistro.add(titleLabel);
        panelRegistro.add(titleField);
        panelRegistro.add(autorLabel);
        panelRegistro.add(autorField);
        panelRegistro.add(fechaLabel);
        panelRegistro.add(fechaField);
        panelRegistro.add(guardarButton);
        panelRegistro.add(RegresarButton);
        registroFrame.add(panelRegistro);

        registroFrame.setSize(400,300);
        registroFrame.setVisible(true);
    }

    // Función para eliminar un libro
    public static void eliminarLibro() {
        JFrame eliminarFrame = new JFrame("Eliminar Libro");

        // Componentes para el formulario de eliminación
        JLabel idEliminarLabel = new JLabel("Ingrese el id del libro a eliminar: ");
        JTextField idEliminarField = new JTextField(15);

        JButton eliminarButton = new JButton("Eliminar libro");
        eliminarButton.addActionListener((ActionEvent event) -> {
            int id = Integer.parseInt(idEliminarField.getText());
            GestiónBaseDeDatos gestor = new GestiónBaseDeDatos();
            try {
                gestor.eliminarLibro(id);
            } catch (HeadlessException e1) {
                e1.printStackTrace();
            } finally {
                gestor.cerrarConexion();
            }
        });

        JButton RegresarButton = new JButton("Regresar al menú principal");
        RegresarButton.addActionListener((ActionEvent e1) -> {
            eliminarFrame.dispose();
        });

        JPanel panelEliminar = new JPanel();
        panelEliminar.setLayout(new GridLayout(3,1, 10, 10));
        panelEliminar.add(idEliminarLabel);
        panelEliminar.add(idEliminarField
        );
        panelEliminar.add(eliminarButton);
        panelEliminar.add(RegresarButton);
        eliminarFrame.add(panelEliminar);

        eliminarFrame.setSize(450, 300);
        eliminarFrame.setVisible(true);
    }

    // Función para consultar libros
    public static void consultarLibros() {
        GestiónBaseDeDatos gestor = new GestiónBaseDeDatos();
        List<Atributos> listaLibros = gestor.consultarLibros();

        if (listaLibros != null) {
            for (Atributos libro : listaLibros) {
                System.out.println("ID: " + libro.getIdLibro() + ", Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() + ", Fecha de Publicación: " + libro.getFechaPublicacion());
            }
        } else {
            System.out.println("No se puede realizar la consultar los libros.");
        }

        gestor.cerrarConexion();
    }
}       
