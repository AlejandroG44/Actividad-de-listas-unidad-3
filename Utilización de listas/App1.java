package appNombres;

import ed.ito.ListaOrdenada;
import javax.swing.JOptionPane;
import ed.ito.ExcepcionDeListaLlena;
import ed.ito.ExcepcionDeListaVacia;

public class App1 {

	static ListaOrdenada<String> l = new ListaOrdenada<String>(30);

	static int menu() {
		int ops = 0;
		String[] datos = { "1.- Agregar Nombre", "2.- Mostrar primer nombre", "3.- Mostrar ienesimo nombre",
				"4.- Mostrar ultimo nombre", "5.- Mostrar cantidad de nombres", "6.- Eliminar  el primer nombre",
				"7.- Eliminar un nombre", "8.- Salir" };
		String x = (String) JOptionPane.showInputDialog(null, "Seleccione uno", "Menu", JOptionPane.INFORMATION_MESSAGE,
				null, datos, datos[0]);
		ops = Integer.parseInt(x.charAt(0) + "");
		return ops;

	}

	private static void eliminarN() {
		try {
			String n= JOptionPane.showInputDialog("Nombre a eliminar");
			l.delete(n);
			JOptionPane.showMessageDialog(null, n, "Eliminar nombre",0);
		}catch(ExcepcionDeListaVacia e) {
			System.err.println(e.getMessage());
		}
	}

	private static void eliminarP() {
		try {
			String n=l.deleteLast();
			JOptionPane.showMessageDialog(null, n, "Ultimo nombre",0);
		}catch(ExcepcionDeListaVacia e) {
			System.err.println(e.getMessage());
		}

	}

	private static void cantidad() {
		JOptionPane.showMessageDialog(null, "Cantidad de nombres: " + l.size(), "Total de nombre:", 0);

	}

	private static void ultimo() {
		try {
			String n = l.last();
			JOptionPane.showMessageDialog(null, n, "Ultimo nombre", 0);
		} catch (ExcepcionDeListaVacia e) {
			System.err.println(e.getMessage());
		}
	}

	private static void ienesimo() {
		// TODO Auto-generated method stub

	}

	private static void primer() {
		try {
			String n = l.first();
			JOptionPane.showMessageDialog(null, n, "Primer nombre", 0);
		} catch (ExcepcionDeListaVacia e) {
			System.err.println(e.getMessage());
		}

	}

	private static void agregar() {
		String n = new String("");
		n = JOptionPane.showInputDialog(null, "Ingrese un nombre: ");
		try {
			l.add(n);
		} catch (ExcepcionDeListaLlena e) {
			System.err.println(e.getMessage());

		}
	}

	static void run() {
		boolean salir = false;
		while (!salir) {
			switch (menu()) {
			case 1:
				agregar();
				break;
			case 2:
				primer();
				break;
			case 3:
				ienesimo();
				break;
			case 4:
				ultimo();
				break;
			case 5:
				cantidad();
				break;
			case 6:
				eliminarP();
				break;
			case 7:
				eliminarN();
				break;
			case 8:
				salir = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		run();
	}
}
