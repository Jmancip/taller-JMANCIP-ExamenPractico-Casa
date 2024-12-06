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
    }

    // Agregar un nuevo producto opción 1 del menú
    public static void agregarProducto() {
        System.out.println("*****************************************************************************");
        System.out.println("**           Permite añadir un nuevo producto al inventario                **");

        List<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isProductEntryComplete = false;
        while (!isProductEntryComplete) {

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

            System.out.println("**              \uD83D\uDE0E  Producto agregado exitosamente                         **");
            System.out.println("*****************************************************************************");

            Producto producto = new Producto(idProducto, nombreProducto, categoria, precio, cantidadDisponible);
            productos.add(producto);

            //BufferedWriter: Escribir el texto al archivo
            //FileWriter: Abrir archivo -true: añadir info al final del archivo
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(archivoProductos, true))) {
                // Escribir una línea por cada producto en el ArrayList
                for (Producto producto1 : productos) //for-each  Toma cada elemento de la lista productos uno por uno.
                {
                    //String.join: Combina los atributos del producto en una sola línea
                    // String.valueOf :  lee cada tipo de dato de las variables
                    wr.write(String.join(",", String.valueOf(producto1.getIdProducto()),
                            producto1.getNombreProducto(), producto1.getCategoria(),
                            String.valueOf(producto1.getPrecio()), String.valueOf(producto1.getCantidadDisponible())));
                    wr.newLine(); //salto de línea después de cada producto.
                }
            } catch (IOException e) {
                //throw new RuntimeException(e);
                System.err.println("Error al escribir el archivo :" + e.getMessage());
            }
            isProductEntryComplete = true;
        }
    }

    public static List<Producto> lecturaProduct() {

        List<Producto> listaProductos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoProductos))) {
            String linea;
            // Leer línea del archivo
            while ((linea = br.readLine()) != null) {
                // Separar la línea en elementos
                String[] datos = linea.split(",");
                int idProducto = Integer.parseInt(datos[0]);
                String nombreProducto = datos[1];
                String categoria = datos[2];
                double precio = Double.parseDouble(datos[3]);
                int cantidadDisponible = Integer.parseInt(datos[4]);
                Producto producto = new Producto(idProducto, nombreProducto, categoria, precio, cantidadDisponible);
                listaProductos.add(producto);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return listaProductos;
    }

    // Actualizar un producto existente opción 2 del menú
    public static void actualizarProducto() {

        List<Producto> productosActualizar = Inventario.lecturaProduct();
        /*System.out.println("Id Producto\t\tNombre Producto\t\tCategoria\t\tPrecio\t\tCantidad Disponible");

        for (Producto producto : productosActualizar) {
            System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
        }*/
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("*****************************************************************************");
            System.out.println("**           Permite modificar los datos de un producto existente          **");
            System.out.println("**               Diligencie la información que va a modificar              **");
            System.out.println("**              \uD83D\uDC49   Ingrese el ID del producto a actualizar:              **");
            int idProducto = Integer.parseInt(scanner.nextLine());

            boolean existe = false;
            for (Producto producto : productosActualizar) {
                if (producto.getIdProducto() == idProducto) {
                    Scanner scanProduc = new Scanner(System.in);
                    System.out.println("**              \uD83D\uDC49   Ingrese el nuevo Nombre del producto: :               **");
                    String nombreProducto = scanProduc.nextLine();

                    System.out.println("**              \uD83D\uDC49   Ingrese la nueva Categoria del producto                **");
                    String categoria = scanProduc.nextLine();

                    System.out.println("**             \uD83D\uDC49   Ingrese el nueva Precio del producto                **");
                    double precio = Double.parseDouble(scanProduc.nextLine());

                    System.out.println("**         \uD83D\uDC49   Ingrese la nueva Cantidad Disponible del producto                **");
                    int cantidadDisponible = Integer.parseInt(scanProduc.nextLine());

                    producto.setNombreProducto(nombreProducto);
                    producto.setCategoria(categoria);
                    producto.setPrecio(precio);
                    producto.setCantidadDisponible(cantidadDisponible);
                    existe = true;
                    break;
                }
            }
            if (existe) {
                //Actualizar archivo
                escribirInventario(productosActualizar);
            } else {
                System.out.println("**          Ese Producto no esta en el inventario               **");
            }
        } catch (NumberFormatException e) {
            System.out.println("**          El ID ingresado no es un número valido          **");
        }
    }

    public static void escribirInventario(List<Producto> listaProducto) {
           //BufferedWriter: Escribir el texto al archivo
                                                         //FileWriter: Abrir archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoProductos))) {
            // Escribir una línea por cada producto en el ArrayList
            for (Producto producto1 : listaProducto) {
                // Escribir los campos separados por comas (puedes cambiar el delimitador si es necesario)
                // Se crea el String.valueOf para que se pueda leer cada tipo de dato de las variables

                           //String.join: Combina los atributos del producto en una sola línea
                                                    // String.valueOf: lee cada tipo de dato de las variables
                writer.write(String.join(",", String.valueOf(producto1.getIdProducto()),
                        producto1.getNombreProducto(), producto1.getCategoria(),
                        String.valueOf(producto1.getPrecio()), String.valueOf(producto1.getCantidadDisponible())));
                writer.newLine();

            }
            System.out.println("**              Se ha actualizado el archivo exitosamente                  **");
            System.out.println("*****************************************************************************");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }



}


