package homework09.question04.working;

/**
 * Created by Bhanu on 20/04/2016.
 */
public class EmptyHeapException extends Exception {

    public EmptyHeapException(String msg) {
        super(msg);
    }

    public EmptyHeapException(String msg, Throwable t) {
        super(msg, t);
    }
}