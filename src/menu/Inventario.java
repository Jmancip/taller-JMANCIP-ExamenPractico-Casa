package menu;

import java.io.*;
import java.util.*;

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
                System.out.println("**           Ese id del Producto no esta en el inventario                 **");
            }
        } catch (NumberFormatException e) {
            System.out.println("**              El ID ingresado no es un número valido                          **");
        }
    }

    public static void escribirInventario(List<Producto> listaProducto) {
        //BufferedWriter: Escribir el texto al archivo
        //FileWriter: Abrir archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoProductos))) {
            // Escribir una línea por cada producto en el ArrayList
            for (Producto producto1 : listaProducto) {
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


    // Eliminar producto opción 3 del menú
    public static void eliminarProducto() {
        List<Producto> listaProductos = Inventario.lecturaProduct();
        try {
            Scanner scanId = new Scanner(System.in);
            System.out.println("*****************************************************************************");
            System.out.println("**                    Eliminar Producto                                    **");
            System.out.println("*****************************************************************************");
            System.out.println("**              \uD83D\uDC49   Ingrese el ID del producto a eliminar:                **");
            int productoEliminar = Integer.parseInt(scanId.nextLine());
            System.out.println("**               Se elimino con exito el registro                          **");

            boolean existe = false;
            for (Producto producto : listaProductos) {
                if (productoEliminar == producto.getIdProducto()) {
                    listaProductos.remove(producto);
                    existe = true;
                    break;
                }
            }

            if (existe) {
                //Actualizar archivo
                escribirInventario(listaProductos);

            } else {
                System.out.println("**           Ese id del Producto no esta en el inventario                 **");
            }
        } catch (NumberFormatException e) {
            System.out.println("**              El ID ingresado no es un número valido                          **");
        }
    }

    // buscar Categoria opción 4 del menú
    public static void buscarCategoria() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*****************************************************************************");
            System.out.println("**                    Buscar por categoría                                 **");
            System.out.println("*****************************************************************************");
            System.out.println("**    En la tienda se encuentran estas categorias :                        **");
            System.out.println("**    Verdura, Bebidas, Confites, Frios, Mercado, Aseo Personal            **");
            System.out.println("**              \uD83D\uDC49   Diligencie la que va a buscar :                      **");

            String categoria = scanner.nextLine();
            List<Producto> productos1 = Inventario.lecturaProduct();
            List<Producto> productosXCategoria = new ArrayList<>();

            for (Producto producto : productos1) {
                if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                    productosXCategoria.add(producto);
                }
            }
            if (!productosXCategoria.isEmpty()) {
                System.out.println("** Esto es lo que hay en la tienda :                                      **");
                System.out.println(" Id\tProducto\tCategoria\tPrecio\tCantidad Disponible ");
                for (Producto producto : productosXCategoria) {
                    System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t" + producto.getCategoria() + "\t\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
                    System.out.println("*****************************************************************************");
                }
            } else {
                System.out.println("**      No existen productos asociados a esa categoria                      **");
            }
        } catch (NumberFormatException e) {
            System.out.println("Intenta nuevamente ");
        }
    }

    // Generar reporte opción 5 del menú
    public static void generarReporte() {

        final String reporte;
        reporte = "D:\\workspaceintellij2024\\ProyectoFinalTienda\\reporte_inventario.txt";

        System.out.println("*****************************************************************************");
        System.out.println("**                         Generar reporte                                 **");
        System.out.println("*****************************************************************************");
        System.out.println("** Reporte de Inventario: Genera un archivo de texto (reporte_inventario.  **");
        System.out.println("** con un resumen del inventario, incluyendo el valor total del inventario **");
        System.out.println("** (suma de precios * cantidades).                                         **");
        System.out.println("*****************************************************************************");
        System.out.println("**                 Aca esta tu reporte                                     **");
        System.out.println("**                                                                         **");

        String titulo = "Id Producto\tNombre Producto\tCategoria\tPrecio\tCantidad Disponible\tValor Total Producto";
        List<Producto> listaProductos = Inventario.lecturaProduct();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporte))) {
            double valor = 0;

            // Escribir una línea por cada producto en el ArrayList
            writer.write(titulo);
            writer.newLine();

            for (Producto producto : listaProductos) {
                double valorProducto = producto.getPrecio() * producto.getCantidadDisponible();
                valor += valorProducto;

                writer.write(String.join("\t\t", String.valueOf(producto.getIdProducto()),
                        producto.getNombreProducto(), producto.getCategoria(),
                        String.valueOf(producto.getPrecio()), String.valueOf(producto.getCantidadDisponible()), String.valueOf(valorProducto)));
                writer.newLine();

            }
            writer.newLine();
            writer.newLine();
            writer.write("Valor total del inventario en la tienda es \uD83D\uDC49 $  " + valor);

            System.out.println("**          \uD83D\uDC49   El reporte se encuentra en la ruta:                       **");
            System.out.println("**   " + reporte + "   **");

            System.out.println("**                      Archivo creado con éxito.                          **");
            System.out.println("*****************************************************************************");
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Categoria  opcion 6 del menu
    public static void categoria() {
        // HashMap se utiliza para almacenar la info de la categoria (llave, valor)
        System.out.println("*****************************************************************************");
        System.out.println("**              Cantidad de productos por categoría                        **");
        System.out.println("*****************************************************************************");
        System.out.println("**   Calcular Cantidad de Productos:                                       **");
        System.out.println("**   Permite conocer la cantidad de productos por categoria                **");
        System.out.println("**              esta es la cantidad de productos                           **");
        System.out.println("*                                                                 *");
        Map<String, Integer> categoriaTotal = new HashMap<>();
        try (BufferedReader leerCantProd = new BufferedReader(new FileReader(archivoProductos))) {
            String linea;
            while ((linea = leerCantProd.readLine()) != null) {
                String[] campos = linea.split(";");
                String categoria = campos[2];
                int cantidadDisponible = Integer.parseInt(campos[4]);
                // el metodo getOrDefault se usa para dar un valor cuando las claves son ausentes
                categoriaTotal.put(categoria, categoriaTotal.getOrDefault(categoria, 0) + cantidadDisponible);

            }
        } catch (IOException e) {
            //muestra con exactitud en donde esta el error de codigo
            e.printStackTrace();

        }
        for (Map.Entry<String, Integer> entry : categoriaTotal.entrySet()) {
            System.out.println("Categoria " + entry.getKey() + " Total productos por categoria: " + entry.getValue());
        }
        System.out.println("*                                                                 *");
        System.out.println("*******************************************************************");

    }

    // Producto más caro opción 7 del menú
    public static void productoCostoso() {

        System.out.println("*****************************************************************************");
        System.out.println("**                      Producto más caro                                  **");
        System.out.println("*****************************************************************************");
        System.out.println("** Calcular Precio de Producto:                                            **");
        System.out.println("** Permite validar cuál es el producto con mayor valor.                    **");
        System.out.println("**                                                                         **");

        List<Producto> productoCaro = Inventario.lecturaProduct();

        Producto costoso = null;
        double valorCostoso = Double.MIN_VALUE;
        for (Producto producto : productoCaro) {
            if (producto.getPrecio() > valorCostoso) {
                valorCostoso = producto.getPrecio();
                costoso = producto;
            }
        }
        if (costoso != null) {
            System.out.println("**  El producto mas costoso en la tieda es \uD83D\uDC49: " + costoso.getNombreProducto() + "                   **");
            System.out.println("**  con un valor de $ " + valorCostoso + "                                               **");
        }
        System.out.println("*****************************************************************************");
    }


}


