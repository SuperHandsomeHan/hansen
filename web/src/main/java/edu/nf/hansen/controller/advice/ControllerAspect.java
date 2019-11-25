package edu.nf.hansen.controller.advice;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Achine
 * @date 2019/11/14
 */
@ControllerAdvice("edu.nf.hansen.controller")
public class ControllerAspect {

    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public ResponseVO loginException(LoginException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(UserInfoException.class)
    @ResponseBody
    public ResponseVO userInfoException(UserInfoException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(LevelException.class)
    @ResponseBody
    public ResponseVO levelException(LevelException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(SupplierException.class)
    @ResponseBody
    public ResponseVO supplierException(SupplierException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(GoodsException.class)
    @ResponseBody
    public ResponseVO goodsException(GoodsException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }

    @ExceptionHandler(RepairInfoException.class)
    @ResponseBody
    public ResponseVO repairInfoException(RepairInfoException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
