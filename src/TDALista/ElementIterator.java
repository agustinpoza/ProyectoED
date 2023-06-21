package TDALista;
import java.util.*;

import Auxiliares.Position;
import Excepciones.BoundaryViolationException;
import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;
/**
 * Iterador de elementos de una PositionList.
 * @param <E> tipo de elemento de la lista.
 */
public class ElementIterator<E> implements Iterator<E> {

    protected PositionList<E> list; // Lista a iterar
    protected Position<E> cursor; // Posición del elemento actual

    /**
     * Crea un iterador de elementos para una PositionList dada.
     * @param PositionList a iterar.
     */
    public ElementIterator(PositionList<E> lista) {
        list = lista;
        if (list.isEmpty())
            cursor = null; // Si la lista está vacía, la posición actual es nula
        else {
            try {
                cursor = list.first();
            } catch (EmptyListException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Verifica si hay más elementos para iterar.
     * @return true si hay una posición distinta de null, false en caso contrario.
     */
    public boolean hasNext() {
        return cursor != null;
    }

    /**
     * Devuelve el siguiente elemento en el iterador.
     * @return el siguiente elemento en el iterador.
     * @throws NoSuchElementException si no hay un siguiente elemento.
     */
    public E next() throws NoSuchElementException {
        if (cursor == null)
            throw new NoSuchElementException("Error: no hay siguiente");
        E toReturn = cursor.element(); // Guarda el elemento actual
        try {
            cursor = (cursor == list.last()) ? null : list.next(cursor);
        } catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
}
