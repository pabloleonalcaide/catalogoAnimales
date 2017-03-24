package catalogo;
/**
 * 
 * @author pablo leon alcaide
 *
 */
public class Murcielago extends Mamifero {
	int patas = 2;
	int alas = 2;

	public Murcielago(String nombre) {
		super(nombre);
	}

	@Override
	String comer() {

		return "Comiendo insectos";
	}

	@Override
	String desplazar() {

		return "reptando o nadando";
	}

	@Override
	public String toString() {
		return "\n Murcielago [patas=" + patas + ", alas=" + alas + "toString()"
				+ super.toString() + "]";
	}

}
