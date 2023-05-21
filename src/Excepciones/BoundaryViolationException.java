package Excepciones;

/**
 * error, nos caemos del arreglo
 */
@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception {
	public BoundaryViolationException(String msg) {
		super(msg);
	}
}
