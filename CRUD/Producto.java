
/**
 * Clase Producto.
 * 
 * @author Jaime Zalo�a Garcia 
 * @version 1.0
 */
public class Producto
{
    // instance variables - replace the example below with your own
    private int codigo;    // C�digo del producto, se utiliza para buscar
    private String nombre; // Nombre del producto
    private int stock;    // existencia actuales
    private int stock_min = 5; // N�mero m�nimo de existencias recomedadas
    private float precio;  // Precio

 
    /**
     * Constructor for objects of class Producto
     * @param codigo Codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     */
    public Producto ( int codigo, String nombre, float precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    
    /**
     * @return Nombre del producto.
     */
    public String getNombre (){
        return nombre;
    }
    /**
     * @return C�digo del producto.
     */
    public int getCodigo (){
        return codigo;
    }
    
    @Override
    public String toString(){
       return codigo +" : "+ nombre +" : "+ stock;
    }
    
    /**
     * @return Unidades de producto que hay en el almac�n.
     */
    public int getStock(){
        return stock;
    }
    
    /**
     * M�todo utilizado para la compra y/o venta de productos. 
     * @param valor
     */
    public void setStock( int valor ){
        stock = valor;
    }
    
    /**
     * @return N�mero m�nimo de existencias recomendadas.
     */
    public int getStock_min(){
        return stock_min;
    }
    
    /**
     * M�todo que cambia el valor del stock m�nmo que debe tener el almacen sobre un producto.
     * @param valor
     */
    public void setStock_min( int valor ){
        stock_min = valor;
    }
    
    
    /**
     * @return Precio del producto
     */
    public float getPrecio(){
        return precio;
    }
    
    /**
     * M�todo para cambiar el precio a un producto.
     * @param valor
     */
    public void setPrecio( float valor ){
        precio = valor;
    }
}
