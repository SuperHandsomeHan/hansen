package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.GetUserInfoService;
import edu.nf.hansen.service.exception.UserInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2019/11/19
 */
@Service("getUserInfoService")
public class GetUserInfoServiceImpl implements GetUserInfoService {
    
    @Autowired
    private UserDao dao;

    /**
     * 获取用户信息
     * @param data
     * @return
     */
    @Override
    public Users getUserInfo(String data) {
        try {
            Users user = dao.getUserById(data);
            if (user == null) {
                user = dao.getUserByTel(data);
                if (user == null) {
                    throw new UserInfoException("没有该用户");
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }catch(UserInfoException e){
            throw e;
        }catch(RuntimeException e){
            throw new RuntimeException("服务器异常");
        }
    }
}
