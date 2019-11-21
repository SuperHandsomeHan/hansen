package edu.nf.hansen.service;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.entity.Users;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/21
 */
public interface UserListService {
    PageInfo<List<Users>> listUser(Integer pageNum, Integer pageSize);
}