package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.SaveUserInfoService;
import edu.nf.hansen.service.exception.UserInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2019/11/27
 */
@Service("saveUserInfoService")
public class SaveUserInfoServiceImpl implements SaveUserInfoService {
    @Autowired
    private UserDao dao;

    @Override
    public void save(Users user) {
        try {
            Users u = dao.getUserById(user.getUid());
            u.setAge(user.getAge());
            u.setSex(user.getSex());
            dao.updateUser(u);
        }catch (Exception e){
            throw new UserInfoException("修改失败");
        }
    }
}
