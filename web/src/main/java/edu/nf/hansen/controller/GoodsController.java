package edu.nf.hansen.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Goods;
import edu.nf.hansen.entity.Supplier;
import edu.nf.hansen.service.GoodsService;
import edu.nf.hansen.service.SupplierService;
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
public class GoodsController extends BaseController {
    @Autowired
    @Qualifier("goodsService")
    private GoodsService service;

    @GetMapping("/list_goods")
    public ResponseVO<PageInfo<List<Goods>>> listGoods(Integer pageNum, Integer pageSize){
        return success(service.listGoods(pageNum, pageSize));
    }

    @GetMapping("/get_all_goods")
    public ResponseVO<List<Goods>> listGoods(){
        return success(service.listGoods());
    }

    @GetMapping("/get_goods")
    public ResponseVO getGoodsById(String gid){
        return success(service.getGoodsById(gid));
    }

    @PostMapping("/update_goods")
    public ResponseVO updateGoods(Goods goods){
        service.updateGoods(goods);
        return success("修改成功！");
    }

    @PostMapping("/add_goods")
    public ResponseVO addGoods(Goods goods){
        service.addGoods(goods);
        return success("添加成功！");
    }

    @PostMapping("/delete_goods")
    public ResponseVO deleteGoods(String ... gid){
        service.deleteGoods(gid);
        return success("删除成功！");
    }

}
