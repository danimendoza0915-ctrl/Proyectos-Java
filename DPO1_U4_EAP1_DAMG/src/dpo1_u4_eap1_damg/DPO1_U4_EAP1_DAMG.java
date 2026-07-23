package dpo1_u4_eap1_damg;

import java.util.Arrays;
import java.util.Scanner;

public class DPO1_U4_EAP1_DAMG {

    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);

        int opcion;
        int cantidadCompetidores = 0;

        String[][] competidores = new String[100][2]; // Arreglo bidimensional para nombres y tiempos
        double[] tiempos = new double[100]; // Arreglo unidimensional para los tiempos

        do {
            System.out.println("\nDaniel Mendoza Gutierrez Matricula:ES231109257");
            System.out.println("Menú:");
            System.out.println("1. Ingresar datos competidores");
            System.out.println("2. Mostrar datos");
            System.out.println("3. Ordenar datos");
            System.out.println("4. Buscar dato");
            System.out.println("5. Mostrar el ganador");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de competidores: ");
                    cantidadCompetidores = scanner.nextInt();
                    ingresarDatosCompetidores(competidores, tiempos, cantidadCompetidores);
                    break;
                case 2:
                    mostrarDatos(competidores, tiempos, cantidadCompetidores);
                    break;
                case 3:
                    ordenarDatos(competidores, tiempos, cantidadCompetidores);
                    break;
                case 4:
                    buscarDato(competidores, tiempos, cantidadCompetidores);
                    break;
                case 5:
                    mostrarGanador(competidores, tiempos, cantidadCompetidores);
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void ingresarDatosCompetidores(String[][] competidores, double[] tiempos, int cantidadCompetidores) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cantidadCompetidores; i++) {
            System.out.print("Ingrese el nombre del competidor #" + (i + 1) + ": ");
            competidores[i][0] = scanner.next();
            System.out.print("Ingrese el tiempo que realizó el competidor #" + (i + 1) + ": ");
            tiempos[i] = scanner.nextDouble();
        }
    }

    private static void mostrarDatos(String[][] competidores, double[] tiempos, int cantidadCompetidores) {
        System.out.println("\nDatos de los competidores:");
        for (int i = 0; i < cantidadCompetidores; i++) {
            System.out.println("Competidor #" + (i + 1) + ": Nombre: " + competidores[i][0] + ", Tiempo: " + tiempos[i]);
        }
    }

    private static void ordenarDatos(String[][] competidores, double[] tiempos, int cantidadCompetidores) {
        for (int i = 0; i < cantidadCompetidores - 1; i++) {
            for (int j = 0; j < cantidadCompetidores - i - 1; j++) {
                if (tiempos[j] > tiempos[j + 1]) {
                    // Intercambiar tiempos
                    double tempTiempo = tiempos[j];
                    tiempos[j] = tiempos[j + 1];
                    tiempos[j + 1] = tempTiempo;

                    // Intercambiar nombres
                    String tempNombre = competidores[j][0];
                    competidores[j][0] = competidores[j + 1][0];
                    competidores[j + 1][0] = tempNombre;
                }
            }
        }
        System.out.println("Datos ordenados por tiempo de menor a mayor.");
    }

    private static void buscarDato(String[][] competidores, double[] tiempos, int cantidadCompetidores) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del competidor que desea buscar: ");
        String nombreBuscar = scanner.next();

        boolean encontrado = false;
        for (int i = 0; i < cantidadCompetidores; i++) {
            if (competidores[i][0].equalsIgnoreCase(nombreBuscar)) {
                System.out.println("Competidor encontrado. Tiempo: " + tiempos[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Competidor no encontrado.");
        }
    }

    private static void mostrarGanador(String[][] competidores, double[] tiempos, int cantidadCompetidores) {
        System.out.println("\nCompetidor ganador:");
        System.out.println("Nombre: " + competidores[0][0] + ", Tiempo: " + tiempos[0]);
    }
}