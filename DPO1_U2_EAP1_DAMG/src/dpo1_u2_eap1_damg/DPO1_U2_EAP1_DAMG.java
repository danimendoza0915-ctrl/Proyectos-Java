package dpo1_u2_eap1_damg;

import java.util.ArrayList;
import java.util.Scanner;

public class DPO1_U2_EAP1_DAMG {


    public static void main(String[] args) {
         ArrayList<Libro> libros = new ArrayList<>();
        libros.add(new Libro("Don Quijote de la mancha", "Novela", EstadoLibro.DISPONIBLE));
        libros.add(new Libro("1984", "Ciencia Ficción", EstadoLibro.DISPONIBLE));
        libros.add(new Libro("Historia Universal", "Estudios Sociales", EstadoLibro.DISPONIBLE));
        libros.add(new Libro("Moby-Dick", "Novela", EstadoLibro.DISPONIBLE));
        libros.add(new Libro("Fahrenheit 451", "Ciencia Ficción", EstadoLibro.DISPONIBLE));
        libros.add(new Libro("El Gran Gatsby", "Novela", EstadoLibro.DISPONIBLE));
        libros.add(new Libro("Watchmen", "Comics", EstadoLibro.DISPONIBLE));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Daniel Mendoza Gutierrez  Matricula: ES231109257");
            System.out.println("\nMenú:");
            System.out.println("1. Consultar disponibilidad de un libro");
            System.out.println("2. Solicitar préstamo de un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    consultarLibro(libros);
                    break;
                case 2:
                    solicitarPrestamo(libros);
                    break;
                case 3:
                    devolverLibro(libros);
                    break;
                case 4:
                    System.out.println("Hasta luego");
                    scanner.close();
                    System.exit(0);
                default:
                  
            }
        }
    }

    // Clase para representar un libro
    static class Libro {
        String titulo;
        String categoria;
        EstadoLibro estado;

        public Libro(String titulo, String categoria, EstadoLibro estado) {
            this.titulo = titulo;
            this.categoria = categoria;
            this.estado = estado;
        }
    }

    // Enumeración para representar el estado de un libro
    enum EstadoLibro {
        DISPONIBLE,
        PRESTADO
    }

    // Función para consultar la disponibilidad de un libro
    static void consultarLibro(ArrayList<Libro> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro a consultar: ");
        String titulo = scanner.nextLine();

        for (Libro libro : libros) {
            if (libro.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("Título: " + libro.titulo);
                System.out.println("Categoría: " + libro.categoria);
                System.out.println("Estado: " + (libro.estado == EstadoLibro.DISPONIBLE ? "Disponible" : "Prestado"));
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }


    static void solicitarPrestamo(ArrayList<Libro> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro que sea: ");
        String titulo = scanner.nextLine();

        for (Libro libro : libros) {
            if (libro.titulo.equalsIgnoreCase(titulo)) {
                if (libro.estado == EstadoLibro.DISPONIBLE) {
                    libro.estado = EstadoLibro.PRESTADO;
                    int diasPrestamo = obtenerDiasPrestamo(libro.categoria);
                    System.out.println("Libro prestado con éxito por " + diasPrestamo + " días.");
                } else {
                    System.out.println("El libro no está disponible para préstamo.");
                }
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    // Función para devolver un libro prestado
    static void devolverLibro(ArrayList<Libro> libros) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro que va a devolver: ");
        String titulo = scanner.nextLine();

        for (Libro libro : libros) {
            if (libro.titulo.equalsIgnoreCase(titulo)) {
                if (libro.estado == EstadoLibro.PRESTADO) {
                    libro.estado = EstadoLibro.DISPONIBLE;
                    System.out.println("Libro devuelto con éxito.");
                } else {
                    System.out.println("No puedes devolver un libro que no ha sido prestado.");
                }
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    // Función para obtener los días de préstamo según la categoría
    static int obtenerDiasPrestamo(String categoria) {
        switch (categoria) {
            case "Novela":
                return 7;
            case "Ciencia Ficción":
                return 5;
            case "Estudios Sociales":
                return 10;
            default:
                return 3;
        }
    }
    }
 
