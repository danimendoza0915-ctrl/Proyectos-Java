package dpo2_u3_a2_damg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

// Clase para la gestión de la base de datos
public class GestiónBaseDeDatos {
    private Connection conexion;
    
    // Constructor para establecer la conexión con la base de datos
    public GestiónBaseDeDatos() {
        try {
            
            // Cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/dpo2_u3_a2_damg", "root", "");
            conexion.setAutoCommit(false); // Desactivar la confirmación automática de transacciones
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se puede realizar la conexión con la base de datos: " + e.getMessage());
        }
    }
    
    // Método para insertar un libro en la base de datos
    public void insertarLibro(Atributos libro) {
        String query = "INSERT INTO libros (IdLibro, Titulo, Autor, FechaPublicación) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, libro.getIdLibro());
            statement.setString(2, libro.getTitulo());
            statement.setString(3, libro.getAutor());
            statement.setString(4, libro.getFechaPublicacion());
            
            // Ejecutar la consulta de inserción
            
            statement.executeUpdate();
            
            // Confirmar la transacción
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("No se puede ingresar el libro: " + e.getMessage());
            try {
               
                // En caso de error, realizar un rollback para deshacer los cambios
                conexion.rollback();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
    // Método para eliminar un libro de la base de datos
    public void eliminarLibro(int IdLibro) {
        String query = "DELETE FROM libros WHERE IdLibro = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, IdLibro);
           
            // Ejecutar la consulta de eliminación y obtener el número de filas afectadas
            int rowCount = statement.executeUpdate();
            
            // Verificar si se eliminó el libro y mostrar el mensaje correspondiente
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminó el libro");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede eliminar el libro", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            // Confirmar la transacción
            conexion.commit();
        } catch (SQLException e) {
            String errorMessage = "No se puede eliminar el libro: " + e.getMessage();
            System.out.println(errorMessage);
            try {
                
                // En caso de error, realizar un rollback para deshacer los cambios
                conexion.rollback();
            } catch (SQLException ex) {
                errorMessage += "\nError al hacer la revisión: " + ex.getMessage();
                System.out.println(errorMessage);
            }
        }
    }
    
    // Método para consultar todos los libros de la base de datos
    public List<Atributos> consultarLibros() {
        List<Atributos> listaLibros = new ArrayList<>();
        String query = "SELECT * FROM libros";
        try {
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            // Recorrer el resultado y agregar cada libro a la lista
            while (result.next()) {
                int IdLibro = result.getInt("IdLibro");
                String Titulo = result.getString("Titulo");
                String Autor = result.getString("Autor");
                String FechaPublicación = result.getString("FechaPublicación");
                Atributos libro = new Atributos(IdLibro, Titulo, Autor, FechaPublicación);
                listaLibros.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("No se puede realizar la consultar los libros: " + e.getMessage());
        }
        return listaLibros;
    }
    
    // Método para cerrar la conexión con la base de datos
    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la conexión: " + e.getMessage());
        }
    }
}
