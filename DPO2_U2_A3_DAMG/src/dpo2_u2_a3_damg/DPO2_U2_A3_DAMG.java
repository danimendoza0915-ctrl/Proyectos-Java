//Daniel Mendoza Gutierrez Matricula: ES231109257
package dpo2_u2_a3_damg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DPO2_U2_A3_DAMG {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Mueblería La Única");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear la barra de menús
        JMenuBar menuBar = new JMenuBar();

        // Crear los menús
        JMenu menuEmpresa = new JMenu("Empresa");
        JMenu menuCatalogos = new JMenu("Catálogos");

        // Añadir submenús a Empresa
        JMenuItem abrirEmpresaItem = new JMenuItem("Iniciar Empresa");
        JMenuItem cerrarEmpresaItem = new JMenuItem("Finalizar Empresa");

        abrirEmpresaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Empresa iniciada");
            }
        });

        cerrarEmpresaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Empresa finalizada");
            }
        });

        menuEmpresa.add(abrirEmpresaItem);
        menuEmpresa.add(cerrarEmpresaItem);

        // Crear los submenús para Catálogos
        JMenuItem clientesItem = new JMenuItem("Clientes");
        JMenuItem proveedoresItem = new JMenuItem("Proveedores");
        JMenuItem productoItem = new JMenuItem("Producto");

        // Añadir ActionListener a los submenús
        clientesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar el formulario de clientes
                new ClienteForm().setVisible(true);
            }
        });

        proveedoresItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar el formulario de proveedores
                new ProveedorForm().setVisible(true);
            }
        });

        productoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crear y mostrar el formulario de productos
                new ProductoForm().setVisible(true);
            }
        });

        // Añadir submenús a Catálogos
        menuCatalogos.add(clientesItem);
        menuCatalogos.add(proveedoresItem);
        menuCatalogos.add(productoItem);

        // Añadir los menús a la barra de menús
        menuBar.add(menuEmpresa);
        menuBar.add(menuCatalogos);

        // Añadir la barra de menús a la ventana
        frame.setJMenuBar(menuBar);

        // Configurar el tamaño de la ventana y hacerla visible
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

// Formulario de clientes
class ClienteForm extends JFrame {
    public ClienteForm() {
        setTitle("Clientes");
        setSize(300, 200);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Clave del cliente"));
        add(new JTextField());

        add(new JLabel("Nombre del cliente"));
        add(new JTextField());

        add(new JLabel("RFC"));
        add(new JTextField());

        add(new JLabel("Domicilio"));
        add(new JTextField());

        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Datos del cliente aceptados");
            }
        });

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Datos del cliente guardados");
            }
        });

        add(aceptarButton);
        add(guardarButton);
        add(cerrarButton);
    }
}

// Formulario de proveedores
class ProveedorForm extends JFrame {
    public ProveedorForm() {
        setTitle("Proveedores");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Clave del proveedor"));
        add(new JTextField());

        add(new JLabel("Nombre del proveedor"));
        add(new JTextField());

        add(new JLabel("RFC"));
        add(new JTextField());

        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Datos del proveedor aceptados");
            }
        });

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Datos del proveedor guardados");
            }
        });

        add(aceptarButton);
        add(guardarButton);
        add(cerrarButton);
    }
}

// Formulario de productos
class ProductoForm extends JFrame {
    public ProductoForm() {
        setTitle("Productos");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Clave del producto"));
        add(new JTextField());

        add(new JLabel("Nombre del producto"));
        add(new JTextField());

        add(new JLabel("Precio del producto"));
        add(new JTextField());

        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Datos del producto aceptados");
            }
        });

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Datos del producto guardados");
            }
        });

        add(aceptarButton);
        add(guardarButton);
        add(cerrarButton);
    }
}

