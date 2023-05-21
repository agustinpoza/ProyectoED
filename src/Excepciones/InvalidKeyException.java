package Excepciones;
/**
 * error la clave es invalida
 */
public class InvalidKeyException extends Exception{
	public InvalidKeyException(String msg) {
		super(msg);
	}
}
