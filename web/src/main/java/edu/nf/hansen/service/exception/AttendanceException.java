package edu.nf.hansen.service.exception;

/**
 * @author Achine
 * @date 2019/11/25
 */
public class AttendanceException extends RuntimeException {
    public AttendanceException(String message) {
        super(message);
    }

    public AttendanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AttendanceException(Throwable cause) {
        super(cause);
    }
}
