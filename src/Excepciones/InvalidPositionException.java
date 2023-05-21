package Excepciones;
/**
 * error la posicion es invalida
 */
public class InvalidPositionException extends Exception {
	public InvalidPositionException(String msg) {
		super(msg);
	}
}
