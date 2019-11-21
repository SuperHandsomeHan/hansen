package edu.nf.hansen.service;

import edu.nf.hansen.entity.Users;

/**
 * @author Achine
 * @date 2019/11/21
 */
public interface UserAppService {

    void updateUserService(Users user);

    void addUser(Users user);

    void deleteUser(String uid);
}