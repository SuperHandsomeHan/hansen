package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Achine
 * @date 2019/12/2
 */
@RestController
public class RegisterController extends BaseController {
    @Autowired
    @Qualifier("registerService")
    private RegisterService service;

    @PostMapping("/user_register")
    public ResponseVO register(Users user, HttpSession session){
        Users u = service.register(user);
        session.setAttribute("userInfo", u);
        return success("注册成功");
    }
}
