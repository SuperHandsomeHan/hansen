package edu.nf.hansen.service.impl;

import edu.nf.hansen.config.AppConfig;
import edu.nf.hansen.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class PasswordLoginServiceImplTest {

    @Test
    public void login() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        LoginService service = context.getBean("pwdLoginService", LoginService.class);
        service.login("13727074222","qq520340");
    }
}
