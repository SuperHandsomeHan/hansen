package edu.nf.hansen.service.exception;

/**
 * @author Achine
 * @date 2019/11/21
 */
public class SupplierException extends RuntimeException{
    public SupplierException(String message) {
        super(message);
    }

    public SupplierException(String message, Throwable cause) {
        super(message, cause);
    }

    public SupplierException(Throwable cause) {
        super(cause);
    }
}
