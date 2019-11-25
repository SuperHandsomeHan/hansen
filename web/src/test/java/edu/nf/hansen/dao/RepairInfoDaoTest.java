package edu.nf.hansen.dao;

import edu.nf.hansen.config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class RepairInfoDaoTest {

    @Test
    public void listRepairInfo() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        RepairInfoDao dao = context.getBean(RepairInfoDao.class);
        dao.listRepairInfo(0, 5).forEach((r) -> System.out.println(r.getRid()));
    }

    @Test
    public void getRepairInfoById() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        RepairInfoDao dao = context.getBean(RepairInfoDao.class);
        System.out.println(dao.getRepairInfoById("1574500420112").getCarUserName());;
    }
}