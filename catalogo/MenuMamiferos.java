package catalogo;

import java.util.Collections;

import utiles.*;

/**
 * Modelo de examen de 2013 Asignatura: Programacion
 * 
 * @author Pablo Leon
 * 
 */
public class MenuMamiferos{
	static ListaMamiferos catalogo = new ListaMamiferos();
	public static void main(String[] args) {
		Menu menu = new Menu("**Catalogo de Mamiferos", new String[] {
				"Anadir Mamifero", "Listar mamiferos", "Listar humanos",
				"Listar focas en orden inverso", "Contar murcielagos",
				"Alimentar a todos los mamiferos del catalogo","ordenar por nombre" });
		do {
			try {
				switch (menu.gestionar()) {
				case 1:
					anadir();
					break;
				case 2:
					listaMamiferos();
					break;
				case 3:
					listaHumanos();
					break;
				case 4:
					listaFocas();
					break;
				case 5:
					cuentaMurcielagos();
					break;
				case 6:
					alimentar();
					break;
				case 7:
					ordenarAnimales();break;
					
				case 8: System.out.println("Adios!");
				return;
				}
			} catch (ListaVaciaException e) {
				System.out.println(e.getMessage());
			}
		} while (menu.getOpcion() != 8);
	}

	private static void ordenarAnimales() {
		catalogo.ordenar();
		for(Mamifero m:catalogo.catalogo()){
			System.out.println(m.getNombre());
		}
	}

	private static void alimentar() throws ListaVaciaException {
		if (listaVacia()) {
			throw new ListaVaciaException(
					"introduce animales antes de alimentar al aire");
		}
		for (Mamifero mamifero : catalogo.catalogo()) {
			System.out.println(mamifero.getNombre() + " "
					+ mamifero.alimentar());
		}

	}

	private static boolean listaVacia() {
		return catalogo.size() == 0;
	}

	private static void cuentaMurcielagos() throws ListaVaciaException {

		int cantidad = 0;

		for (Mamifero mamifero : catalogo.catalogo()) {
			if (mamifero instanceof Murcielago) {
				cantidad++;
			}
		}
		if (cantidad == 0) {
			throw new ListaVaciaException("introduce algun murcielago primero");
		}
		System.out.println("hay " + cantidad + " murcielagos");

	}

	/**
	 * Si el catalogo no esta vacio, recorre en orden inverso el listado de
	 * focas
	 * 
	 * @throws ListaVaciaException
	 */
	private static void listaFocas() throws ListaVaciaException { //PRECIOSA LISTA
		if (listaVacia()) {
			throw new ListaVaciaException("introduce focas antes");
		}
		System.out.println("***lista de focas***");
		for (int i = catalogo.size() - 1; i >= 0; i--) {
			if (catalogo.get(i) instanceof Foca)
				System.out.println((i) + "- " + catalogo.get(i).getNombre()
						+ " etapa: " + catalogo.get(i).getEtapa());
		}
	}

	/**
	 * Si el catalogo no esta vacio, recorre el listado de humanos
	 * 
	 * @throws ListaVaciaException
	 */
	private static void listaHumanos() throws ListaVaciaException {
		if (listaVacia()) {
			throw new ListaVaciaException("introduce a alguien primero");
		}
		System.out.println("***lista de humanos***");
		int i = 1;
		for (Mamifero mamifero : catalogo.catalogo()) {
			if (mamifero instanceof HomoSapiens) {
				System.out.println((i++) + "- " + mamifero.getNombre()
						+ " etapa: " + mamifero.getEtapa());
			}
		}

	}

	/**
	 * Si el catalogo no esta vacio, muestra y alimenta a todo el catalogo
	 * 
	 * @throws ListaVaciaException
	 */
	private static void listaMamiferos() throws ListaVaciaException {
		if (listaVacia()) {
			throw new ListaVaciaException("introduce animales primero");
		}
		System.out.println(catalogo.catalogo());

	}

	/**
	 * Menu que permite seleccionar la especie a introducir en el catalogo
	 */
	private static void anadir() {
		Menu menu2 = new Menu("**Elige un mamifero de la lista", new String[] {
				"Homo Sapiens", "Murcielago", "Foca" });
		do {
			try {
				switch (menu2.gestionar()) {
				case 1:
					catalogo.add(new HomoSapiens(Teclado
							.leerCadena("introduce un nombre")));
					break;
				case 2:
					catalogo.add(new Murcielago(Teclado
							.leerCadena("introduce un nombre")));
					break;
				case 3:
					catalogo.add(new Foca(Teclado.leerCadena("introduce un nombre")));
					break;
				case 4:
					System.out.println("Lo dejamos para luego");
					return;
				}
			} catch (AnimalExisteException e) {
				System.out.println(e.getMessage());
			}
		} while (menu2.getOpcion() != 4);
	}

}
