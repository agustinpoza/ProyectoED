package Excepciones;
/**
 * error, la cola con prioridad vacia
 */
public class EmptyPriorityQueueException  extends  Exception {
    public EmptyPriorityQueueException(String msg){
        super(msg);
    }
}
