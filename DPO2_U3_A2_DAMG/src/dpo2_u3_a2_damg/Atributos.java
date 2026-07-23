package dpo2_u3_a2_damg;

// Clase para representar los atributos de un libro
public class Atributos {
    private int idLibro; // Identificador del libro
    private String titulo; // Título del libro
    private String autor; // Autor del libro
    private String fechaPublicacion; // Fecha de publicación del libro

    // Constructor de la clase
    public Atributos(int idLibro, String titulo, String autor, String fechaPublicacion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Métodos getter y setter para cada atributo

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}