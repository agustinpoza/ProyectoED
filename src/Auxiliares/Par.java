package Auxiliares;
import Excepciones.DatoInvalidoException;
/**
 * La clase Par implementa la interfaz Entry.
 * Representa una pareja de valores clave-valor.
 */
public class Par<K, V> implements Entry<K, V> {
    private V lu;
    private K nota;
    
    /**
     * Crea una instancia de Par vacía.
     */
    public Par() {
        this.lu = null;
        this.nota = null;
    }
    
    /**
     * Establece la nota en el Par.
     * 
     * @param nota La nota a establecer.
     * @throws DatoInvalidoException Si la nota es inválida.
     */
    public void setNota(K nota) throws DatoInvalidoException {
        if (nota != null && (Integer) nota >= 0 && (Integer) nota <= 100) {
            this.nota = nota;
        } else {
            throw new DatoInvalidoException("Nota inválida");
        }
    }
    
    /**
     * Establece el Lu en el Par.
     * 
     * @param lu El Lu a establecer.
     * @throws DatoInvalidoException Si el Lu es inválido.
     */
    public void setLu(V lu) throws DatoInvalidoException {
        if (lu != null && (Integer) lu >= 0) {
            this.lu = lu;
        } else {
            throw new DatoInvalidoException("Lu inválido");
        }
    }
    
    /**
     * Devuelve el Lu del Par.
     * 
     * @return El Lu del Par.
     */
    public V getValue() {
        return lu;
    }
    
    /**
     * Devuelve la nota del Par.
     * 
     * @return La nota del Par.
     */
    public K getKey() {
        return nota;
    }
}
