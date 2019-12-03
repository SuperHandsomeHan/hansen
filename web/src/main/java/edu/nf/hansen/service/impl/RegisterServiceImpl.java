package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.RegisterService;
import edu.nf.hansen.service.exception.UserInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Achine
 * @date 2019/12/2
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserDao dao;

    @Override
    public Users register(Users user) {
        Users u = dao.getUserByTel(user.getTel());
        if(u == null){
            throw new UserInfoException("该用户还没录入系统");
        }
        if(u.getPassword() != null || u.getJoinTime() != null){
            throw new UserInfoException("该用户已经存在");
        }
        if(!user.getUserName().equals(u.getUserName())){
            throw new UserInfoException("用户名错误");
        }
        try {
            u.setPassword(user.getPassword());
            u.setJoinTime(new Date());
            u.setJoinTime(new Timestamp(u.getJoinTime().getTime()));
            dao.updateUser(u);
            return u;
        }catch (Exception e){
            throw new UserInfoException("服务器异常");
        }
    }
}
