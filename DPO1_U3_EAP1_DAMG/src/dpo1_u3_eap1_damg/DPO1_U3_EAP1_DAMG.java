package dpo1_u3_eap1_damg;
import java.util.Scanner;

abstract class Paquete {
    double peso;
    double alto, ancho, largo;
    String destino;

    public Paquete(double peso, double alto, double ancho, double largo, String destino) {
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.destino = destino;
    }

    public abstract double calcularCostoEnvio();
}
interface Envio {
    void enviarPaquete();
}

class PaqueteNacional extends Paquete implements Envio {

    public PaqueteNacional(double peso, double alto, double ancho, double largo, String destino) {
        super(peso, alto, ancho, largo, destino);
    }

    @Override
    public double calcularCostoEnvio() {
       
        return peso * 0.5; 
    }

    @Override
    public void enviarPaquete() {
        System.out.println("Enviando paquete nacional a " + destino);
    }
}

class PaqueteInternacional extends Paquete implements Envio {

    public PaqueteInternacional(double peso, double alto, double ancho, double largo, String destino) {
        super(peso, alto, ancho, largo, destino);
    }

    @Override
    public double calcularCostoEnvio() {
        return peso * 2; 
    }

    @Override
    public void enviarPaquete() {
        System.out.println("Enviando paquete internacional a " + destino);
    }
}


public class DPO1_U3_EAP1_DAMG {


    public static void main(String[] args) {
        
  Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Daniel Mendoza Gutierrez  Matricula:ES231109257");
            System.out.println("Menú Te llevo Todo");
            System.out.println("1.- Envío nacional");
            System.out.println("2.- Envío internacional");
            System.out.println("3.- Impresión de los datos del envío");
            System.out.println("4.- Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Peso: ");
                    double pesoNacional = scanner.nextDouble();
                    System.out.print("Medidas Largo: ");
                    double largoNacional = scanner.nextDouble();
                    System.out.print("Ancho: ");
                    double anchoNacional = scanner.nextDouble();
                    System.out.print("Alto: ");
                    double altoNacional = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Lugar de envío: ");
                    String destinoNacional = scanner.nextLine();
                    System.out.print("Nombre del remitente: ");
                    String remitenteNacional = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccionNacional = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefonoNacional = scanner.nextLine();

                    PaqueteNacional paqueteNacional = new PaqueteNacional(pesoNacional, altoNacional, anchoNacional, largoNacional, destinoNacional);
                    paqueteNacional.enviarPaquete();
                    System.out.println("Costo de envío: $" + paqueteNacional.calcularCostoEnvio());
                    break;

                case 2:
                    System.out.print("Peso: ");
                    double pesoInternacional = scanner.nextDouble();
                    System.out.print("Medidas Largo: ");
                    double largoInternacional = scanner.nextDouble();
                    System.out.print("Ancho: ");
                    double anchoInternacional = scanner.nextDouble();
                    System.out.print("Alto: ");
                    double altoInternacional = scanner.nextDouble();
                    scanner.nextLine();  
                    System.out.print("Lugar de envío: ");
                    String destinoInternacional = scanner.nextLine();
                    System.out.print("Nombre del remitente: ");
                    String remitenteInternacional = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccionInternacional = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefonoInternacional = scanner.nextLine();

                    PaqueteInternacional paqueteInternacional = new PaqueteInternacional(pesoInternacional, altoInternacional, anchoInternacional, largoInternacional, destinoInternacional);
                    paqueteInternacional.enviarPaquete();
                    System.out.println("Costo de envío: $" + paqueteInternacional.calcularCostoEnvio());
                    break;

                case 3:
                    // Implementar la impresión de datos del envío si es necesario
                    break;

                case 4:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}
