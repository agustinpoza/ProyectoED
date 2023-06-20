package Excepciones;

/**
 * La clase InvalidKeyException es una excepción que se lanza cuando se intenta utilizar una clave inválida.
 */
public class InvalidKeyException extends Exception {
    /**
     * Construye un nuevo objeto InvalidKeyException con el mensaje de error especificado.
     *
     * @param msg El mensaje de error asociado con la excepción.
     */
    public InvalidKeyException(String msg) {
        super(msg);
    }
}

