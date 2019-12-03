package edu.nf.hansen.service.statistics;

import edu.nf.hansen.dao.AttendanceDao;
import edu.nf.hansen.dao.GoodsDao;
import edu.nf.hansen.dao.RepairInfoDao;
import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.entity.Attendance;
import edu.nf.hansen.entity.Goods;
import edu.nf.hansen.entity.RepairInfo;
import edu.nf.hansen.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Achine
 * @date 2019/12/3
 */
public class Personal {
    private Integer workYear;
    private Double toMonthWages;
    private Double salary;
    private Integer toMonthOrderNum;
    private Integer toMonthAttendanceNum;
    private Double toYearSalary;
    private Integer toYearNotAttendanceNum;
    private Integer toYearLeaveNum;
    private String position;
    private String uid;
    private Calendar calendar;
    private Calendar workCal;
    private UserDao userDao;
    private AttendanceDao attendanceDao;
    private RepairInfoDao repairInfoDao;
    private GoodsDao goodsDao;
    private int nowYear;
    private int nowMonth;
    private int nowDay;

    public Personal(String uid){
        this.uid = uid;
        init();
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getWorkYear() {
        Users user = userDao.getUserById(uid);
        workCal.setTime(user.getJoinTime());
        int workYear = workCal.get(Calendar.YEAR);
        int workMonth = workCal.get(Calendar.MONTH) + 1;
        int workDay = workCal.get(Calendar.DATE);
        //得到年差
        workYear = nowYear - workYear;
        //若目前月数少于开始工作时间的月数，年差-1
        if (nowMonth < workMonth){
            workYear  = workYear - 1;
        }else if (nowMonth == workMonth){
            //当月数相等时，判断日数，若当月的日数小于开始工作时间的日数，年差-1
            if (nowDay < workDay){
                workYear = workYear - 1;
            }
        }
        return workYear;
    }

    public Double getToMonthWages() {
        Users user = userDao.getUserById(uid);
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDateAndId(nowYear + "-" + nowMonth, uid);
        toMonthWages = user.getMoney();
        for (RepairInfo repairInfo : list){
            Goods goods = goodsDao.getGoodsById(String.valueOf(repairInfo.getGoods().getGid()));
            Double price = Double.valueOf(repairInfo.getPrice().toString());
            toMonthWages += (price - goods.getSellPrice()) / 2;
        }
        return toMonthWages;
    }

    public Double getSalary() {
        Users user = userDao.getUserById(uid);
        salary = user.getMoney();
        return salary;
    }

    public Integer getToMonthAttendanceNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDateAndId(nowYear + "-" + nowMonth, uid);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("正常")){
                toMonthAttendanceNum++;
            }
        }
        return toMonthAttendanceNum;
    }

    public Double getToYearSalary() {
        Users user = userDao.getUserById(uid);
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDateAndId(String.valueOf(nowYear), uid);
        for (RepairInfo repairInfo : list){
            Goods goods = goodsDao.getGoodsById(String.valueOf(repairInfo.getGoods().getGid()));
            toYearSalary += (goods.getSellPrice() - goods.getBuyPrice()) * 0.1;
        }
        return toYearSalary;
    }

    public Integer getToYearNotAttendanceNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDateAndId(String.valueOf(nowYear), uid);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("缺勤")){
                toYearNotAttendanceNum++;
            }
        }
        return toYearNotAttendanceNum;
    }

    public Integer getToYearLeaveNum() {
        List<Attendance> list = attendanceDao.listAttendanceByDateAndId(String.valueOf(nowYear), uid);
        for (Attendance attendance : list){
            if(attendance.getAttendanceType().equals("请假")){
                toYearLeaveNum++;
            }
        }
        return toYearLeaveNum;
    }

    public String getPosition() {
        Users user = userDao.getUserById(uid);
        position = user.getGrade().getLevel().getLevelName();
        return position;
    }

    public Integer getToMonthOrderNum() {
        List<RepairInfo> list = repairInfoDao.listRepairInfoByDateAndId(nowYear + "-" + nowMonth, uid);
        toMonthOrderNum = list.size();
        return toMonthOrderNum;
    }

    private void init(){
        calendar = Calendar.getInstance();
        workCal = Calendar.getInstance();
        nowYear = calendar.get(Calendar.YEAR);
        nowMonth = calendar.get(Calendar.MONTH) + 1;
        nowDay = calendar.get(Calendar.DATE);
        clear();
    }

    private void clear(){
        workYear = 0;
        toMonthWages = 0.0;
        salary = 0.0;
        toMonthAttendanceNum = 0;
        toMonthOrderNum = 0;
        toYearSalary = 0.0;
        toYearNotAttendanceNum = 0;
        toYearLeaveNum = 0;
        position = "";
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
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
}
