package Auxiliares;
/**
 * Clase Entrada que implementa la interfaz Entry.
 */
public class Entrada<K, V> implements Entry<K, V> {
    private K clave;
    private V valor;

    /**
     * Inicializa una entrada con una clave y un valor.
     *
     * @param clave la clave de la entrada.
     * @param valor el valor asociado a la clave.
     */
    public Entrada(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    /**
     * Obtiene la clave de la entrada.
     *
     * @return la clave de la entrada.
     */
    public K getKey() {
        return clave;
    }

    /**
     * Obtiene el valor de la entrada.
     *
     * @return el valor de la entrada.
     */
    public V getValue() {
        return valor;
    }

    /**
     * Establece la clave de la entrada.
     *
     * @param clave la clave a establecer.
     */
    public void setKey(K clave) {
        this.clave = clave;
    }

    /**
     * Establece el valor de la entrada.
     *
     * @param valor el valor a establecer.
     */
    public void setValue(V valor) {
        this.valor = valor;
    }

    /**
     * Genera una representación en forma de cadena de la entrada, mostrando sus valores.
     *
     * @return una cadena en la forma "(clave, valor)" que representa la entrada.
     */
    public String toString() {
        return "(" + getKey() + "," + getValue() + ")";
    }
}
