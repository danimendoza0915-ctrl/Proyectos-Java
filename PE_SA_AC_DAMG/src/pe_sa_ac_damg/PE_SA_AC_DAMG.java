package pe_sa_ac_damg;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PE_SA_AC_DAMG {

    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);

        // Inicialización de la tienda con productos
        Tienda tienda = new Tienda();
        tienda.inicializarProductos();

        int opcion = 0;
        //Menú de opciones
        do {
            System.out.println("\nDaniel Mendoza Gutierrez  Matricula:ES231109257");
            System.out.println("Bienvenido a la App de Inventario");
            System.out.println("Menú:");
            System.out.println("1. Vender un producto");
            System.out.println("2. Abastecer la tienda con un producto");
            System.out.println("3. Calcular estadísticas de ventas");
            System.out.println("4. Salir");
            System.out.print("Ingresa una opción:");
                      
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();  
            } catch (InputMismatchException e) {
                System.out.println("""
                                   Error: debes ingresar un n\u00famero entero.
                                   """);
                scanner.nextLine();  // Consumir la entrada incorrecta
                continue;
            }
            //Opciones del menú
            switch (opcion) {
                case 1:
                    tienda.venderProducto(scanner);
                    break;
                case 2:
                    tienda.abastecerProducto(scanner);
                    break;
                case 3:
                    tienda.calcularEstadisticasVentas();
                    break;
                case 4:
                    System.out.println("\nSaliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("""
                                       Opci\u00f3n no v\u00e1lida. Int\u00e9ntalo de nuevo.
                                       """);
            }

        } while (opcion != 4);
    }
}

class Producto {
    private final String nombre;
    private final String tipo;
    private int cantidadActual;
    private final int cantidadMinima;
    private final double precioBase;
    private final double precioFinal;
    private double ventaAcumulada;

    public Producto(String nombre, String tipo, int cantidadActual, int cantidadMinima, double precioBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadActual = cantidadActual;
        this.cantidadMinima = cantidadMinima;
        this.precioBase = precioBase;
        this.precioFinal = calcularPrecioFinal();
        this.ventaAcumulada = 0;
    }
    //Inicialización de los métodos
    public double vender(int cantidad) throws Exception {
    if (cantidad > cantidadActual) {
        throw new Exception("\nNo hay suficientes productos en inventario para realizar la venta.");
    }
    cantidadActual -= cantidad;
    double montoTotal = cantidad * precioFinal;
    ventaAcumulada += montoTotal;
    return montoTotal;
}


    public void abastecer(int cantidad) {
        cantidadActual += cantidad;
    }

    private double calcularPrecioFinal() {
        if (cantidadActual == 0) {
            throw new ArithmeticException("No se puede calcular el precio final con cantidad actual igual a cero.");
        }

        double impuestos = 0;

        switch (tipo.toLowerCase()) {
            case "papelería":
                impuestos = 0.16;
                break;
            case "supermercado":
                impuestos = 0.04;
                break;
            case "medicamento":
                impuestos = 0.12;
                break;
        }

        return precioBase * (1 + impuestos);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public double getVentaAcumulada() {
        return ventaAcumulada;
    }
}
//Arreglo
class Tienda {
    private ArrayList<Producto> productos;

    public Tienda() {
        productos = new ArrayList<>();
    }
    //Productos y categorias para la tabla
    public void inicializarProductos() {
        productos.add(new Producto("Lapiz", "papelería", 20, 5, 10.0));
        productos.add(new Producto("Leche", "supermercado", 15, 3, 8.0));
        productos.add(new Producto("Aspirina", "medicamento", 30, 10, 15.0));
        productos.add(new Producto("Borrador", "papelería", 25, 7, 12.0));
    }

    public void venderProducto(Scanner scanner) {
    System.out.println("""
                       Lista de productos disponibles para la venta:
                       """);
    mostrarTablaProductos();

    System.out.print("\nIngrese el nombre del producto a vender: ");
    String nombreProducto = scanner.nextLine();

    try {
        Producto producto = buscarProductoPorNombre(nombreProducto);
        if (producto != null) {
            System.out.print("Ingrese la cantidad a vender: ");
            int cantidadVender = scanner.nextInt();
            double montoTotalVenta = producto.vender(cantidadVender);
            System.out.println("Venta realizada con éxito. Monto total: $" + montoTotalVenta + "\n");
        } else {
            System.out.println("""
                               No se encontr\u00f3 un producto con ese nombre.
                               """);
        }
    } catch (IllegalArgumentException e) {
        System.out.println("Error en la venta: " + e.getMessage()+ "\n");
    } catch (Exception e) {
        System.out.println("Error en la venta: " + e.getMessage()+ "\n");
    }
}


    public void abastecerProducto(Scanner scanner) {
        System.out.println("""
                           Lista de productos disponibles para abastecer:
                           """);
        mostrarTablaProductos();

        System.out.print("\nIngrese el nombre del producto a abastecer: ");
        String nombreProducto = scanner.nextLine();

        Producto producto = buscarProductoPorNombre(nombreProducto);
        if (producto != null) {
            System.out.print("Ingrese la cantidad a abastecer: ");
            int cantidadAbastecer = scanner.nextInt();
            producto.abastecer(cantidadAbastecer);
            System.out.println("""
                               Abastecimiento realizado con \u00e9xito.
                               """);
        } else {
            System.out.println("""
                               No se encontr\u00f3 un producto con ese nombre.
                               """);
        }
    }

    public void calcularEstadisticasVentas() {
        if (productos.isEmpty()) {
            System.out.println("""
                               No hay productos en la tienda para calcular estad\u00edsticas.
                               """);
            return;
        }
        //Tabla de estadisticas
        System.out.println("\nTabla de estadísticas de ventas:");
        System.out.printf("%-15s %-15s %-20s %-20s %-20s %-20s %-20s%n",
                "Producto", "Tipo", "Cantidad Actual", "Cantidad Mínima", "Precio Base", "Precio Final", "Venta Acumulada");

        for (Producto producto : productos) {
            System.out.printf("%-15s %-15s %-20s %-20s %-20s %-20s %-20s%n",
                    producto.getNombre(), producto.getTipo(), producto.getCantidadActual(),
                    producto.getCantidadMinima(), producto.getPrecioBase(), producto.getPrecioFinal(),
                    producto.getVentaAcumulada());
        }

        // Estadísticas adicionales
        Producto masVendido = obtenerProductoMasVendido();
        Producto menosVendido = obtenerProductoMenosVendido();
        double ventaTotal = calcularVentaTotal();
        double ventaPromedio = calcularVentaPromedio();

        System.out.println("\nEstadísticas adicionales:");
        System.out.println("Producto más vendido: " + masVendido.getNombre());
        System.out.println("Producto menos vendido: " + menosVendido.getNombre());
        System.out.println("Venta total de la tienda: " + ventaTotal);
        System.out.println("Venta promedio de toda la tienda: " + ventaPromedio + "\n");
    }

    private Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private void mostrarTablaProductos() {
        System.out.printf("%-15s %-15s %-20s %-20s %-20s %-20s%n",
                "Producto", "Tipo", "Cantidad Actual", "Cantidad Mínima", "Precio Base", "Precio Final");

        for (Producto producto : productos) {
            System.out.printf("%-15s %-15s %-20s %-20s %-20s %-20s%n",
                    producto.getNombre(), producto.getTipo(), producto.getCantidadActual(),
                    producto.getCantidadMinima(), producto.getPrecioBase(), producto.getPrecioFinal());
        }
    }

    private Producto obtenerProductoMasVendido() {
        Producto masVendido = productos.get(0);
        for (Producto producto : productos) {
            if (producto.getVentaAcumulada() > masVendido.getVentaAcumulada()) {
                masVendido = producto;
            }
        }
        return masVendido;
    }

    private Producto obtenerProductoMenosVendido() {
        Producto menosVendido = productos.get(0);
        for (Producto producto : productos) {
            if (producto.getVentaAcumulada() < menosVendido.getVentaAcumulada()) {
                menosVendido = producto;
            }
        }
        return menosVendido;
    }

    private double calcularVentaTotal() {
        double ventaTotal = 0;
        for (Producto producto : productos) {
            ventaTotal += producto.getVentaAcumulada();
        }
        return ventaTotal;
    }

    private double calcularVentaPromedio() {
        double ventaTotal = calcularVentaTotal();
        return ventaTotal / productos.size();
    }
}
