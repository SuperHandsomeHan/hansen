package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Achine
 * @date 2019/11/21
 */
@RestController
public class UserAppController extends BaseController{
    @Autowired
    @Qualifier("userAppService")
    private UserAppService updateService;

    @PostMapping("/update_user")
    public ResponseVO updateUser(Users user){
        updateService.updateUserService(user);
        return success("修改成功！");
    }

    @PostMapping("/add_user")
    public ResponseVO addUser(Users user){
        updateService.addUser(user);
        return success("添加成功！");
    }

    @PostMapping("/delete_user")
    public ResponseVO deleteUser(String uid){
        updateService.deleteUser(uid);
        return success("删除成功！");
    }
}
