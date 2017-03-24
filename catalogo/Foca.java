package catalogo;
/**
 * 
 * @author pablo leon alcaide
 *
 */
public class Foca extends Mamifero {
	private int patas = 4;

	public Foca(String nombre) {
		super(nombre);

	}

	@Override
	String comer() {
		return "Comiendo peces, crustaceos o cefalopodos variados";
	}

	@Override
	String desplazar() {
		if (esPequeño()) {
			return "reptando torpemente";
		}
		return "reptando o nadando";
	}

	@Override
	public String toString() {
		return "\nFoca [patas=" + patas + "toString()" + super.toString() + "]";
	}

}
