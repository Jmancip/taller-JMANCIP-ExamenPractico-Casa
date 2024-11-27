package menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    // Cargar productos desde el archivo
    public void cargarProductos(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                productos.add(new Producto(
                        datos[0], datos[1], datos[2],
                        Double.parseDouble(datos[3]),
                        Integer.parseInt(datos[4])
                ));
            }
        }
    }



}
