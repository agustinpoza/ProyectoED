package Excepciones;

/**
 * La clase DatoInvalidoException es una excepción que se lanza cuando se intenta
 * asignar un dato que no corresponde al esperado.
 */
public class DatoInvalidoException extends Exception {
    /**
     * Construye un nuevo objeto DatoInvalidoException con el mensaje de error especificado.
     *
     * @param msg El mensaje de error asociado con la excepción.
     */
    public DatoInvalidoException(String msg) {
        super(msg);
    }
}

