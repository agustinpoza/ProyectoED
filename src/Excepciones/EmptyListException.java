package Excepciones;
/**
 * error, la lista esta vacia
 */
public class EmptyListException extends Exception {
	public EmptyListException(String msg) {
		super(msg);
	}
}
