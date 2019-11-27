package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.SaveUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Achine
 * @date 2019/11/27
 */
public class SaveUserInfoController extends BaseController {
    @Autowired
    @Qualifier("saveUserInfoService")
    private SaveUserInfoService service;

    @PostMapping("/save_userInfo")
    public ResponseVO saveUser(Users user){
        service.save(user);
        return success("保存成功");
    }
}
