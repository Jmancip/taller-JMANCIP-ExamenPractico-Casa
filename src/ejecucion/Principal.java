package ejecucion;

import menu.Inventario;
import menu.Main;
import menu.Producto;
import utilidades.Validaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static utilidades.Validaciones.*;

public class Principal {
    public static void main(String[] args) {

        Scanner scannerMenu = new Scanner(System.in);

        File file = new File("D:\\workspaceintellij2024\\ProyectoFinalTienda\\productos.txt"); // la ruta debe ir con: / ó \\\\
        //System.out.println(file);
        System.out.println(file.exists());  // Validar si existe el archivo en la ruta se comporta como un booleano tru o false

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
                    Inventario.agregarProducto();

                    System.out.println("**              \uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F              **\n");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;

                // Opcion menu Actualizar producto
                case 2:
                    Inventario.actualizarProducto();

                    System.out.println("**              \uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F              **\n");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;

                // Opcion menu Eliminar producto
                case 3:
                    Inventario.eliminarProducto();

                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;

                // Opcion menu Buscar por categoría
                case 4:
                    Inventario.buscarCategoria();
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter

                    break;

                // Opcion menu Generar reporte
                case 5:
                    Inventario.generarReporte();
                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter
                    break;

                // Opcion menu Cantidad de productos por categoria
                case 6:
                    Inventario.categoria();

                    System.out.println("\uD83D\uDE0E Para continuar presione la tecla enter \uD83D\uDDB1\uFE0F \n ");
                    scannerMenu.nextLine(); // Captura el salto de línea restante
                    scannerMenu.nextLine(); // Espera a que el usuario presione Enter

                    break;



                // Opcion menu Producto más caro
                case 7:
                    Inventario.productoCostoso();
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