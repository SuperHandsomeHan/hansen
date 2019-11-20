package edu.nf.hansen.dao;

import edu.nf.hansen.config.AppConfig;
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
    public void getUserById() {
    }

    @Test
    public void getUserByTel() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void updateUser() {
    }
}
