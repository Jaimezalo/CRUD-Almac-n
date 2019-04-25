
import java.util.Scanner;


/**
 * CRUD de un almacen de productos.
 * @author Jaime Zalo�a
 * @since 10/04/2019
 *
 */
public class MiAlmacen
{
    
	
	static private ModeloAbs almacen; 
    static Scanner sc;
    
    public static void main(String[] args){
    	
        almacen = new ModeloArrayList (); //Implementacion mediante ArrayList.
    	//almacen = new ModeloHashMap();    //Implementacion mediante HashMap.
        sc = new Scanner(System.in);
        int opcion=0; 
        
        do{
		mostrarMenu();
                opcion=leerOpcion(1,9);
                switch(opcion){
                    case 1: crear();break;
                    case 2: consultar();break;
                    case 3: borrar();break;
                    case 4: modificarPrecio();break;
                    case 5: comprar();break;
                    case 6: vender();break;
                    case 7: listar();break;
                    case 8: listarPocoStock();break;
                    case 9: System.out.println("Hasta pronto");break;
                    default: System.out.println("Opcion incorrecta");break;
                }
                System.out.println("\n---------------------------- ");
                System.out.print("Pulse enter para continuar");
                sc.nextLine();
        }while(opcion!=9);
        sc.close();
        
    }
    
    
    /**
     * Muestra el menu principal con las diferentes opciones
     */
    private static void mostrarMenu(){
        System.out.println("\n\n    MENU");
        System.out.println("1. Nuevo producto ");
        System.out.println("2. Consulta producto ");
        System.out.println("3. Borrar producto ");
        System.out.println("4. Modificar precio ");
        System.out.println("5. Compra de productos ");
        System.out.println("6. Venta de productos ");
        System.out.println("7. Listado completo de productos ");
        System.out.println("8. Listado de productos con stock inferior al mínimo");
        System.out.println("9. Terminar ");
        System.out.print("Elige una opción (1-9)");        
    }
    
    // 
    /**
     * Lee un entero del System.in que este comprendido entre primero y ultimo
     * del menu principal
     * @param primero
     * @param ultimo
     * @return valor elegido por el usuario
     */
    private static int leerOpcion(int primero, int ultimo){
        int valor = leerEntero();
        while ( valor <primero || valor > ultimo){
            valor = leerEntero();
        }
        return valor;
    }
      
    
    
    /**
     * Metodo auxiliar
     * Lee de la System.in con el scanner sc y controlan la excepcion de NumberFormatException
     * @return Valor introducido por teclado
     */
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
    
    
    /**
     * Metodo auxiliar
     * Lee de la System.in con el scanner sc y controlan la excepcion de NumberFormatException
     * @return Valor introducido por teclado
     */
    static private int leerEntero(){
        boolean error = false;
        int valor =0;
        String cadena;
        do {
        error = false;  
          try {
      
             cadena = sc.nextLine();
             valor = Integer.parseInt(cadena);
             
             
            } catch(NumberFormatException e){
              System.out.println("Error en formato.");
              error = true;
            }
        }
       while ( error);
       return valor;
      
    }

     
    /**
     * Muestra los datos de un producto a partir de su codigo
     */
    private static void consultar(){
    	System.out.print("<CONSULTAR>");
       System.out.print("Introduzca codigo:");
       int codigo = leerEntero();
       try {
    	   Producto p=almacen.buscarProducto(codigo);
    	   System.out.println("Producto: " + p.getNombre() + " |Precio: " + p.getPrecio() + "�" );   
       }catch(NullPointerException e) {
    	   System.out.println("No existe el producto con codigo " + codigo);
       }
       
       
    }
    
     
    /**
     * Borrar un producto a partir de su codigo
     */
    private static void borrar(){       
      System.out.println("<ELIMINAR>");
      System.out.println("Introduzca el codigo");
      int codigo = leerEntero();
      almacen.borrarProducto(codigo);
    }
    
    
    /**
     * Cambia el precio de un producto a partir de su codigo
     */
    private static void modificarPrecio (){
       System.out.println("<MODIFICAR PRECIO>");
       System.out.println("Introduzca el codigo");
       int codigo = leerEntero();
       Producto p = almacen.buscarProducto(codigo);
       almacen.modificarProducto(p);
    }
    
    
    /**
     * Incrementa el stock si la cantidad es inferior de la recomendada.
     */
    private static void comprar(){     
       System.out.println("<COMPRAR>");
       System.out.println("Introduzca el codigo");
       int codigo = leerEntero();
       while(almacen.buscarProducto(codigo)==null) {
    	   System.out.println("No existe ningun producto con ese codigo.\nVuelva a introducir el codigo");
    	   codigo = leerEntero();
       }
       Producto p = almacen.buscarProducto(codigo);
       if(p.getStock()<p.getStock_min()) {
    	   p.setStock(p.getStock_min());
       }

       
       
    }
    
    
    /**
     * Decrementa el stock
     */
    private static void vender(){
        System.out.println("<VENDER>");
        System.out.println("Introduzca el codigo");
        int codigo = leerEntero();
        Producto p = almacen.buscarProducto(codigo);
        System.out.println("Introduzca la cantidad");
        int cantidad = leerEntero();
        if(cantidad <= p.getStock()) {
        p.setStock(cantidad);
        }else
        	System.out.println("No hay stock suficiente para vender");
    }
    
   
    /**
     * Listado de todos los productos
     */
    private static void listar(){        
         almacen.listarProductos();
    }
    
    /*
    /**
     * Listado de todos los productos con stock inferior a stock minimo
     */
    private static void listarPocoStock(){
    	almacen.PocoStock();
    	
    }
    
    
    /**
     * Solicita datos al usuario para dar de alta un nuevo producto
     * El codigo no se puede repetir
     */
    private static void crear(){
    	System.out.println("<NUEVO PRODUCTO>");
    	System.out.println("Introduzca el codigo");
    	int codigo = leerEntero();
       
    	//Se comprueba que no existe ningun producto con el codigo introducido
    	while(almacen.buscarProducto(codigo)!=null) {
    	   System.out.println("El codigo introducido pertenece a otro producto");
    	   System.out.println("Introduzca otro codigo");
           codigo = leerEntero(); //Codigo del producto
    	}

    	System.out.println("Introduzca el nombre");
    	String nombre = sc.nextLine(); //Nombre del producto
    	System.out.println("Introduzca el precio");
    	float precio = leerFloat(); //Precio del producto
    	
    	//Se comprueba que el precio introducido es correcto
    	while(precio <= 0.0) {
    		System.out.println("El precio debe ser mayor de 0�. Vuelva a introducir un precio");
    		precio = leerFloat();
    	}
    	
    	//Se crea el nuevo producto
    	Producto nuevo = new Producto(codigo, nombre, precio);
    	if(almacen.insertarProducto(nuevo)) {
    		System.out.println("Producto insertado");
    	}else {
    		System.out.println("Fallo al insertar");
    	}
    }
       
  
}

