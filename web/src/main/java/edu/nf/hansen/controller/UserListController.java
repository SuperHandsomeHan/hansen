package edu.nf.hansen.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/14
 */
@RestController
public class UserListController extends BaseController {

    @Autowired
    @Qualifier("userListService")
    private UserListService service;

    @GetMapping("/list_user")
    public ResponseVO<PageInfo<List<Users>>> listCity(Integer pageNum, Integer pageSize){
        PageInfo<List<Users>> pageInfo = service.listUser(pageNum, pageSize);
        return success(pageInfo);
    }

}
