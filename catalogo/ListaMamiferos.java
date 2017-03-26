package catalogo;

import java.util.ArrayList;

public class ListaMamiferos {

	protected ArrayList<Mamifero> catalogo = new ArrayList<Mamifero>();

	public ListaMamiferos() {
		
	}
	int size(){
		return catalogo.size();
	}
	void add(Mamifero mamifero) throws AnimalExisteException{
		if(catalogo.contains(mamifero))
			throw new AnimalExisteException("Ese animal ya esta en el catalogo");
		catalogo.add(mamifero);
		
	}
	Mamifero get(int i){
		return catalogo.get(i);
	}
	ArrayList<Mamifero> catalogo (){
		return catalogo;
	}
	

}