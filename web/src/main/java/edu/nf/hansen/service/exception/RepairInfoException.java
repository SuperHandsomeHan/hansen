package edu.nf.hansen.service.exception;

/**
 * @author Achine
 * @date 2019/11/23
 */
public class RepairInfoException extends RuntimeException {
    public RepairInfoException(String message) {
        super(message);
    }

    public RepairInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepairInfoException(Throwable cause) {
        super(cause);
    }
}
