package edu.nf.hansen.service.impl;

import edu.nf.hansen.config.AppConfig;
import edu.nf.hansen.service.PersonalService;
import edu.nf.hansen.service.statistics.Personal;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class PersonalServiceImplTest {

    @Test
    public void getPersonal() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonalService service = context.getBean(PersonalService.class);
        Personal personal = service.getPersonal("F508C16AC3E84F938695");
        System.out.println(personal.getToMonthWages());
    }
}