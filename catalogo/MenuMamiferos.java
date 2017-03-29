package catalogo;

import java.util.*;

import utiles.*;

/**
 * Modelo de examen de 2013 Asignatura: Programacion
 * 
 * @author Pablo Leon
 * 
 */
public class MenuMamiferos {
	static ListaMamiferos catalogo = new ListaMamiferos();

	public static void main(String[] args) {
		Menu menu = new Menu("**Catalogo de Mamiferos", new String[] {
				"Anadir Mamifero", "Listar mamiferos", "Listar humanos",
				"Listar focas en orden inverso", "Contar murcielagos",
				"Alimentar a todos los mamiferos del catalogo",
				"ordenar por nombre" });
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
					ordenarAnimales();
					break;
				case 8:
					System.out.println("Adios!");
					return;
				}
			} catch (ListaVaciaException e) {
				System.out.println(e.getMessage());
			}
		} while (menu.getOpcion() != 8);
	}

	private static void ordenarAnimales() {
		catalogo.ordenar();
		for (Mamifero m : catalogo.catalogo())
			System.out.println(m.getNombre());
	}

	private static void alimentar() throws ListaVaciaException {
		if (catalogo.isEmpty())
			throw new ListaVaciaException(
					"introduce animales antes de alimentar al aire");

		for (Mamifero mamifero : catalogo.catalogo())
			System.out.println(mamifero.getNombre() + " "
					+ mamifero.alimentar());

	}

	private static void cuentaMurcielagos() throws ListaVaciaException {
		if (catalogo.isEmpty())
			throw new ListaVaciaException("introduce algun murcielago primero");

		int cantidad = 0;

		for (Mamifero mamifero : catalogo.catalogo()) {
			if (mamifero instanceof Murcielago)
				cantidad++;
		}
		System.out.println("hay " + cantidad + " murcielagos");

	}

	/**
	 * Si el catalogo no esta vacio, recorre en orden inverso el listado de
	 * focas
	 * 
	 * @throws ListaVaciaException
	 */
	private static void listaFocas() throws ListaVaciaException {
		if (catalogo.isEmpty())
			throw new ListaVaciaException("introduce focas antes");
		
		ArrayList<Foca> focas = new ArrayList<Foca>();
		for (Mamifero m : catalogo.catalogo()) {
			if (m instanceof Foca)
				focas.add((Foca) m);
		}
		ListIterator<Foca> it = focas.listIterator(focas.size());
		System.out.println("***lista de focas***");
		while (it.hasPrevious())
			System.out.println(it.previous());

	}

	/**
	 * Si el catalogo no esta vacio, recorre el listado de humanos
	 * 
	 * @throws ListaVaciaException
	 */
	private static void listaHumanos() throws ListaVaciaException {
		if (catalogo.isEmpty()) {
			throw new ListaVaciaException("introduce a alguien primero");
		}
		System.out.println("***lista de humanos***");
		for (Mamifero mamifero : catalogo.catalogo()) {
			if (mamifero instanceof HomoSapiens)
				System.out.println((catalogo.catalogo().indexOf(mamifero) + 1)
						+ "- " + mamifero.getNombre() + " etapa: "
						+ mamifero.getEtapa());

		}

	}

	/**
	 * Si el catalogo no esta vacio, muestra y alimenta a todo el catalogo
	 * 
	 * @throws ListaVaciaException
	 */
	private static void listaMamiferos() throws ListaVaciaException {
		if (catalogo.isEmpty())
			throw new ListaVaciaException("introduce animales primero");
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
					catalogo.add(new HomoSapiens(bautizar()));
					break;
				case 2:
					catalogo.add(new Murcielago(bautizar()));
					break;
				case 3:
					catalogo.add(new Foca(bautizar()));
					break;
				case 4:
					System.out.println("Hasta luego");
					return;
				}
			} catch (AnimalExisteException e) {
				System.out.println(e.getMessage());
			} catch (NombreInvalidoException e) {
				System.out.println(e.getMessage());
			}
		} while (menu2.getOpcion() != 4);
	}

	/**
	 * asigna un nombre al nuevo mamifero
	 * 
	 * @return
	 */
	private static String bautizar() {
		String cadena = Teclado.leerCadena("introduce un nombre");
		return cadena;
	}

}
