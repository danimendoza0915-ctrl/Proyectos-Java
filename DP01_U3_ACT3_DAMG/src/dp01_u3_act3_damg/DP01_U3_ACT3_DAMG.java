package dp01_u3_act3_damg;
import java.util.Scanner;
public class DP01_U3_ACT3_DAMG {

   
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Daniel Mendoza Gutierrez Matricula:ES231109257");

        try {
            while (true) {

                System.out.println("1. Solicitar descuento");
                System.out.println("2. Campañas activas");
                System.out.println("3. Salir");
                System.out.println("Seleccione una opción:");


                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        solicitarDescuento();
                        break;
                    case 2:
                        mostrarCampañasActivas();
                        break;
                    case 3:
                        System.out.println("¡Hasta luego!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }

    private static void solicitarDescuento() throws Exception {
    Scanner scanner = new Scanner(System.in);

    try {
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();

        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new Exception("El nombre del cliente no puede estar vacío.");
        }

        System.out.println("Ingrese la cantidad de artículos vendidos:");
        String cantidadArticulosStr = scanner.nextLine();

        if (cantidadArticulosStr == null || cantidadArticulosStr.trim().isEmpty()) {
            throw new Exception("La cantidad de artículos no puede estar vacía.");
        }

        int cantidadArticulos = Integer.parseInt(cantidadArticulosStr);

        System.out.println("Ingrese el monto total del pedido:");
        String montoTotalStr = scanner.nextLine();

        if (montoTotalStr == null || montoTotalStr.trim().isEmpty()) {
            throw new Exception("El monto total no puede estar vacío.");
        }

        double montoTotal = Double.parseDouble(montoTotalStr);

        aplicarDescuentos(nombreCliente, cantidadArticulos, montoTotal);
    } catch (Exception e) {
        throw new Exception("Error al solicitar descuento. " + e.getMessage());
    } 
}


    private static void mostrarCampañasActivas() {
        System.out.println("Campañas activas durante el año:");
        System.out.println("1. Campaña de máxima capacidad");
        System.out.println("2. Campaña de alta economía");
    }

    private static void aplicarDescuentos(String nombreCliente, int cantidadArticulos, double montoTotal) throws Exception {
        double descuentoMaximaCapacidad = 0;
        double descuentoAltaEconomia = 0;

   if (cantidadArticulos >= 1 && cantidadArticulos <= 99) {
            descuentoMaximaCapacidad = 0.01;
        } else if (cantidadArticulos >= 100 && cantidadArticulos <= 999) {
            descuentoMaximaCapacidad = 0.05;
        } else if (cantidadArticulos >= 1000) {
            descuentoMaximaCapacidad = 0.1;
        }else {
            throw new Exception("Cantidad de artículos no válida para la Campaña de Máxima Capacidad");
        }

        if (montoTotal <= 10000) {
            descuentoAltaEconomia = 0.01;
        } else if (montoTotal > 10000) {
            descuentoAltaEconomia = 0.03;
        } else {
            throw new Exception("Monto total del pedido no válido para la Campaña de Alta Economía");
        }

        double descuentoAcumulado = descuentoMaximaCapacidad + descuentoAltaEconomia;

        // Validar límites de descuento acumulado
        if (descuentoAcumulado < 0.02 || descuentoAcumulado > 0.13) {
            throw new Exception("Descuento acumulado fuera de los límites permitidos");
        }
   
        System.out.println("El cliente: " + nombreCliente);
        System.out.println("Adquirio la cantidad de articulos:"+ " " + cantidadArticulos + "  " + "Obteniendo un" + " "+ descuentoMaximaCapacidad * 100 + "%"+ " " + "de descuento");
        System.out.println ("El monto total de su compra es de:" + " " + montoTotal + "  "+"obteniendo un" + " " + descuentoAltaEconomia *100+ " % "  + " " + "de descuento");
        System.out.println("Descuento por Campaña de Máxima Capacidad: " + (descuentoMaximaCapacidad * 100) + "%");
        System.out.println("Descuento por Campaña de Alta Economía: " + (descuentoAltaEconomia * 100) + "%");
        System.out.println("Resumen:");
        System.out.println("Monto Original: " + montoTotal);
        System.out.println("Descuento Acumulado: " + (descuentoAcumulado * 100) + "%");
        System.out.println("Monto Total a Pagar: " + (montoTotal - (montoTotal * descuentoAcumulado)));
 
    }
}    
