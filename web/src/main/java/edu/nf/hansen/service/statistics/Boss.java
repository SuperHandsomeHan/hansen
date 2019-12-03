package edu.nf.hansen.service.statistics;

import edu.nf.hansen.dao.AttendanceDao;
import edu.nf.hansen.dao.GoodsDao;
import edu.nf.hansen.dao.RepairInfoDao;
import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Attendance;
import edu.nf.hansen.entity.Goods;
import edu.nf.hansen.entity.RepairInfo;

import java.util.Calendar;
import java.util.List;

/**
 * @author Achine
 * @date 2019/12/3
 */
public class Boss {
    private Integer toDayOrderNum;
    private Double toDayIncome;
    private Integer toDayNotAttendanceNum;
    private Integer toDayLateNum;
    private Integer toDayLeaveNum;
    private Integer toMonthOrderNum;
    private Double toMonthIncome;
    private Integer toMonthNotAttendanceNum;
    private Integer toMonthLateNum;
    private Integer toMonthLeaveNum;
    private Calendar calendar;
    private Calendar workCal;
    private AttendanceDao attendanceDao;
    private RepairInfoDao repairInfoDao;
    private GoodsDao goodsDao;
    private String nowYear;
    private String nowMonth;
    private String nowDay;

    public Boss(){
        init();
    }

    public Integer getToDayOrderNum() {
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        toDayOrderNum = list.size();
        return toDayOrderNum;
    }

    public Double getToDayIncome() {
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        for (RepairInfo repairInfo : list){
            Goods goods = goodsDao.getGoodsById(String.valueOf(repairInfo.getGoods().getGid()));
            Double price = Double.valueOf(repairInfo.getPrice().toString());
            toDayIncome += (price - goods.getSellPrice()) / 2;
        }
        return toDayIncome;
    }

    public Integer getToDayNotAttendanceNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("缺勤")){
                toDayNotAttendanceNum++;
            }
        }
        return toDayNotAttendanceNum;
    }

    public Integer getToDayLateNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("迟到")){
                toDayLateNum++;
            }
        }
        return toDayLateNum;
    }

    public Integer getToDayLeaveNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("请假")){
                toDayLeaveNum++;
            }
        }
        return toDayLeaveNum;
    }

    public Integer getToMonthOrderNum() {
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDate(nowYear + "-" + nowMonth);
        toMonthOrderNum = list.size();
        return toMonthOrderNum;
    }

    public Double getToMonthIncome() {
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDate(nowYear + "-" + nowMonth);
        for (RepairInfo repairInfo : list){
            Goods goods = goodsDao.getGoodsById(String.valueOf(repairInfo.getGoods().getGid()));
            Double price = Double.valueOf(repairInfo.getPrice().toString());
            toMonthIncome += (price - goods.getSellPrice()) / 2;
        }
        return toMonthIncome;
    }

    public Integer getToMonthNotAttendanceNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("缺勤")){
                toMonthNotAttendanceNum++;
            }
        }
        return toMonthNotAttendanceNum;
    }

    public Integer getToMonthLateNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("迟到")){
                toMonthLateNum++;
            }
        }
        return toMonthLateNum;
    }

    public Integer getToMonthLeaveNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("请假")){
                toMonthLeaveNum++;
            }
        }
        return toMonthLeaveNum;
    }

    public void setAttendanceDao(AttendanceDao attendanceDao) {
        this.attendanceDao = attendanceDao;
    }

    public void setRepairInfoDao(RepairInfoDao repairInfoDao) {
        this.repairInfoDao = repairInfoDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    private void init(){
        calendar = Calendar.getInstance();
        workCal = Calendar.getInstance();
        nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        nowMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        nowDay = "0";
        if(calendar.get(Calendar.DATE) < 10){
            nowDay += String.valueOf(calendar.get(Calendar.DATE));
        }else{
            nowDay = String.valueOf(calendar.get(Calendar.DATE));
        }
        clear();
    }

    private void clear(){
        toDayOrderNum = 0;
        toDayIncome = 0.0;
        toDayNotAttendanceNum = 0;
        toDayLateNum = 0;
        toDayLeaveNum = 0;
        toMonthOrderNum = 0;
        toMonthIncome = 0.0;
        toMonthNotAttendanceNum = 0;
        toMonthLateNum = 0;
        toMonthLeaveNum = 0;
    }
}
