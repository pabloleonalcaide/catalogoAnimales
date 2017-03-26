package catalogo;

/**
 * 
 * @author pablo
 * 
 */
public abstract class Mamifero {

	private String nombre;
	private Etapa etapa;
	private int amamantado;

	/**
	 * Establecemos por defecto la etapa como cria, pues cada mamifero nacera
	 * cuando lo creemos, Dejamos por defecto el valor de amamantado a 0 por la
	 * misma razon.
	 * 
	 * @param nombre
	 */
	Mamifero(String nombre) {
		setNombre(nombre);
		setEtapa(Etapa.CRIA);
	}
	
	String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) { //PONER SET NOMBRE PRIVATE
		this.nombre = nombre;
	}

	Etapa getEtapa() {
		return etapa;
	}

	private void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	private int getAmamantado() {
		return amamantado;
	}

	private void setAmamantado(int amamantado) {
		this.amamantado = amamantado;
	}
	/**
	 * 	Todos los mamiferos se desarrollan cuando se amamantan
	 * @return mensaje
	 */
	String amamantar() {
		this.setAmamantado(this.getAmamantado() + 1);
		Madurar();
		return "amamantando";
	}
	/**
	 * Si se ha desarrollado lo suficiente, pasa a su etapa adulta
	 */
	private void Madurar() {
		if (this.getAmamantado() == 3) {
			this.setEtapa(Etapa.ADULTO);
		}
	}

	/**
	 * Comprueba si nuestro animalito sigue siendo una cria
	 * 
	 * @return true (cria) false (adulto)
	 */
	protected boolean esPequeño() {
		return this.getEtapa() == Etapa.CRIA;
	}

	/**
	 * todos los mamiferos se amamantan siendo crias y comen al madurar
	 * 
	 * @return mensaje
	 */
	String alimentar() {
		if (esPequeño()) {
			return amamantar();
		}
		return comer();
	}
	/**
	 * La forma de comer va a ser propia de cada especie
	 * @return
	 */
	abstract String comer();
	/**
	 * la forma de desplazarse va a ser propia de cada especie
	 * @return
	 */
	abstract String desplazar();

	@Override
	public String toString() {
		return "Mamifero [nombre=" + getNombre() + ", etapa=" + getEtapa()
				+ ", amamantado: " + amamantado + ", alimentar: " + alimentar()
				+ ", desplazar: " + desplazar();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mamifero other = (Mamifero) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
