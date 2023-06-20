package Excepciones;

/**
 * La clase BoundaryViolationException es una excepción que se lanza cuando se intenta
 * acceder o manipular una estructura de datos más allá de sus límites válidos.
 */
public class BoundaryViolationException extends Exception {
    /**
     * Construye un nuevo objeto BoundaryViolationException con el mensaje de error especificado.
     *
     * @param msg El mensaje de error asociado con la excepción.
     */
    public BoundaryViolationException(String msg) {
        super(msg);
    }
}

