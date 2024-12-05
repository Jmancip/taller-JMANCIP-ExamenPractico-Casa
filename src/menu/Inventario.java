package menu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    public static List<Producto> productos = new ArrayList<>();
    private static final String archivoProductos = "D:\\workspaceintellij2024\\ProyectoFinalTienda\\productos.txt";

    public Inventario() {
        this.productos = new ArrayList<>();
        cargarProductos();
    }

    /*/Constructor
    public Inventario() {
        this.productos = new ArrayList<>();
        cargarProductos();
    }*/

    // Cargar productos desde el archivo
    private void cargarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoProductos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int idProducto = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String categoria = datos[2];
                double precio = Double.parseDouble(datos[3]);
                int cantidad = Integer.parseInt(datos[4]);
                productos.add(new Producto(idProducto, nombre, categoria, precio, cantidad));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }


    // Agregar un nuevo producto opción 1 del menú
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

    // Guardar productos en el archivo para agregar los productos
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


    // Actualizar un producto existente opción 2 del menú
    public static void actualizarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************************************************");
        System.out.println("**           Permite modificar los datos de un producto existente          **");
        System.out.println("**               Diligencie la información que va a modificar              **");
        System.out.println("**              \uD83D\uDC49   Ingrese el ID del producto a actualizar:               **");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar

        menu.Producto producto = buscarProductoPorId(id);

        if (producto != null) {
            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nombreProducto = scanner.nextLine();

            System.out.print("Ingrese la nueva categoría del producto: ");
            String categoria = scanner.nextLine();

            System.out.print("Ingrese el nuevo precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese la nueva cantidad disponible: ");
            int cantidadDisponible = Integer.parseInt(scanner.nextLine());

            producto.setNombreProducto(nombreProducto);
            producto.setCategoria(categoria);
            producto.setPrecio(precio);
            producto.setCantidadDisponible(cantidadDisponible);

            modificarProducto(productos);

            System.out.println("**  Producto actualizado exitosamente.   **");

        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Buscar producto por ID
    private static Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getIdProducto() == id) {
                return producto;
            }
        }
        return null;
    }

    public static void modificarProducto(List<Producto> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoProductos))) {
            // Escribir una línea por cada producto en el ArrayList
            for (Producto producto : productos) {
            // Escribir los campos separados por comas (puedes cambiar el delimitador si es necesario)
        // Se crea el String.valueOf para que se pueda leer cada tipo de dato de las variables
                writer.write(String.join(",", String.valueOf(producto.getIdProducto()),
                        producto.getNombreProducto(), producto.getCategoria(),
                        String.valueOf(producto.getPrecio()), String.valueOf(producto.getCantidadDisponible())));
                writer.newLine();
            }
            System.out.println("Archivo actualizado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }


    // Eliminar producto opción 3 del menú
    public static void eliminarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************************************************");
        System.out.println("**                    Eliminar producto                                    **");
        System.out.println("*****************************************************************************");
        System.out.println("**         Ingrese el ID del producto a eliminar del inventario.           **");
        int idProducto = scanner.nextInt();

        Producto productoAEliminar = null;
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("**              Producto eliminado correctamente.                          **");
            System.out.println("*****************************************************************************");
        } else {
            System.out.println("** El producto con el Id " + idProducto + " no se encuentra                         **");
        }
    }

}





