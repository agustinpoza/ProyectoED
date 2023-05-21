package TDALista;
import java.util.*;

import Auxiliares.Position;
import Excepciones.BoundaryViolationException;
import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;
/**
 * iterador de elementos
 */
public class ElementIterator<E> implements Iterator<E> {
	
	protected PositionList<E> list; //lista a iterar
	protected Position<E> cursor; // posicion del elemento corriente
	
	/**
	 * creamos un iterador de elementos de una position list pasada como parametro
	 * @param lista 
	 */
	public ElementIterator(PositionList<E> l) {
		list = l;
		if(list.isEmpty()) cursor = null; // si la lista esta vacia, la posicion corriente es nula
		else
			try {
				cursor = list.first();
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
	}
	/**
	 * nos fijamos si tenemos elementos a iterar
	 * @return true si existe una posicion distinta de null
	 */
	public boolean hasNext() {
		return cursor != null;
	}

	/**
	 * consultamos por el siguiente elemento
	 * @return siguiente elemento en el iterador
	 */
	public E next() throws NoSuchElementException {
		if (cursor == null) throw new NoSuchElementException("error: no hay siguiente");
		E toReturn = cursor.element(); //salvo el elemento corriente
		try {
			cursor = (cursor == list.last()) ? null : list.next(cursor);
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

}
