package catalogo;

/**
 * 
 * @author pablo leon alcaide
 *
 */
public class HomoSapiens extends Mamifero {

	private int piernas = 2;
	private int brazos = 2;

	public HomoSapiens(String nombre) throws NombreInvalidoException {
		super(nombre);

	}

	@Override
	String comer() {
		return "Comiendo de todo";
	}

	@Override
	String desplazar() {
		if (esPequeño()) {
			return "gateando";
		}
		return "corriendo";
	}

	@Override
	public String toString() {
		return "\nHomoSapiens [piernas=" + piernas + ", brazos=" + brazos
				+ "toString()" + super.toString() + "]";
	}

}
