package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Achine
 * @date 2019/11/20
 */
@RestController
public class SignOutController extends BaseController {

    @GetMapping("/sign_out")
    public ResponseVO signOut(HttpSession session){
        session.removeAttribute("userInfo");
        return success();
    }
}
