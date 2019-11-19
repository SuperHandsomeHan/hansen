package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.LoginService;
import edu.nf.hansen.service.exception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2019/11/19
 */
@Service("pwdLoginService")
public class PasswordLoginServiceImpl implements LoginService {
    @Autowired
    private UserDao dao;

    /**
     * 用户根据密码登录
     * @param tel
     * @param pwd
     */
    @Override
    public void login(String tel, String pwd) {
        Users user = dao.getUserByTel(tel);
        if(user == null || !user.getPassword().equals(pwd)){
            throw new LoginException("账号或密码错误");
        }
    }
}
