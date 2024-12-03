package menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    public static List<Producto> productos = new ArrayList<>();
    private static final String archivoProductos = "D:\\workspaceintellij2024\\ProyectoFinalTienda\\productos.txt";

    //Constructor
    /*public Inventario() {
        productos = new ArrayList<>();
        cargarProductos();
    }*/

    // Cargar productos desde el archivo
    /*public void cargarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoProductos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Producto producto = new Producto(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        Double.parseDouble(datos[3]),
                        Integer.parseInt(datos[4])
                );
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo: " + e.getMessage());
        }
    }*/

    // Guardar productos en el archivo
    public static void guardarProductos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoProductos, true))) {
            for (Producto producto : productos) {
                bw.write(String.join(",", String.valueOf(producto.getIdProducto()),
                        producto.getNombreProducto(), producto.getCategoria(),
                        String.valueOf(producto.getPrecio()), String.valueOf(producto.getCantidadDisponible())));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }
    }

    // Agregar un nuevo producto
    public static void agregarProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************************************************************************");
        System.out.println("**           Permite añadir un nuevo producto al inventario                **");
        System.out.println("**            \uD83D\uDC49  Agrega el ID del producto                                **");
        int idProducto = Integer.parseInt(scanner.nextLine());

        System.out.println("**    \uD83D\uDC49  Agrega el nombre del producto                                    **");
        String nombreProducto = scanner.nextLine();

        System.out.println("**    \uD83D\uDC49  Ingresa la categoria del producto                                 **");
        String categoria = scanner.nextLine();

        System.out.println("**    \uD83D\uDC49  Ingresa precio del producto                                       **");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.println("**    \uD83D\uDC49  Ingresa cantidad disponible producto                             **");
        int cantidadDisponible = Integer.parseInt(scanner.nextLine());

        Producto nuevoProducto = new Producto(idProducto, nombreProducto, categoria, precio, cantidadDisponible);
        productos.add(nuevoProducto);
        guardarProductos();
        System.out.println("**              \uD83D\uDE0E  Producto agregado exitosamente                         **");
        System.out.println("*****************************************************************************");
    }


    // Actualizar un producto existente

    /*public static void actualizarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**           Permite modificar los datos de un producto existente          **");
        System.out.println("**              Diligencie la información que va a modificar               **");
        System.out.println("**    \uD83D\uDC49   Ingrese el ID del producto a actualizar:           **");
        int idProducto = scanner.nextInt();
        scanner.nextLine(); // Limpiar

        Producto producto = buscarProductoPorID(idProducto);
        if (producto != null) {
            System.out.println("**    Producto encontrado: " + producto + "      **");

            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nombreProducto = scanner.nextLine();

            System.out.print("Ingrese la nueva categoría del producto: ");
            String categoria = scanner.nextLine();

            System.out.print("Ingrese el nuevo precio del producto: ");
            double precio = scanner.nextDouble();

            System.out.print("Ingrese la nueva cantidad disponible: ");
            int cantidadDisponible = scanner.nextInt();

            producto.setNombreProducto(nombreProducto);
            producto.setCategoria(categoria);
            producto.setPrecio(precio);
            producto.setCantidadDisponible(cantidadDisponible);

            guardarProductos();
            System.out.println("**  Producto actualizado exitosamente.   **");
        } else {
            System.out.println("Producto con ID " + idProducto + "no encontardo");
        }*/

    // Buscar producto por ID
        /*/public static void Producto buscarProductoPorId ( int idProducto){
            for (Producto producto : productos) {
                if (producto.getIdProducto() == idProducto) {
                    return producto;
                }
            }
            return null;
        }*/
}
