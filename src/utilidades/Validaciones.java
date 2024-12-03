package utilidades;

import java.util.Scanner;

public class Validaciones {

    public static void opcionValida (Scanner scanner) {

        while (!scanner.hasNextInt()) {
            System.out.println("   \uD83D\uDC80 \uD83D\uDC80  ｉｎｇｒｅｓｅ  ｎｕｍｅｒｏ  ｖａｌｉｄｏ  ｄｅｌ  ｍｅｎｕ  ｐｏｒ  ｆａｖｏｒ. \uD83D\uDC80 \uD83D\uDC80 ");
            scanner.next();
            System.out.println("                    (⌐■_■) --︻╦╤─ ¬-------- \uD83D\uDCA5   °_°   ");
            System.out.println(" (づ｡◕‿‿◕｡)づ ｉｎｇｒｅｓｅ ｓｕ  ｏｐｃｉｏｎ  ｄｅ  ｎｕｅｖｏ  (乛-乛)\uD83C\uDFF4\u200D☠\uFE0F  ");
        }

    }

}
