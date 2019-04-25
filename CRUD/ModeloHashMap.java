
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ModeloHashMap extends ModeloAbs{
	
    private HashMap <Integer,Producto> lista;
    static Scanner sc = new Scanner(System.in);
    
    public ModeloHashMap(){
       lista = new HashMap  <Integer,Producto>();
    }
    
    
    static private float leerFloat(){
        
        boolean error = false;
        float valor =0;
        String cadena;
        do {
        error = false;  
          try {
             // Intento leer directamente un entero  
             cadena = sc.nextLine();
             valor = Float.parseFloat(cadena);
             
             
            } catch(NumberFormatException e){
              System.out.println("Error en formato.");
              error = true;
            }
        }
       while ( error);
       return valor;
    }
    
    @Override
	public boolean insertarProducto ( Producto p){
    	if(lista.containsKey(p.getCodigo())) {
    		return false;
    	}else {
    		lista.put(p.getCodigo(), p);
    		return true;
    	}
    	
    }
 
    //Se elimina un producto del almacen a partir de su codigo.
    @Override
	public boolean borrarProducto ( int codigo ){
    	if(lista.containsKey(codigo)) {
    		System.out.println("El producto " + lista.get(codigo) + " ha sido eliminado");
    		lista.remove(codigo);
    		
    		return true;
    	}else {
    		System.out.println("No hay ningun producto con ese codigo");
    	}
      return false;
    }
    
    //Devuelve un producto a partir de su codigo.
    @Override
	public Producto buscarProducto ( int codigo) {
    	if(lista.containsKey(codigo)) { //Comprobamos que el producto existe.
    		return lista.get(codigo);
    	}else
    		return null;    
    }
    
    
    //Listado de todos los productos que tenemos en el almacen 
    @Override
	public void listarProductos (){
    	lista.forEach((k,v) -> System.out.println(k + " " + v.getNombre() + " " + v.getPrecio() + " � " + v.getStock() + " unidades"));
    }
    
    
  //Listado de todos los productos que tenemos en el almacen 
    public void PocoStock (){
    	for (Entry<Integer, Producto> entry : lista.entrySet()) {
    		if(entry.getValue().getStock()<=entry.getValue().getStock_min()) {
    			Producto p = entry.getValue();
    			System.out.println(p.getCodigo() + " " +  p.getNombre() + " " + p.getPrecio() + " � " + p.getStock() + " unidades");
    		}
    	    	
    	}
    }
    
    //Modifica el precio de un producto.
    @Override
	public boolean modificarProducto (Producto nuevo){
    	boolean modificado = false;
    	
    		if(lista.containsKey(nuevo.getCodigo())==false) { //Comprobamos que el producto existe.
    			System.out.println("No existe un producto con ese codigo");
    			return modificado;
    		}
    	
    	System.out.println("El precio actual de: " + nuevo.getNombre() + " es de " + nuevo.getPrecio());
    	System.out.println("Introduzca un nuevo precio para " + nuevo.getNombre());
    	
    	float nuevoPrecio = leerFloat(); //El usuario introduce el nuevo precio.
    	
    		while(nuevoPrecio <= 0) {
    			System.out.println("El precio introducido debe ser mayor de 0�.\nPorfavor vuelva a introducir el importe");
    			nuevoPrecio = leerFloat();
    		}
    	
    	nuevo.setPrecio(nuevoPrecio);
    	System.out.println("Se ha modificado el precio de: " + nuevo.getNombre());
    	System.out.println("El precio actual es de: " + nuevo.getPrecio());
        modificado = true;	
    	
    		
    	return modificado;	
    				
    }
    
}
