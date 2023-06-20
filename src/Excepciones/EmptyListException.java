package Excepciones;

/**
 * La clase EmptyListException es una excepción que se lanza cuando se intenta realizar
 * una operación en una lista vacía.
 */
public class EmptyListException extends Exception {
    /**
     * Construye un nuevo objeto EmptyListException con el mensaje de error especificado.
     *
     * @param msg El mensaje de error asociado con la excepción.
     */
    public EmptyListException(String msg) {
        super(msg);
    }
}

