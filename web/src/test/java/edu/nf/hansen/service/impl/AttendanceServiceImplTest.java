package edu.nf.hansen.service.impl;

import edu.nf.hansen.config.AppConfig;
import edu.nf.hansen.service.AttendanceService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class AttendanceServiceImplTest {

    @Test
    public void listAttendance() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AttendanceService service =  context.getBean("attendanceService", AttendanceService.class);
        service.listAttendance().forEach((a) -> System.out.println(a.getAttendanceId()));
    }
}