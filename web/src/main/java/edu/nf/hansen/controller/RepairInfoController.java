package edu.nf.hansen.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Goods;
import edu.nf.hansen.entity.RepairInfo;
import edu.nf.hansen.entity.Users;
import edu.nf.hansen.service.GoodsService;
import edu.nf.hansen.service.RepairInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/21
 */
@RestController
public class RepairInfoController extends BaseController {
    @Autowired
    @Qualifier("repairInfoService")
    private RepairInfoService service;

    @GetMapping("/list_repairInfo")
    public ResponseVO<PageInfo<List<RepairInfo>>> listRepairInfo(Integer pageNum, Integer pageSize){
        return success(service.listRepairInfo(pageNum, pageSize));
    }

    @GetMapping("/get_repairInfo")
    public ResponseVO getRepairInfoById(String rid){
        return success(service.getRepairInfoById(rid));
    }

    @PostMapping("/update_repairInfo")
    public ResponseVO updateRepairInfo(RepairInfo repairInfo){
        service.updateRepairInfo(repairInfo);
        return success("修改成功！");
    }

    @PostMapping("/add_repairInfo")
    public ResponseVO addGRepairInfo(RepairInfo repairInfo, String uid, Integer gid){
        System.out.println(uid);
        System.out.println(gid);
        Users user = new Users();
        user.setUid(uid);
        Goods g = new Goods();
        g.setGid(gid);
        repairInfo.setUser(user);
        repairInfo.setGoods(g);
        service.addRepairInfo(repairInfo);
        return success("添加成功！");
    }

}
