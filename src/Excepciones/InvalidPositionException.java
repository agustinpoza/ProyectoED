package Excepciones;

/**
 * La clase InvalidPositionException es una excepción que se lanza cuando se intenta acceder o utilizar
 * una posición inválida.
 */
public class InvalidPositionException extends Exception {
    /**
     * Construye un nuevo objeto InvalidPositionException con el mensaje de error especificado.
     *
     * @param msg El mensaje de error asociado con la excepción.
     */
    public InvalidPositionException(String msg) {
        super(msg);
    }
}

