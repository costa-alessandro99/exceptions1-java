package model.exceptions;
import java.io.Serial;

public class DomainException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5947915182316068068L;

    public DomainException (String msg) {
        super(msg);
    }
}
