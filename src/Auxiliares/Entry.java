package Auxiliares;
/**
 * Interfaz entry.
 */
public interface Entry<K,V> {
	/**
	 * Consulta la clave de la entrada.
	 * @return Clave
	 */
	public K getKey();
	/**
	 * Consulta el valor de la entrada.
	 * @return Valor
	 */
	public V getValue();
}
