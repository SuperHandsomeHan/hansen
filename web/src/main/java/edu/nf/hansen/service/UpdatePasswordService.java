package edu.nf.hansen.service;

import edu.nf.hansen.entity.Users;

/**
 * @author Achine
 * @date 2019/12/2
 */
public interface UpdatePasswordService {
    void updatePwd(Users user, String newPassword);
}