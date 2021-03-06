package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.GetUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Achine
 * @date 2019/11/19
 */
@RestController
public class UserInfoController extends BaseController {

    @Autowired
    @Qualifier("getUserInfoService")
    private GetUserInfoService service;

    @GetMapping("/get_user_info")
    public ResponseVO getUserInfoBySession(HttpSession session){
        return success(session.getAttribute("userInfo"));
    }

    @GetMapping("/find_user")
    public ResponseVO<Users> findUserById(String uid){
        return success(service.getUserInfo(uid));
    }
}
