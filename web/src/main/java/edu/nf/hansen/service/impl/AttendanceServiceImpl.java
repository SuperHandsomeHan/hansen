package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.AttendanceDao;
import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Attendance;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.AttendanceService;
import edu.nf.hansen.service.UserListService;
import edu.nf.hansen.service.exception.AttendanceException;
import edu.nf.hansen.util.TimeNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Achine
 * @date 2019/11/25
 */
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao dao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Attendance> listAttendance() {
        try{
            List<Attendance> list = dao.listAttendance();
            if(list.size() == 0 || list == null){
                list = new ArrayList<>();
                for (Users user : userDao.listUser()){
                    Attendance a = new Attendance();
                    a.setAttendanceId(TimeNameUtils.newRidName());
                    a.setUser(user);
                    a.setAttendanceType("缺勤");
                    a.setAttendanceDate(new Date());
                    a.setAttendanceDate(new Timestamp(a.getAttendanceDate().getTime()));
                    list.add(a);
                }
                dao.addAttendance(list);
            }
            return list;
        }catch (Exception e){
            throw new AttendanceException("服务器异常");
        }
    }

    @Override
    public List<Attendance> listAttendanceByDate(String date) {
        try{
            List<Attendance> list = dao.listAttendanceByDate(date);
            if(list.size() == 0 || list == null){
                throw new AttendanceException("当天没有数据");
            }
            return list;
        }catch (Exception e){
            throw new AttendanceException("当天没有数据");
        }
    }

    @Override
    public void updateAttendance(String[] attendanceId, String[] attendanceType) {
        try{
            List<Attendance> list = new ArrayList<>();
            for (int i = 0; i < attendanceId.length; i++){
                Attendance a = new Attendance();
                a.setAttendanceId(attendanceId[i]);
                a.setAttendanceType(attendanceType[i]);
                System.out.println(attendanceId[i]);
                System.out.println(attendanceType[i]);
                list.add(a);
            }
            dao.updateAttendance(list);
        }catch (Exception e){
            throw new AttendanceException("服务器异常");
        }
    }

    @Override
    public Attendance clockIn(String uid) {
        try {
            Attendance attendance = new Attendance();
            List<Attendance> list = dao.listAttendance();
            if(list.size() == 0 || list == null){
                list = new ArrayList<>();
                for (Users user : userDao.listUser()){
                    Attendance a = new Attendance();
                    a.setAttendanceId(TimeNameUtils.newRidName());
                    a.setUser(user);
                    a.setAttendanceType("缺勤");
                    a.setAttendanceDate(new Date());
                    a.setAttendanceDate(new Timestamp(a.getAttendanceDate().getTime()));
                    list.add(a);
                    if(user.getUid() == uid){
                        attendance = a;
                    }
                }
                dao.addAttendance(list);
            }else{
                attendance = dao.getAttendanceByUid(uid);
            }
            attendance.setAttendanceDate(new Date());
            attendance.setAttendanceDate(new Timestamp(attendance.getAttendanceDate().getTime()));
            dao.updateAttendanceOne(attendance);
            return attendance;
        }catch (Exception e){
            throw new AttendanceException("打卡失败");
        }
    }
}
