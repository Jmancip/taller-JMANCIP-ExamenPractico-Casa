package ejecucion;

import utilidades.Validaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        File file = new File("D:\\workspaceintellij2024\\ProyectoFinalTienda\\productos.txt"); // la ruta debe ir con: / ó \\\\
        //System.out.println(file);
        System.out.println(file.exists());  // Validar si existe el archivo en la ruta se comporta como un booleano tru o false

        String ruta = "D:\\workspaceintellij2024\\ProyectoFinalTienda\\";
        String nombreArchivo = "productos.txt";
        Scanner scannerMenu = new Scanner(System.in);
        int opcionprincipal;

        do {
            // menú principal del taller
            menu.Main.menuPrincipal();

            // opción invalida del menú
            //llamamos al metodo -> opcionValida  Objeto-> scannerMenu
            Validaciones.opcionValida(scannerMenu);

            // captura de la opción del menú principal
            opcionprincipal = scannerMenu.nextInt();

            //validación mediante switch para los submenus
            switch (opcionprincipal) {
                // Opcion menu Agregar Productos
                case 1:
                    System.out.println("*****************************************************************************");
                    System.out.println("**                     Agregar Producto                                    **");
                    System.out.println("*****************************************************************************");
                    System.out.println("**           Permite añadir un nuevo producto al inventario                **");
                    System.out.println("**              Diligencie la información que va a agregar                 **");
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;

                // Opcion menu Actualizar producto
                case 2:
                    System.out.println("*****************************************************************************");
                    System.out.println("**                    Actualizar producto                                  **");
                    System.out.println("*****************************************************************************");
                    System.out.println("**           Permite modificar los datos de un producto existente          **");
                    System.out.println("**              Diligencie la información que va a modificar               **");
                    System.out.println("*****************************************************************************");
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;

                // Opcion menu Eliminar producto
                case 3:
                    System.out.println("*****************************************************************************");
                    System.out.println("**                    Eliminar producto                                    **");
                    System.out.println("*****************************************************************************");
                    System.out.println("**              Permite eliminar un producto del inventario.               **");
                    System.out.println("**               el producto  que va a eliminar  es                        **");
                    System.out.println("*****************************************************************************");
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;

                // Opcion menu Buscar por categoría
                case 4:
                    System.out.println("*****************************************************************************");
                    System.out.println("**                    Buscar por categoría                                 **");
                    System.out.println("*****************************************************************************");
                    System.out.println("** Buscar Producto por Categoría, Nombre e ID del Producto: Filtra y       **");
                    System.out.println("**      muestra los productos de una categoría específica.                 **");
                    System.out.println("*****************************************************************************");
                    System.out.println("**               el producto  que va a Buscar  es                          **");
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;
                // Opcion menu Generar reporte
                case 5:
                    System.out.println("*****************************************************************************");
                    System.out.println("**                         Generar reporte                                 **");
                    System.out.println("*****************************************************************************");
                    System.out.println("** Reporte de Inventario: Genera un archivo de texto (reporte_inventario.  **");
                    System.out.println("** con un resumen del inventario, incluyendo el valor total del inventario **");
                    System.out.println("** (suma de precios * cantidades).                                         **");
                    System.out.println("*****************************************************************************");
                    System.out.println("**              Aca esta tu reporte                                        **");
                    System.out.println("**                                                                         **");
                    //Clase   Como extraer datos

                    try (FileReader fr = new FileReader(ruta + nombreArchivo)) {
                        //Clase para leer el contenido
                        BufferedReader br = new BufferedReader(fr);
                        String linea;

                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("**                                                                         **");
                    System.out.println("*****************************************************************************");
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;

                // Opcion menu Cantidad de productos por categoria
                case 6:
                    System.out.println("*****************************************************************************");
                    System.out.println("**              Cantidad de productos por categoria                        **");
                    System.out.println("*****************************************************************************");
                    System.out.println("**   Calcular Cantidad de Productos:                                       **");
                    System.out.println("**   Permite conocer la cantidad de productos por categoria                **");
                    System.out.println("**                                                                         **");
                    System.out.println("*****************************************************************************");
                    System.out.println("**              esta es la cantidad de productos                           **");
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;
                // Opcion menu Producto más caro
                case 7:
                    System.out.println("*****************************************************************************");
                    System.out.println("**                      Producto más caro                                  **");
                    System.out.println("*****************************************************************************");
                    System.out.println("** Calcular Precio de Producto:                                            **");
                    System.out.println("** Permite validar cuál es el producto con mayor valor.                    **");
                    System.out.println("**                                                                         **");
                    System.out.println("*****************************************************************************");
                    System.out.println("**      El producto o los productos mas caros son:                         **");
                    System.out.println("**                                                                         **");
                    System.out.println("*****************************************************************************");
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter

                    break;



            }
        } while (opcionprincipal != 8);
        System.out.println(" \uD83D\uDE0E Saliendo...\uD83D\uDDB1\uFE0F  ");
        System.out.println("   \uD83D\uDC4B\uD83C\uDFFC ＨＡＳＴＡ  ＰＲＯＮＴＯ \uD83D\uDC4B\uD83C\uDFFC ");
        System.out.println(" ⠀⠀⠀⠀⠀⠀⣀⣀⠤⠀⠒⠒⠒⠢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⢤⡀⣠⣀⣈⣲⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⢀⡔⢁⠄⠀⠀⠀⠀⠀⢈⡽⠋⠙⢍⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⢠⠋⢀⡼⠤⠤⣀⠀⠀⠀⡎⠀⠰⠽⠈⢣⢳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢰⡏⢰⣿⣁⠀⠀⠈⡅⠀⠀⠱⣄⠀⠀⠀⢀⠇⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢸⠃⠈⣭⠛⠁⢀⡔⣱⠊⠙⡭⠛⢯⣍⣭⡁⠀⠘⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢸⠀⠘⢩⠑⠒⠃⢰⢘⠦⠊⠀⠀⠈⠉⠁⠘⣄⠀⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢸⡄⠀⠀⠀⠀⠀⡧⠚⠀⠀⢀⣀⡠⠤⠤⠐⠁⠀⢰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⣷⠀⠀⠀⠀⢀⠃⣠⠔⠊⠁⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠘⣆⠀⠀⢀⡾⠊⠀⠀⠀⠀⢀⣀⣀⣤⡤⣄⠀⡸⡠⠤⠀⢀⠈⢲⠉⡏⠈⡇\n" +
                "⠀⠀⠈⠃⠄⡀⠀⢰⠏⢳⠀⠀⡼⠀⡏⢀⡇⢸⣤⡇⠃⠀⡇⡜⢀⡞⣰⠃⠀⡇\n" +
                "⠀⠀⠀⠀⠀⠈⠀⢸⠀⢸⠤⠴⠃⠼⠁⠞⠀⢸⠋⠀⡆⠀⠉⠁⠀⠈⠀⠁⡠⠔\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⡠⠖⠁⡠⠞⠁⠀⢀⡠⠞⢁⣠⠞⠁⠀\n" +
                "⠀⠀⠀⠀⠀⠴⠚⠁⠀⠀⠀⠀⣀⡤⠊⠀⠀⠀⠀⠀⠀⠠⠋⠐⠊⠉⠀⠀⠀⠀ ");
        scannerMenu.close();
    }
}