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
    private Integer toDayNotLateNum;
    private Integer toDayLeaveNum;
    private Integer toMonthOrderNum;
    private Double toMonthIncome;
    private Integer toMonthNotAttendanceNum;
    private Integer toMonthNotLateNum;
    private Integer toMonthLeaveNum;
    private Calendar calendar;
    private Calendar workCal;
    private AttendanceDao attendanceDao;
    private RepairInfoDao repairInfoDao;
    private GoodsDao goodsDao;

    public Boss(){
        init();
    }

    public Integer getToDayOrderNum() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        String nowDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        toDayOrderNum = list.size();
        return toDayOrderNum;
    }

    public Double getToDayIncome() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        String nowDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        for (RepairInfo repairInfo : list){
            Goods goods = goodsDao.getGoodsById(String.valueOf(repairInfo.getGoods().getGid()));
            Double price = Double.valueOf(repairInfo.getPrice().toString());
            toDayIncome += (price - goods.getSellPrice()) / 2;
        }
        return toDayIncome;
    }

    public Integer getToDayNotAttendanceNum() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        String nowDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("缺勤")){
                toDayNotAttendanceNum++;
            }
        }
        return toDayNotAttendanceNum;
    }

    public Integer getToDayNotLateNum() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        String nowDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("迟到")){
                toDayNotLateNum++;
            }
        }
        return toDayNotLateNum;
    }

    public Integer getToDayLeaveNum() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        String nowDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth + "-" + nowDay);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("请假")){
                toDayLeaveNum++;
            }
        }
        return toDayLeaveNum;
    }

    public Integer getToMonthOrderNum() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDate(nowYear + "-" + nowMonth);
        toMonthOrderNum = list.size();
        return toMonthOrderNum;
    }

    public Double getToMonthIncome() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDate(nowYear + "-" + nowMonth);
        for (RepairInfo repairInfo : list){
            Goods goods = goodsDao.getGoodsById(String.valueOf(repairInfo.getGoods().getGid()));
            Double price = Double.valueOf(repairInfo.getPrice().toString());
            toMonthIncome += (price - goods.getSellPrice()) / 2;
        }
        return toMonthIncome;
    }

    public Integer getToMonthNotAttendanceNum() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("缺勤")){
                toMonthNotAttendanceNum++;
            }
        }
        return toMonthNotAttendanceNum;
    }

    public Integer getToMonthNotLateNum() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
        List<Attendance> list = attendanceDao.listAttendanceByDate(nowYear + "-" + nowMonth);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("迟到")){
                toMonthNotLateNum++;
            }
        }
        return toMonthNotLateNum;
    }

    public Integer getToMonthLeaveNum() {
        String nowYear = String.valueOf(calendar.get(Calendar.YEAR));
        String nowMonth = String.valueOf(calendar.get(Calendar.MONTH));
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
        clear();
    }

    private void clear(){
        toDayOrderNum = 0;
        toDayIncome = 0.0;
        toDayNotAttendanceNum = 0;
        toDayNotLateNum = 0;
        toDayLeaveNum = 0;
        toMonthOrderNum = 0;
        toMonthIncome = 0.0;
        toMonthNotAttendanceNum = 0;
        toMonthNotLateNum = 0;
        toMonthLeaveNum = 0;
    }
}
