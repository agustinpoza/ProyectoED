package Auxiliares;
/**
 *	clase auxiliar para crear un comparador que usaremos en el metodo NotaMayorMenor
 */
public class Comparador2<E> implements java.util.Comparator<E> {

	@SuppressWarnings("unchecked")
	/**
	 * compara dos objetos 
	 * @param objeto 1
	 * @param objeto 2
	 * @return un entero positivo si el primer argumento es menor al segundo, un entero negativo si es mayor y cero si son iguales
	 */
	public int compare(E o1, E o2) {
		return (((Comparable<E>) o1).compareTo(o2))*-1;
	}
}