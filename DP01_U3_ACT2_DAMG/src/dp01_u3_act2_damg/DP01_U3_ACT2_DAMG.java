package dp01_u3_act2_damg;


public class DP01_U3_ACT2_DAMG {

    
    public static void main(String[] args) {

       Libro libro = new Libro("Don Quijote de la mancha", "Miguel de Cervantes Saavedra", 1605, "Novela");
       LibroFisico libroFisico = new LibroFisico("1984", "George Orwell", 1949, 326, false, "Inglés");
       LibroDigital libroDigital = new LibroDigital("El principito", "Antoine de Saint-Exupéry,", 1943, 3, "PDF", "imprentanacional");
       
        System.out.println("Daniel Mendoza Gutierrez  Matricula:ES231109257");
       
       System.out.println("Información del Libro:");
       libro.mostrarInformacion();
       libro.prestar();

       System.out.println("\nInformación del Libro Físico:");
       libroFisico.mostrarInformacion();
       libroFisico.verificarEstado();

       System.out.println("\nInformación del Libro Digital:");
       libroDigital.mostrarInformacion();
       libroDigital.descargar();
    }
}


class Libro {
    private String titulo;
    private String autor;
    private int AñOPublicacion;
    private String genero;

    public Libro(String titulo, String autor, int añoPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.AñOPublicacion = añoPublicacion;
        this.genero = genero;
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de Publicación: " + AñOPublicacion);
        System.out.println("Género: " + genero);
    }

    public void prestar() {
        System.out.println("El libro está dispnible.");
    }
}


class LibroFisico extends Libro {
    private int numeroPaginas;
    private boolean tapaDura;
    private String idioma;

    public LibroFisico(String titulo, String autor, int AñOPublicacion, int numeroPaginas, boolean tapaDura, String idioma) {
        super(titulo, autor, AñOPublicacion, "Ciencia Ficción");
        this.numeroPaginas = numeroPaginas;
        this.tapaDura = tapaDura;
        this.idioma = idioma;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Número de Páginas: " + numeroPaginas);
        System.out.println("Tapa Dura: " + (tapaDura ? "Sí" : "No"));
        System.out.println("Idioma: " + idioma);
    }

    public void verificarEstado() {
        System.out.println("El libro físico está en buen estado.");
    }
}

class LibroDigital extends Libro {
    private int tamanoMB;
    private String formato;
    private String plataforma;

    public LibroDigital(String titulo, String autor, int añoPublicacion, int tamanoMB, String formato, String plataforma) {
        super(titulo, autor, añoPublicacion, "Literatura infantil");
        this.tamanoMB = tamanoMB;
        this.formato = formato;
        this.plataforma = plataforma;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tamaño (MB): " + tamanoMB);
        System.out.println("Formato: " + formato);
        System.out.println("Plataforma: " + plataforma);
    }

    public void descargar() {
        System.out.println("El libro digital esta disponible para descargar.");
    }
}