package edu.nf.hansen.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.config.AppConfig;
import edu.nf.hansen.entity.Level;
import edu.nf.hansen.service.LevelService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class LevelServiceImplTest {

    @Test
    public void listLevel() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        LevelService service = context.getBean("levelService", LevelService.class);
        PageInfo pageInfo = service.listLevel(0, 10);
        List<Level> list = pageInfo.getList();
        list.forEach((level) -> System.out.println(level.getLevelName()));
    }

    @Test
    public void getLevelById() {
    }

    @Test
    public void addLevel() {
    }

    @Test
    public void updateLevel() {
    }

    @Test
    public void deleteLevel() {
    }
}