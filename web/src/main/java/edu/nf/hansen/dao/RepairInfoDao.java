package edu.nf.hansen.dao;

import edu.nf.hansen.entity.RepairInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/22
 */
public interface RepairInfoDao {
    List<RepairInfo> listRepairInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<RepairInfo> listRepairInfoByDate(String date);

    List<RepairInfo> listRepairInfoByDateAndId(String date, String uid);

    RepairInfo getRepairInfoById(String rid);

    void addRepairInfo(RepairInfo repairInfo);

    void updateRepairInfo(RepairInfo repairInfo);
}