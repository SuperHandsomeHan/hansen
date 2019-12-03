package edu.nf.hansen.dao;

import edu.nf.hansen.entity.Attendance;
import edu.nf.hansen.entity.Users;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/25
 */
public interface AttendanceDao {
    List<Attendance> listAttendance();

    List<Attendance> listAttendanceByDate(String date);

    List<Attendance> listAttendanceByDateAndId(String date, String uid);

    Attendance getAttendanceByUid(String uid);

    void addAttendance(List<Attendance> list);

    void updateAttendance(List<Attendance> list);

    void updateAttendanceOne(Attendance attendance);
}