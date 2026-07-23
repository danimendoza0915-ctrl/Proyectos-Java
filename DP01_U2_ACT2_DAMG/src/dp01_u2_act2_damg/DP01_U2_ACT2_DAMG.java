
package dp01_u2_act2_damg;

import java.util.Scanner;



public class DP01_U2_ACT2_DAMG {

 static Scanner scanner = new Scanner(System.in);
 static int pacientesQuePuedenDonar = 0;
 static int pacientesQueNoPuedenDonar = 0;


    public static void main(String[] args) {
          boolean condicion  = true;
         while (condicion){
            mostrarMenu();
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    mostrarReporte();
                    break;
                case 3:
                    condicion = false;
                    System.out.println("------Hasta luego------");
                    break;
            }
        }
    }
     public static void mostrarMenu() {
        System.out.println("Daniel Mendoza Gutierrez   Matricula: ES231109257");
        System.out.println("------Bienvenido a laboratorio clinico------");
        System.out.println("------1. Registro de pacientes------");
        System.out.println("------2. Reporte de pacientes que pueden y no pueden donar------");
        System.out.println("------3. Salir------");
        System.out.println("------Elija su opción------ ");
    }

    public static void registrarPaciente() {
        String nombre = solicitarDato("Ingrese sus nombre").next();
        char genero = solicitarDato("Ingrese su genero (M/F)").next().charAt(0);
        int edad = solicitarDato("Ingrese su edad").nextInt();
        double peso = solicitarDato("Ingrese su peso").nextDouble();
        int tesniondiastolica = solicitarDato("Ingrese su tension arterial (diastolica)").nextInt();
        int tesnionsistolica = solicitarDato("Ingrese su tension arterial (sistolica)").nextInt();
        int pulso = solicitarDato("Ingrese su pulso").nextInt();
        int plaquetas = solicitarDato("Ingrese sus plaquetas").nextInt();
        double hemoglobina = solicitarDato("Ingrese sus hemoglobina").nextDouble();
        String enAyunas= solicitarDato("¿Esta en ayunas (Si/No)?").next(); 

        if (esAptoParaDonar(edad, peso, tesniondiastolica, tesnionsistolica, pulso, plaquetas, genero, hemoglobina, enAyunas)){
            System.out.println(nombre + " es apto para donar sangre");
            pacientesQuePuedenDonar++;
         } else {
            System.out.println(nombre + " no es apto para donar sangre.");
            pacientesQueNoPuedenDonar++;
         }
    }

    public static Scanner solicitarDato(String mensaje) {
         System.out.println(mensaje);
         return scanner;
    }

    public static boolean esAptoParaDonar(int edad, double peso, int tesniondiastolica, int tesnionsistolica, int pulso, int plaquetas, char genero, double hemoglobina, String enAyunas) {
         return (edad >=18 && edad<=65 && peso >=50 && tesniondiastolica >=50 && tesniondiastolica <=100 && tesnionsistolica >=90 && tesnionsistolica <=180 && pulso >=50 && pulso <=110 && plaquetas >=150000 && ((genero == 'M' && hemoglobina >=13.5) || (genero == 'F' && hemoglobina >= 12.5))  && enAyunas.equalsIgnoreCase("No"));
    }

    public static void mostrarReporte() {
         System.out.println("------Reporte de pacientes:------");
         System.out.println("Pacientes que pueden donar: " + pacientesQuePuedenDonar);
         System.out.println("Pacientes que no pueden donar: " + pacientesQueNoPuedenDonar);
    }
}
