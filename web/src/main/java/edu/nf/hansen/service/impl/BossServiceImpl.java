package edu.nf.hansen.service.impl;

import edu.nf.hansen.dao.AttendanceDao;
import edu.nf.hansen.dao.GoodsDao;
import edu.nf.hansen.dao.RepairInfoDao;
import edu.nf.hansen.service.BossService;
import edu.nf.hansen.service.statistics.Boss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Achine
 * @date 2019/12/3
 */
@Service("BossService")
public class BossServiceImpl implements BossService {
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private RepairInfoDao repairInfoDao;
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Boss getBoss() {
        Boss boss = new Boss();
        boss.setAttendanceDao(attendanceDao);
        boss.setGoodsDao(goodsDao);
        boss.setRepairInfoDao(repairInfoDao);
        return boss;
    }
}
