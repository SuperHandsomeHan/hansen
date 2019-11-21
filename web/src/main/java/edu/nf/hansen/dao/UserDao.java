package edu.nf.hansen.dao;

import edu.nf.hansen.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/18
 */
public interface UserDao {

    List<Users> listUser(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Users getUserById(String uid);

    Users getUserByTel(String tel);

    void addUser(Users user);

    void updateUser(Users user);

    void deleteUser(String uid);
}