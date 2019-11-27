package edu.nf.hansen.service;

import edu.nf.hansen.entity.Attendance;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/25
 */
public interface AttendanceService {

    List<Attendance> listAttendance();

    List<Attendance> listAttendanceByDate(String date);

    void updateAttendance(String[] attendanceId, String[] attendanceType);

    Attendance clockIn(String uid);

}