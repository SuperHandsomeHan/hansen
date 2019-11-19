package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.GetUserInfoService;
import edu.nf.hansen.service.LoginService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Achine
 * @date 2019/11/19
 */
@RestController
public class LoginController extends BaseController {

    @Qualifier("pwdLoginService")
    private LoginService service;

    @Qualifier("getUserInfoService")
    private GetUserInfoService getUserInfoService;

    @PostMapping("/password_login")
    public ResponseVO login(String tel, String password, HttpSession session){
        service.login(tel, password);
        Users user = getUserInfoService.getUserInfo(tel);
        session.setAttribute("userinfo", user);
        return success("登录成功！");
    }
}
