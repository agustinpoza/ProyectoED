package TDAColaCP;

/**
 * Clase Comparador que implementa la interfaz java.util.Comparator.
 *
 * @param <E> el tipo de elementos a comparar.
 */
public class Comparador<E> implements java.util.Comparator<E> {

    /**
     * Compara dos objetos y devuelve un valor que indica su orden relativo.
     *
     * @param o1 el primer objeto a comparar.
     * @param o2 el segundo objeto a comparar.
     * @return un valor negativo si o1 es menor que o2, cero si son iguales, o un valor positivo si o1 es mayor que o2.
     * @throws ClassCastException si los objetos no son comparables.
     */
    public int compare(E o1, E o2) throws ClassCastException {
        return ((Comparable<E>) o1).compareTo(o2);
    }
}






