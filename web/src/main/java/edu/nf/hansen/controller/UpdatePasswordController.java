package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.UpdatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Achine
 * @date 2019/12/2
 */
@RestController
public class UpdatePasswordController extends BaseController {
    @Autowired
    @Qualifier("updatePasswordService")
    private UpdatePasswordService service;

    @PostMapping("/updatePassword")
    public ResponseVO updatePassword(Users user, String newPassword){
        service.updatePwd(user, newPassword);
        return success("修改成功");
    }
}
