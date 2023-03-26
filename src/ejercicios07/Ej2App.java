package ejercicios07;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej2App {

	static final double IVA_GENERAL = 0.21;
	static final double IVA_REDUCIDO = 0.04;
	static double total = 0;
	static double iva;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

	
		añadirCarrito();
		suma();
		mostrarCarro();
	}

	public static ArrayList<Double> carrito = new ArrayList<Double>();

	public static void añadirCarrito() {
		while (true) {
			System.out.print("Cuanto cuesta el producto? (0 para terminar: ");
			Scanner scanner = new Scanner(System.in);

			double precio = scanner.nextDouble();
			if (precio == 0) {
				break;
			}
			carrito.add(precio);
		}
	}

	public static void suma() {
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < carrito.size(); i++) {
			double precio = carrito.get(i);
			total += precio;
		}
		if (total > 100) {
			iva = IVA_REDUCIDO;
		} else {
			iva = IVA_GENERAL;
		}
	}

	public static void mostrarCarro() {
		Scanner scanner = new Scanner(System.in);

		double precioBruto = total;
		double precioMasIVA = total * (1 + iva);
		int cantidadArticulos = carrito.size();

		System.out.println("\nResumen de la compra:");
		System.out.println("IVA aplicado: " + (iva * 100) + "%");
		System.out.println("Precio total bruto: " + precioBruto + "€");
		System.out.println("Precio total con IVA: " + precioMasIVA + "€");
		System.out.println("Número de artículos comprados: " + cantidadArticulos);

		System.out.print("\nIngrese la cantidad pagada: ");
		double cantidadPagada = scanner.nextDouble();
		double cambio = cantidadPagada - precioMasIVA;
		System.out.println("Cambio a devolver: " + cambio + "€");

	}

}
