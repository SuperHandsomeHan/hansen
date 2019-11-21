package edu.nf.hansen.service.exception;

/**
 * @author Achine
 * @date 2019/11/19
 */
public class LevelException extends RuntimeException {
    public LevelException(String message) {
        super(message);
    }

    public LevelException(String message, Throwable cause) {
        super(message, cause);
    }

    public LevelException(Throwable cause) {
        super(cause);
    }
}
