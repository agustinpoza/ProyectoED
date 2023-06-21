package Auxiliares;
/**
 *	Clase Comparador2, compara los valores entre dos objetos comparables.
 */
public class Comparador2<E> implements java.util.Comparator<E> {

	/**
	 * Compara dos objetos y devuelve un valor que indica su orden relativo.
	 * @param Objeto 1
	 * @param Objeto 2
	 * @return Un entero positivo si el primer argumento es menor al segundo, un entero negativo si es mayor y cero si son iguales
	 */
	public int compare(E o1, E o2) {
		return (((Comparable<E>) o1).compareTo(o2))*-1;
	}
}