package edu.nf.hansen.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.dao.RepairInfoDao;
import edu.nf.hansen.entity.RepairInfo;
import edu.nf.hansen.service.RepairInfoService;
import edu.nf.hansen.service.exception.RepairInfoException;
import edu.nf.hansen.util.TimeNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Achine
 * @date 2019/11/23
 */
@Service("repairInfoService")
public class RepairInfoServiceImpl implements RepairInfoService {
    @Autowired
    private RepairInfoDao dao;

    @Override
    public PageInfo<List<RepairInfo>> listRepairInfo(Integer pageNum, Integer pageSize) {
        List<RepairInfo> list = dao.listRepairInfo(pageNum, pageSize);
        List<RepairInfo> newList = new ArrayList<>();
        for (RepairInfo info : list){
            info.setRtime(new Timestamp(info.getRtime().getTime()));
            newList.add(info);
        }
        try{
            return new PageInfo(newList);
        }catch (Exception e){
            throw new RepairInfoException("服务器异常");
        }
    }

    @Override
    public RepairInfo getRepairInfoById(String rid) {
        try{
            return dao.getRepairInfoById(rid);
        }catch (Exception e){
            throw new RepairInfoException("服务器异常");
        }
    }

    @Override
    public void addRepairInfo(RepairInfo repairInfo) {
        try{
            repairInfo.setRid(TimeNameUtils.newRidName());
            repairInfo.setStatus("排队中");
            repairInfo.setRtime(new Date());
            repairInfo.setRtime(new Timestamp(repairInfo.getRtime().getTime()));
            dao.addRepairInfo(repairInfo);
        }catch (Exception e){
            throw new RepairInfoException("服务器异常");
        }
    }

    @Override
    public void updateRepairInfo(RepairInfo repairInfo) {
        try{
            dao.updateRepairInfo(repairInfo);
        }catch (Exception e){
            throw new RepairInfoException("服务器异常");
        }
    }
}
