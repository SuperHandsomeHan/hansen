package edu.nf.hansen.dao;

import edu.nf.hansen.config.AppConfig;
import edu.nf.hansen.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.awt.AppContext;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void listUser() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDao dao = context.getBean(UserDao.class);
        dao.listUser(0,10).forEach((user) -> System.out.println(user.getUserName()));
    }

    @Test
    public void testListUser() {
    }

    @Test
    public void testGetUserById() {
    }

    @Test
    public void testGetUserByTel() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDao dao = context.getBean(UserDao.class);
        Users user = dao.getUserByTel("13727074222");
        System.out.println(user.getUid() + ":" + user.getUserName());
    }

    @Test
    public void testAddUser() {
    }

    @Test
    public void testUpdateUser() {
    }

}
