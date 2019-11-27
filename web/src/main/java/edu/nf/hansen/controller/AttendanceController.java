package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Attendance;
import edu.nf.hansen.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Achine
 * @date 2019/11/25
 */
@RestController
public class AttendanceController extends BaseController {

    @Autowired
    @Qualifier("attendanceService")
    private AttendanceService service;

    @GetMapping("/list_attendance")
    public ResponseVO<List<Attendance>> listAttendance(){
        return success(service.listAttendance());
    }

    @GetMapping("/list_attendancebyDate")
    public ResponseVO<List<Attendance>> listAttendanceByDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return success(service.listAttendanceByDate(date));
    }

    @PostMapping("/update_attendance")
    public ResponseVO updateAttendance(String[] attendanceId, String[] attendanceType){
        service.updateAttendance(attendanceId, attendanceType);
        return success("保存成功");
    }

    @PostMapping("/clockIn")
    public ResponseVO clockIn(String uid){
        return success(service.clockIn(uid));
    }
}
