package ejercicios07;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ej1App {

	private static Hashtable<String, Double> notaMedia = new Hashtable<String, Double>();

	public static void main(String[] args) {

		int numAlumnos = pedirNumeroAlumnos();
		pedirNotasAlumnos(numAlumnos);
		mostrarResultados();
	}

	private static int pedirNumeroAlumnos() {
		return Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de alumnos de programacion:"));
	}

	private static void pedirNotasAlumnos(int numAlumnos) {
		for (int i = 1; i <= numAlumnos; i++) {
			String nombre = pedirNombreAlumno();
			double media = calcularMediaAlumno(nombre);
			notaMedia.put(nombre, media);
		}
	}

	private static String pedirNombreAlumno() {
		return JOptionPane.showInputDialog(null, "Introduce el nombre:");
	}

	private static double calcularMediaAlumno(String nombre) {

		double n1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Pon la primera nota de " + nombre + " :"));
		double n2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Pon la segunda nota de " + nombre + " :"));
		return (n1 + n2) / 2;
	}

	// pedirNumeroAlumnos() pide al usuario el número de alumnos y devuelve el valor
	// entero.

//pedirNotasAlumnos(int numAlumnos) usa un bucle for para pedir el nombre y 
//las notas de cada alumno y calcular su media. Los resultados se almacenan en una Hashtable llamada notaMedia.

//pedirNombreAlumno() pide el nombre del alumno y devuelve una cadena.
//
//calcularMediaAlumno(String nombre) pide las dos notas del alumno, calcula su media 
	//y la devuelve como un valor doble.
//
//Finalmente, mostrarResultados() utiliza un bucle for
	//para mostrar los resultados al usuario en un mensaje de diálogo.

	private static void mostrarResultados() {

		String resultado = "Las notas medias son:\n";
		for (String nombre : notaMedia.keySet()) {
			resultado += nombre + ": " + notaMedia.get(nombre) + "\n";
		}
		JOptionPane.showMessageDialog(null, resultado);
	}
}

