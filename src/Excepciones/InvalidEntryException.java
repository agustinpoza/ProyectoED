package Excepciones;

/**
 * La clase InvalidEntryException es una excepción que se lanza cuando se intenta acceder o utilizar
 * una entrada inválida.
 */
public class InvalidEntryException extends Exception {
    /**
     * Construye un nuevo objeto InvalidEntryException con el mensaje de error especificado.
     *
     * @param msg El mensaje de error asociado con la excepción.
     */
    public InvalidEntryException(String msg) {
        super(msg);
    }
}
