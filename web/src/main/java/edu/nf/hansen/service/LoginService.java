package edu.nf.hansen.service;

import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2019/11/19
 */
public interface LoginService {
    /**
     * 用户登录
     * @param tel
     * @param pwd
     */
    void login(String tel, String pwd);
}