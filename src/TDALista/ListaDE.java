package TDALista;

import java.util.Iterator;

import Auxiliares.Position;
import Excepciones.BoundaryViolationException;
import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;

public class ListaDE<E> implements PositionList<E> {
    protected Nodo<E> header;
    protected Nodo<E> trailer;
    protected int size;
    /**
     * Inicializamos el constructor
     */
    public ListaDE() {
        header = new Nodo<E>();
        trailer = new Nodo<E>();
        header.setSiguiente(trailer);
        trailer.setAnterior(trailer);
        size = 0;
    }

    /**
     * Consultamos por la cantidad de elementos
     * @return cantidad de elementos en la lista
     */
    public int size() {
        return size;
    }

    /**
     * Consulta si la lista esta vacia
     * @return True si la lista esta vacia
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Consulta la posicion del primer elemento
     * @return la posicion del primer elemento de la lista
     * @throws EmptyListException tira una exception si la lista esta vacia
     */
    public Position<E> first() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Lista vacia.");
        }
        return header.getSiguiente();
    }

    /**
     * Devuelve la posicion del ultimo elemento
     * @return posicion del ultimo elemento de la lista.
     * @throws EmptyListException tira una exception si la lista esta vacia
     */
    public Position<E> last() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Lista vacia.");
        }
        return trailer.getAnterior();
    }

    /**
     * 
     * @param p posicion a obtener del siguiente elemento
     * @return la siguiente posicion del parametro p
     * @throws InvalidPositionException,
     * 
     */
    public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        Nodo<E> nodo = checkPosition(p);
        if(nodo.getSiguiente() == trailer){
            throw new BoundaryViolationException("La posicion corresponde al utlimo elemento de la lista.");
        }
        return nodo.getSiguiente();
    }

    /**
	 * Devuelve la posicion del elemento anterior a la posicion pasada por parametro.
	 * @param p Posicion a obtener su elemento anterior.
	 * @return Posicion del elemento anterior a la posicion pasada por parametro.
	 * @throws InvalidPositionException si la posicion pasada por parametro es invalida o la lista esta vacia.
	 * @throws BoundaryViolationException si la posicion pasada por parametro corresponde al primer elemento de la lista.
     */
    public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        Nodo<E> nodo = checkPosition(p);
        if(nodo.getAnterior() == header) {
            throw new BoundaryViolationException("La posicion corresponde al primer elemento de la lista.");
        }
        return nodo.getAnterior();
    }

    /**
     * Inserta un elemento al principio de la lista.
     * @param element Elemento a insertar al principio de la lista.
     */
    public void addFirst(E element) {
        Nodo<E> insert = new Nodo<E>(element, header, header.getSiguiente());
        header.getSiguiente().setAnterior(insert);
        header.setSiguiente(insert);
        size++;
    }

    /**
     * Inserta un elemento al final de la lista.
     * @param element Elemento a insertar al final de la lista.
     */
    public void addLast(E element) {
        Nodo<E> insert;
        if(isEmpty()){
            addFirst(element);
        }
        else {
            insert = new Nodo<E>(element, trailer.getAnterior(), trailer);
            trailer.getAnterior().setSiguiente(insert);
            trailer.setAnterior(insert);
            size++;
        }
    }

    /**
	 * Inserta un elemento luego de la posicion pasada por parametro.
	 * @param p Posicion en cuya posicion siguiente se insertara el elemento pasado por parametro.
	 * @param element Elemento a insertar luego de la posicion pasada como parametro.
	 * @throws InvalidPositionException si la posicion es invalida o la lista esta vacia.
	 */
    public void addAfter(Position<E> p, E element) throws InvalidPositionException {
        Nodo<E> nodo = checkPosition(p);
        Nodo<E> insert;
        if(isEmpty()) {
            throw new InvalidPositionException("Lista vacia.");
        }
        insert = new Nodo<E>(element, nodo, nodo.getSiguiente());
        nodo.getSiguiente().setAnterior(insert);
        nodo.setSiguiente(insert);
        size++;
    }

    /**
	 * Inserta un elemento antes de la posicion pasada como parametro.
	 * @param p Posición en cuya posicipn anterior se insertara el elemento pasado por parámetro. 
	 * @param element Elemento a insertar antes de la posicion pasada como parametro.
	 * @throws InvalidPositionException si la posicion es invalida o la lista esta vacia.
	 */
    public void addBefore(Position<E> p, E element) throws InvalidPositionException {
        Nodo<E> nodo = checkPosition(p);
        Nodo<E> insert;
        if(isEmpty()) {
            throw new InvalidPositionException("Lista vacia.");
        }
        insert = new Nodo<E>(element, nodo.getAnterior(), nodo);
        nodo.getAnterior().setSiguiente(insert);
        nodo.setAnterior(insert);
        size++;
    }

    /**
	 * Remueve el elemento que se encuentra en la posicion pasada por parametro.
	 * @param p Posicion del elemento a eliminar.
	 * @return element Elemento removido.
	 * @throws InvalidPositionException si la posicion es invalida o la lista esta vacia.
	 */	
    public E remove(Position<E> p) throws InvalidPositionException {
        Nodo<E> remove = checkPosition(p);
        E toReturn;
        remove.getAnterior().setSiguiente(remove.getSiguiente());
        remove.getSiguiente().setAnterior(remove.getAnterior());
        size--;
        toReturn = remove.element();
        remove.setElement(null);
        remove.setAnterior(null);
        remove.setSiguiente(null);
        return toReturn;
    }
    /**
	 * Establece el elemento en la posicion pasados por parametro. Reemplaza el elemento que se encontraba anteriormente en esa posici�n y devuelve el elemento anterior.
	 * @param p Posicion a establecer el elemento pasado por parametro.
	 * @param element Elemento a establecer en la posicion pasada por parametro.
	 * @return Elemento anterior.
	 * @throws InvalidPositionException si la posicion es invalida o la lista esta vacia.	 
	 */
    public E set(Position<E> p, E element) throws InvalidPositionException {
        Nodo<E> nodo = checkPosition(p);
        E toReturn;
        if(isEmpty()) {
            throw new InvalidPositionException("Lista vacia.");
        }
        toReturn = nodo.element();
        nodo.setElement(element);
        return toReturn;
    }

    /**
	 * Devuelve un un iterador de todos los elementos de la lista.
	 * @return Un iterador de todos los elementos de la lista.
	 */
    public Iterator<E> iterator() {
        return new ElementIterator<>(this);
    }


	/**
	 * Devuelve una coleccion iterable de posiciones.
	 * @return Una coleccion iterable de posiciones.
	 */
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> toReturn = new ListaDE<Position<E>>();
        Nodo<E> nodo = header.getSiguiente();
        while (nodo != trailer) {
            toReturn.addLast(nodo);
            nodo = nodo.getSiguiente();
        }
        return toReturn;
    }

 
    /**
     * Hace un chequeo de la posicion
     * @param p la posicion
     * @return un casteo de tipo nodo
     * @throws InvalidPositionException si la posicion es invalida
     */
    private Nodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
        try {
            if( p == null )
                throw new InvalidPositionException("Posicion nula.");
            if( p == header )
                throw new InvalidPositionException("Posicion invalida.");
            if( p == trailer )
                throw new InvalidPositionException("Posicion invalida.");
            if( p.element() == null )
                throw new InvalidPositionException("Posicion eliminada previamente.");
            Nodo<E> n = (Nodo<E>) p;
            if ((n.getAnterior() == null) || (n.getSiguiente() == null))
                throw new InvalidPositionException("La posicion no tiene anterior o siguiente");
            return n;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("Posicion no es de tipo Nodo E");
        }
    }

    /**
     * Clase Nodo anidada, permite evitar modificar la lista mediante casting
     * explicito desde la clase cliente.
     * Cliente no debe conocer como funciona la estructura, solamente debe saber
     * que hace.
     * @param <E> generico.
     */
    private class Nodo<E> implements Position<E> {
        private E element;
        private Nodo<E> siguiente;
        private Nodo<E> anterior;

        public Nodo(E element, Nodo<E> anterior,Nodo<E> siguiente) {
            this.element = element;
            this.anterior = anterior;
            this.siguiente = siguiente;
        }

        public Nodo(E element) {
            this(element, null, null);
        }

        public Nodo() {
            this(null, null, null);
        }

        public E element() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo<E> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior) {
            this.anterior = anterior;
        }
    }
}