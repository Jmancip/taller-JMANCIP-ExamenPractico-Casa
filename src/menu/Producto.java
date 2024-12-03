package menu;

public class Producto {

    // atributos
    private int idProducto;
    private String nombreProducto;
    private String categoria;
    private double precio;
    private int cantidadDisponible;

    // Constructor
    public Producto(int idProducto, String nombreProducto, String categoria, double precio, int cantidadDisponible) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    public void producto() {
        System.out.println("idProducto: " + idProducto);
        System.out.println("Nombre Producto: " + nombreProducto);
        System.out.println("Categoria: " + categoria);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad Disponible" + cantidadDisponible);
    }
}