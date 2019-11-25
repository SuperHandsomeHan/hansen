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

    void AddAttendance(List<Attendance> list);

    void UpdateAttendance(List<Attendance> list);

    void UpdateAttendanceById(Attendance attendance);
}