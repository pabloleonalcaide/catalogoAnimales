package catalogo;
/**
 * 
 * @author pablo leon alcaide
 *
 */
public class Murcielago extends Mamifero {
	private int patas = 2;
	private int alas = 2; 

	public Murcielago(String nombre) throws NombreInvalidoException {
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
