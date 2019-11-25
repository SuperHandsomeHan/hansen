package edu.nf.hansen.service;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.entity.RepairInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/23
 */
public interface RepairInfoService {
    PageInfo<List<RepairInfo>> listRepairInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    RepairInfo getRepairInfoById(String rid);

    void addRepairInfo(RepairInfo repairInfo);

    void updateRepairInfo(RepairInfo repairInfo);
}
