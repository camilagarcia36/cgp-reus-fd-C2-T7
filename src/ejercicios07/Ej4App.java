package ejercicios07;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ej4App {
	
	public static Hashtable<String, int[]> db = new Hashtable<String, int[]>();
	public static ArrayList<Integer> carrito = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		basedeDatos();
		
		String opcion;
		do {
			opcion = JOptionPane.showInputDialog("¿Qué opción deseas realizar: mostrar / agregar / salir?");

			switch (opcion) {
				case "mostrar":
					mostarProductos();
					break;
				case "agregar":
					crearProducto();
					break;
				case "salir":
					System.exit(0);
					break;
				default:
					System.out.println("Has introducido una opción incorrecta");
					break;
				}
		} while (opcion != "salir");

	}

	public static void basedeDatos() {

		String nombres[] = {"iogurts","agua","queso","legumbres","mermelada","turron","arroz","pan","coca cola","patatas"};
		
		for (int i = 0; i < 10; i++) {
			int productos[] = new int[2];
			db.put(nombres[i], productos);
			for(int j = 0; j < 2 ; j++) {
				double random = Math.random() * (10 - 1) + 0;
				productos[j] = (int) random;
			}
		}
	}

	public static void crearProducto() {
		String nombre = JOptionPane.showInputDialog("Añade un producto");
		int precio = Integer.parseInt(JOptionPane.showInputDialog("¿Cual es su precio?"));
		int cantidad =Integer.parseInt(JOptionPane.showInputDialog("¿Cuanta cantidad quieres añadir?"));
		int productoNuevo[] = new int[2]; 
		productoNuevo[0] = precio;
		productoNuevo[1] = cantidad;
		db.put(nombre, productoNuevo);
	}

	public static void mostarProductos() {
		for (String i : db.keySet()) {
			int[] informacion = db.get(i).clone();
			System.out.println("Producto: " + i + " tiene un precio de: " + informacion[0] + " con un stock de: " + informacion[1]);
		}
		System.out.println(" ");
		System.out.println("-------");
		System.out.println(" ");
	}

	public static double iva(int producto, String ivaAplicado) {
		double precioTotal = 0;
		
		switch (ivaAplicado) {
			case "21%":
				precioTotal = producto + (producto * 0.21);
				break;
			case "4%":
				precioTotal = producto + (producto * 0.04);
				break;
			default:
				System.out.println("Has introducido un porcentaje erróneo");
				break;
			}
		return precioTotal;
	}
	
	public static void mostrar() {
		String ivaAplicado = JOptionPane.showInputDialog("IVA aplicado: 21% o 4%");
		
		for (int i = 0; i < carrito.size(); i++) {
			System.out.println("El producto " + (i+1) + " tiene un precio bruto de " + carrito.get(i) + " y un precio con iva de " 
								+ iva(carrito.get(i), ivaAplicado));
		}
		
		System.out.println("El número de productos comprados es: " + carrito.size());
		cambio();
	}

	public static void cambio() {
		int precioTotal = 0;
		
		for (int i = 0; i < carrito.size(); i++) {
			precioTotal = precioTotal + carrito.get(i);
		}
		
		System.out.println("El total a pagar es: " + precioTotal);
		int devolver = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto ha pagado?"));
		System.out.println("El cambio a devolver es: " + (devolver-precioTotal));
	}
	
	public static void crearCarrito() {
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cual es la cantidad de productos comprados?"));
		for (int i = 0; i < cantidad; i++) {
			String producto = JOptionPane.showInputDialog("¿Qué producto quieres comprar?");
			int precio[] = db.get(producto);
			carrito.add(precio[0]);
		}
		mostrar();
	}
}

