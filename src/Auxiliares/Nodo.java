package Auxiliares;
/**
 * La clase Nodo implementa la interfaz Position.
 * Representa un nodo en una estructura de datos enlazada.
 */
public class Nodo<E> implements Position<E> {
    private E elemento;
    private Nodo<E> siguiente;
    private Nodo<E> anterior;
    
    /**
     * Crea un nuevo nodo con un elemento dado, y referencias al nodo anterior y siguiente.
     * 
     * @param elemento El elemento almacenado en el nodo.
     * @param anterior El nodo anterior en la estructura.
     * @param siguiente El nodo siguiente en la estructura.
     */
    public Nodo(E elemento, Nodo<E> anterior, Nodo<E> siguiente) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    
    /**
     * Crea un nuevo nodo nulo.
     */
    public Nodo() {
        this.elemento = null;
        this.anterior = null;
        this.siguiente = null;
    }
    
    /**
     * Establece el elemento almacenado en el nodo.
     * 
     * @param elemento El nuevo elemento a establecer.
     */
    public void setElem(E elemento) {
        this.elemento = elemento;
    }
    
    /**
     * Establece el nodo siguiente en la estructura.
     * 
     * @param siguiente El nodo siguiente.
     */
    public void setNext(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Establece el nodo anterior en la estructura.
     * 
     * @param anterior El nodo anterior.
     */
    public void setPrev(Nodo<E> anterior) {
        this.anterior = anterior;
    }
    
    /**
     * Devuelve el elemento almacenado en el nodo.
     * 
     * @return El elemento del nodo.
     */
    public E element() {
        return this.elemento;
    }
    
    /**
     * Devuelve el nodo siguiente en la estructura.
     * 
     * @return El nodo siguiente.
     */
    public Nodo<E> getNext() {
        return this.siguiente;
    }
    
    /**
     * Devuelve el nodo anterior en la estructura.
     * 
     * @return El nodo anterior.
     */
    public Nodo<E> getPrev() {
        return this.anterior;
    }
}
