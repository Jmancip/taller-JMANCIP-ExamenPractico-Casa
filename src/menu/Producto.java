package menu;

public class Producto {

    // atributos
    private String idProducto;
    private String nombreProducto;
    private String categoria;
    private double precio;
    private int cantidadDisponible;

    // Constructor
    public Producto(String idProducto, String nombreProducto, String categoria, double precio, int cantidadDisponible ){
        this.idProducto =idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidadDisponible =cantidadDisponible;
    }

    // Getters y Setters
    public String getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(String idProducto) {
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

}
