package edu.nf.hansen.service.exception;

/**
 * @author Achine
 * @date 2019/11/21
 */
public class UserInfoException extends RuntimeException{
    public UserInfoException(String message) {
        super(message);
    }

    public UserInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInfoException(Throwable cause) {
        super(cause);
    }
}
