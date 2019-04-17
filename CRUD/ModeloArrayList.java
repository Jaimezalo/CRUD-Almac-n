
/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ModeloArrayList extends ModeloAbs
{
    private ArrayList <Producto> lista;
    static Scanner sc = new Scanner(System.in);
    
    public ModeloArrayList()
    {
       lista=new ArrayList <Producto>();
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
    	  		
    		lista.add(p);
  	
    	return true;
    }
 
    //Se elimina un producto del almacen a partir de su codigo.
    @Override
	public boolean borrarProducto ( int codigo ){
    	Producto p = lista.get(codigo); //Producto a eliminar
    	if(lista.contains(p)) {
    		System.out.println("El producto " + lista.get(codigo) + " ha sido eliminado");
    		lista.remove(p);
    		
    		return true;
    	}else {
    		System.out.println("No hay ningun producto con ese codigo");
    	}
      return false;
    }
    
    //Devuelve un producto a partir de su codigo.
    @Override
	public Producto buscarProducto ( int codigo) {
 	   Producto buscado = null;
	   
 	   for(Producto n: lista) {
 		   if(n.getCodigo()==codigo) {
 			   buscado = n;
 		   }
 		   
 	   }
 	   return buscado;
    	  
    }
    
    
    //Listado de todos los productos que tenemos en el almacen 
    @Override
	public void listarProductos (){
        Iterator<Producto> nombreIterator = lista.iterator();
        while(nombreIterator.hasNext()){
        	Producto p = nombreIterator.next(); //Producto que va a ser mostrado
        	System.out.print(p.getCodigo() + " " + p.getNombre() + " " + p.getPrecio() + " € " + p.getStock() + " unidades");
        	System.out.println();
        }
    }
    
    
  //Listado de todos los productos con stock inferior
    public void PocoStock (){
    		for(Producto p: lista) {
    			if(p.getStock()<=0) {
    				System.out.println(p.getCodigo() + " " + p.getNombre() + " " + p.getPrecio() + " € " + p.getStock() + " unidades");
    				System.out.println();
    			}
    		}
        
    }
    
    //Modifica el precio de un producto.
    @Override
	public boolean modificarProducto (Producto nuevo){
    	boolean modificado = false;
    	
    		if(lista.contains(nuevo)==false) { //Comprobamos que el producto existe.
    			System.out.println("No existe un producto con ese codigo");
    			return modificado;
    		}
    	
    	System.out.println("El precio actual de: " + nuevo.getNombre() + " es de " + nuevo.getPrecio());
    	System.out.println("Introduzca un nuevo precio para " + nuevo.getNombre());
    	
    	float nuevoPrecio = leerFloat(); //El usuario introduce el nuevo precio.
    	
    		while(nuevoPrecio <= 0) {
    			System.out.println("El precio introducido debe ser mayor de 0€.\nPorfavor vuelva a introducir el importe");
    			nuevoPrecio = leerFloat();
    		}
    	
    	nuevo.setPrecio(nuevoPrecio);
    	System.out.println("Se ha modificado el precio de: " + nuevo.getNombre());
    	System.out.println("El precio actual es de: " + nuevo.getPrecio());
        modificado = true;	
    	
    		
    	return modificado;	
    				
    }

    
    
}    
