package edu.nf.hansen.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.UserListService;
import edu.nf.hansen.service.exception.UserInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/21
 */
@Service("userListService")
public class UserListServiceImpl implements UserListService {
    @Autowired
    private UserDao dao;

    @Override
    public PageInfo<List<Users>> listUser(Integer pageNum, Integer pageSize) {
        try {
            List<Users> list = dao.listUser(pageNum, pageSize);
            if(list == null){
                throw new UserInfoException("服务器没有用户数据");
            }
            PageInfo pageInfo = new PageInfo(list);
            return pageInfo;
        }catch (Exception e){
            throw new UserInfoException("服务器异常错误");
        }
    }

    @Override
    public List<Users> listUser() {
        try {
            List<Users> list = dao.listUser();
            if(list == null){
                throw new UserInfoException("服务器没有用户数据");
            }
            return list;
        }catch (Exception e){
            throw new UserInfoException("服务器异常错误");
        }
    }
}
