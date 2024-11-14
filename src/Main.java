import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scannerMenu = new Scanner(System.in);

        int opcionPrincipal;

        do{
            // Menú principal del taller

            System.out.println("*****************************************************************************");
            System.out.println("**            1- Agregar producto                                          **");
            System.out.println("**            2- Actualizar producto                                       **");
            System.out.println("**            3- Eliminar producto                                         **");
            System.out.println("**            4- Buscar por categoria                                      **");
            System.out.println("**            5- Generar reporte                                           **");
            System.out.println("**            6- Cantidad de productos por categoria                       **");
            System.out.println("**            7- Producto más caro                                         **");
            System.out.println("**            8- Salir                                                     **");
            System.out.println("*****************************************************************************");

            // opción del usuario
            System.out.println(" \uD83D\uDC49  Ｄｉｇｉｔｅ  ｕｎａ   ｏｐｃｉｏｎ  ｄｅｌ  Ｍｅｎｕ  \uD83D\uDC48 ");
            // opción invalida del menú
            while (!scannerMenu.hasNextInt()) {
                System.out.println("   \uD83D\uDC80 \uD83D\uDC80  Ｉｎｇｒｅｓｅ  ｎｕｍｅｒｏ  ｖａｌｉｄｏ  ｄｅｌ  ｍｅｎｕ  ｐｏｒ  ｆａｖｏｒ. \uD83D\uDC80 \uD83D\uDC80 ");
                scannerMenu.next();
                System.out.println("                    (⌐■_■) --︻╦╤─ ¬-------- \uD83D\uDCA5   °_°   ");
                System.out.println(" (づ｡◕‿‿◕｡)づ Ｉｎｇｒｅｓｅ ｓｕ  ｏｐｃｉｏｎ  ｄｅ  ｎｕｅｖｏ  (乛-乛)\uD83C\uDFF4\u200D☠\uFE0F  ");
            }

            // captura de la opción del menú principal
            opcionPrincipal = scannerMenu.nextInt();


        }while (opcionPrincipal != 8);
        System.out.println(" \uD83D\uDE0E Saliendo...\uD83D\uDDB1\uFE0F  ");
        scannerMenu.close();
    }
}