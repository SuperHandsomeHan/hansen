package edu.nf.hansen.controller.advice;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.service.exception.LoginException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Achine
 * @date 2019/11/14
 */
@ControllerAdvice("edu.nf.hansen.controller")
public class ControllerAspect {

    @ExceptionHandler(LoginException.class)
    public ResponseVO handleDataAccessException(LoginException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

}
