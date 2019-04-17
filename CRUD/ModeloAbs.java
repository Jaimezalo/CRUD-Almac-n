

/**
 * Clase abstracta donde con los distintos métodos que serán implementados
 * @author Jaime Zaloña Garcia
 * @since 24/04/2018
 */
public abstract class ModeloAbs
{
    public ModeloAbs() {
    }
    
    /**
     * Inserta un nuevo producto en el almacen.
     * @param p Producto a insertar.
     * @return true si la operacion ha sido correcta o de lo contrario false. 
     */
    abstract public boolean insertarProducto ( Producto p);
    
    /**
     * Elimina un producto del almacen.
     * @param codigo Clave del producto que queremos eliminar
     * @return true si la operacion ha sido correcta o de lo contrario false.
     */
    abstract boolean borrarProducto ( int codigo );
    
    /**
     * Devuelve un producto del almacen a partir de su clave.
     * @param codigo Clave del producto que queremos buscar.
     * @return El producto que buscamos o null si no se encuentra en el almacen.
     */
    abstract public Producto buscarProducto ( int codigo);
    
    /**
     * Listado de todos los productos que tenemos en el almacen.
     */
    abstract void listarProductos ();
    
    /**
     * Muestra un listado de los productos cuyo stock_min es superior al stock actual.
     */
    	abstract void PocoStock ();
    
    /**
     * Modifica el precio de un producto. El nuevo precio será introducido por el usuario.
     * @param nuevo Producto que se va a modificar
     * @return true si la operacion ha sido correcta o de lo contrario false.
     */
    abstract boolean modificarProducto (Producto nuevo);


	

	
    
    
}
