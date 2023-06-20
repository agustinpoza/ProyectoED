package Excepciones;

/**
 * La clase EmptyPriorityQueueException es una excepción que se lanza cuando se intenta realizar
 * una operación en una cola con prioridad vacía.
 */
public class EmptyPriorityQueueException extends Exception {
    /**
     * Construye un nuevo objeto EmptyPriorityQueueException con el mensaje de error especificado.
     *
     * @param msg El mensaje de error asociado con la excepción.
     */
    public EmptyPriorityQueueException(String msg) {
        super(msg);
    }
}

