package dp01_u2_eap1_damg;

import java.util.Scanner;

public class DP01_U2_EAP1_DAMG {

    public static void main(String[] args) {
       Scanner scanner = new Scanner (System.in); 
       System.out.println ("Daniel Mendoza Gutierrez Matricul: ES231109257");
       System.out.println ("Ingrese su nombre:");
       String nombre = scanner.nextLine();
       System.out.println ("Ingrese su numero de cuenta:");
       String numeroDeCuenta = scanner.nextLine();
       System.out.println("Ingrese el saldo:");
       double saldo = scanner.nextDouble();
       System.out.println("La tasa de interes anual es del 5%");
       double tasaDeInteres = 0.05;
       double interesAnual= saldo * tasaDeInteres;
       double interesMensual= interesAnual / 12;
       double montoAcumuladoMensual = saldo + interesMensual;
       double montoAcumuladoAnual= saldo + interesAnual;
       System.out.println ("Su nombre es:"+ nombre);
       System.out.println ("Su numero de cuenta:"+ numeroDeCuenta);
       System.out.println("Su saldo actual es de:"+ saldo);
       System.out.println("Su monto acumulado mensual es de:"+ montoAcumuladoMensual);
       System.out.println("Su monto acumulado anual es de:"+ montoAcumuladoAnual);
    }
   
}
