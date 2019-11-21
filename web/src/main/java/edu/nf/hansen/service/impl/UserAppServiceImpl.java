package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.UserAppService;
import edu.nf.hansen.service.exception.UserInfoException;
import edu.nf.hansen.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2019/11/21
 */
@Service("userAppService")
public class UserAppServiceImpl implements UserAppService {
    @Autowired
    private UserDao dao;

    @Override
    public void updateUserService(Users user) {
        try {
            dao.updateUser(user);
        }catch (Exception e){
            throw new UserInfoException("修改失败");
        }
    }

    @Override
    public void addUser(Users user) {
        try {
            Users u = dao.getUserByTel(user.getTel());
            if(u != null){
                throw new UserInfoException("该用户已经存在");
            }
            user.setUid(UUIDUtils.createUUID());
            dao.addUser(user);
        }catch (Exception e){
            throw new UserInfoException("添加失败");
        }
    }

    @Override
    public void deleteUser(String uid) {
        try {
            Users u = dao.getUserById(uid);
            if(u == null){
                throw new UserInfoException("该用户不存在");
            }
            dao.deleteUser(uid);
        }catch (Exception e){
            throw new UserInfoException("删除失败");
        }
    }
}
