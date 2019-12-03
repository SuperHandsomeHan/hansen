package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.UpdatePasswordService;
import edu.nf.hansen.service.exception.UserInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2019/12/2
 */
@Service("updatePasswordService")
public class UpdatePasswordServiceImpl implements UpdatePasswordService {
    @Autowired
    private UserDao dao;

    @Override
    public void updatePwd(Users user, String newPassword) {
        Users u = dao.getUserById(user.getUid());
        if(!user.getPassword().equals(u.getPassword())){
            throw new UserInfoException("密码错误");
        }
        try {
            u.setPassword(newPassword);
            dao.updateUser(u);
        }catch (RuntimeException e){
            throw new UserInfoException(e);
        }
    }
}
