package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.AttendanceDao;
import edu.nf.hansen.dao.GoodsDao;
import edu.nf.hansen.dao.RepairInfoDao;
import edu.nf.hansen.dao.UserDao;
import edu.nf.hansen.service.PersonalService;
import edu.nf.hansen.service.statistics.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2019/12/3
 */
@Service("personalService")
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private RepairInfoDao repairInfoDao;

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Personal getPersonal(String uid) {
        Personal personal = new Personal(uid);
        personal.setAttendanceDao(attendanceDao);
        personal.setGoodsDao(goodsDao);
        personal.setRepairInfoDao(repairInfoDao);
        personal.setUserDao(userDao);
        return personal;
    }
}
