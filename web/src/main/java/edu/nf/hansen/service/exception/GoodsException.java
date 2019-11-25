package edu.nf.hansen.service.exception;

/**
 * @author Achine
 * @date 2019/11/22
 */
public class GoodsException extends RuntimeException {
    public GoodsException(String message) {
        super(message);
    }

    public GoodsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodsException(Throwable cause) {
        super(cause);
    }
}
