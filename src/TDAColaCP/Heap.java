package TDAColaCP;

import java.util.Comparator;

import Auxiliares.Entrada;
import Auxiliares.Entry;
import Excepciones.EmptyPriorityQueueException;
import Excepciones.InvalidKeyException;
/**
 * Clase que modela el comportamiento de una cola con prioridad con arreglo.
 *
 * @param <K> el tipo de la clave.
 * @param <V> el tipo del valor.
 */
public class Heap<K, V> implements PriorityQueue<K, V> {

    protected Entrada<K, V>[] elem;
    protected int size;
    protected Comparator<K> cmp;

    /**
     * Crea una cola con prioridad con un tamaño máximo y un comparador dados.
     *
     * @param maxElem la cantidad máxima de entradas que puede tener inicialmente.
     * @param cmp     el comparador que se utilizará para determinar la prioridad.
     */
    @SuppressWarnings("unchecked")
    public Heap(int maxElem, Comparator<K> cmp) {
        elem = (Entrada<K, V>[]) new Entrada[maxElem];
        size = 0;
        this.cmp = cmp;
    }

    /**
     * Crea una cola con prioridad con un tamaño máximo de 1000 y un comparador dado.
     *
     * @param comp el comparador que se utilizará para determinar la prioridad.
     */
    public Heap(Comparator<K> cmp) {
        this(1000, cmp);
    }

    /**
     * Devuelve la cantidad de entradas de la cola con prioridad.
     *
     * @return la cantidad de entradas.
     */
    public int size() {
        return size;
    }

    /**
     * Verifica si la cola con prioridad está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve la entrada con la menor clave en la cola con prioridad.
     *
     * @return la entrada con la menor clave.
     * @throws EmptyPriorityQueueException si la cola con prioridad está vacía.
     */
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("Cola vacía.");
        }
        return elem[1];
    }

    /**
     * Inserta una entrada en la cola con prioridad.
     *
     * @param key   la clave de la entrada.
     * @param value el valor de la entrada.
     * @return la entrada insertada.
     * @throws InvalidKeyException si la clave es inválida.
     */
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        if (size + 1 >= elem.length) {
            reSize();
        }
        checkKey(key);
        Entrada<K, V> insert = new Entrada<K, V>(key, value);
        elem[++size] = insert;
        int pos = size;
        boolean estado = true;
        while (pos > 1 && estado) {
            Entrada<K, V> elemPos = elem[pos];
            Entrada<K, V> elemParent = elem[pos / 2];
            if (cmp.compare(elemPos.getKey(), elemParent.getKey()) < 0) {
                swap(pos, pos / 2);
                pos = pos / 2;
            } else {
                estado = false;
            }
        }
        return insert;
    }

    /**
     * Elimina y devuelve la entrada con la menor clave en la cola con prioridad.
     *
     * @return la entrada removida.
     * @throws EmptyPriorityQueueException si la cola con prioridad está vacía.
     */
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("Cola vacía.");
        }
        Entrada<K, V> toReturn = elem[1];
        elem[1] = elem[size];
        elem[size--] = null;
        int pos = 1;
        boolean estado = true;
        while (estado) {
            int hi = pos * 2; // Hijo izquierdo
            int hd = pos * 2 + 1; // Hijo derecho
            int posCompare; // Posición a comparar con pos (hi o hd)
            if (elem[hi] == null) {
                estado = false;
            } else {
                if (elem[hi] != null && elem[hd] != null) {
                    if (cmp.compare(elem[hi].getKey(), elem[hd].getKey()) < 0) {
                        posCompare = hi;
                    } else {
                        posCompare = hd;
                    }
                } else {
                    posCompare = hi;
                }
                if (cmp.compare(elem[pos].getKey(), elem[posCompare].getKey()) > 0) {
                    swap(pos, posCompare);
                    pos = posCompare;
                } else {
                    estado = false;
                }
            }
        }
        return toReturn;
    }

    /**
     * Intercambia las entradas correspondientes a las posiciones recibidas.
     *
     * @param pos       la posición del primer elemento a intercambiar.
     * @param posParent la posición del segundo elemento a intercambiar.
     */
    private void swap(int pos, int posParent) {
        Entrada<K, V> aux = elem[pos];
        elem[pos] = elem[posParent];
        elem[posParent] = aux;
    }

    /**
     * Aumenta el tamaño máximo de la cola con prioridad.
     */
    private void reSize() {
        @SuppressWarnings("unchecked")
        Entrada<K, V>[] arr = (Entrada<K, V>[]) new Entrada[elem.length * 2];
        int i = 0;
        for (Entrada<K, V> e : elem) {
            arr[i++] = e;
        }
        elem = arr;
    }

    /**
     * Verifica que la clave sea válida.
     *
     * @param key la clave a verificar.
     * @throws InvalidKeyException si la clave es inválida.
     */
    private void checkKey(K key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("Clave incorrecta.");
        }
    }
}
